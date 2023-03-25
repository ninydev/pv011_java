// Создание сервера
const express = require('express');
const app = express();
const serverName = process.env.NAME || 'Nodejs Producer';
const PORT = process.env.PORT || 3000;


// Связь с сокетом, через Redis
const { Emitter } = require ("@socket.io/redis-emitter");
const { createClient } = require("redis");

const redisClient = createClient({ url: "redis://redis:6379" });
const emitter = new Emitter(redisClient);

// Метод который каждые 30 секунд рассылает всем некое сообщение
setInterval(() => {
    let d = new Date().toLocaleString()
    console.log('Ping: ' + d)
    emitter.emit("message", d + " " + serverName)
}, 30000);



// Связь с сервером очередей сообщений RabbitMQ

let amqpChannel, amqpConnection;
const queue = 'pv011_queue';

const amqp = require("amqplib/callback_api");
const {request, response} = require("express");

amqp.connect('amqp://user:password@rabbit.mq:5672', function(errorConnect, connection) {
    if (errorConnect) {
        console.log(errorConnect)
        process.exit(-1);
    }
    console.log("connect rabbit ok")
    amqpConnection = connection
    connection.createChannel(function(errorChannel, channel) {
        if (errorChannel) {
            console.log(errorChannel)
            process.exit(-1);
        }
        console.log("create rabbit channel ok")
        amqpChannel = channel

        amqpChannel.assertQueue(queue, {
            // durable: false
        });
    });
});

// Получить коллекцию - для теста
app.get('/nodejs-producer/test', (request, response) => {
   let p1 = {id: 1, title: "1 Hello Post", body: "1 Post body"};
   let p2 = {id: 2, title: "2 Hello Post", body: "2 Post body"};

   let res = [p1, p2];

   response.status(200).json(res);
});



// Создание одного маршрута
app.get("/nodejs-producer/send-msg", (req, res) => {
    console.log("catch send-msg")
    // Код аналогичен версии в PHP
    emitter.emit("new-message", "Hello from " + serverName)
    // Отправим сообщение  в очередь сообщений
    amqpChannel.sendToQueue(queue, Buffer.from(serverName));
    console.log(" [x] Sent to rabbit %s", serverName);

    res.send(" start rabbit on " + serverName)
});

// Запустил сервер
app.listen(PORT, () => console.log("Server running at port " + PORT));
