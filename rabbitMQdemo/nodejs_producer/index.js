// Создание сервера
const express = require('express');
const app = express();

const serverName = process.env.NAME || 'Nodejs Producer';
const PORT = process.env.PORT || 3000;

// Связь с сокетом
const { Emitter } = require ("@socket.io/redis-emitter");
const { createClient } = require("redis");

const redisClient = createClient({ url: "redis://redis:6379" });
const emitter = new Emitter(redisClient);

setInterval(() => {
    let d = new Date().toLocaleString()
    console.log('Ping: ' + d)
    emitter.emit("message", d)
}, 30000);

// Подключение rabbit
let amqpChannel, amqpConnection;
const queue = 'test-queue';

const amqp = require("amqplib/callback_api");

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


function sendData (data) {
    // send data to queue

    amqpChannel.sendToQueue(queue, Buffer.from(data));
    console.log(" [x] Sent to rabbit %s", data);
}




app.get("/nodejs-producer/send-msg", (req, res) => {
    console.log("catch send-msg")
    emitter.emit("message", " start rabbit ")
    sendData("Test")
    res.send(" start rabbit ")
});
app.listen(PORT, () => console.log("Server running at port " + PORT));