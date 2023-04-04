const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
const { createAdapter } = require('@socket.io/redis-adapter');
const { createClient } = require('redis');
const port = process.env.PORT || 3000;
const serverName = process.env.NAME || 'Unknown';

const pubClient = createClient({ host: 'redis', port: 6379 });
const clientRedis = pubClient.duplicate();
const subClient = pubClient.duplicate();

io.adapter(createAdapter(pubClient, subClient));

server.listen(port, () => {
  console.log('Server listening at port %d', port);
  console.log('Hello, I\'m %s, how can I help?', serverName);
});

// Chatroom
let numUsers = 0; // Количество открытых соединений на сервере

// Количество открытых зарегистрированных пользователей
// Такой способ не подходит, если у меня несколько копий работы с сокетами
let socketByUserId = [];

// Авторизация
const jwt = require('jsonwebtoken');
const jwt_key ="uTurgrInrmtmuS91HLRwxO7J4N6tAHvSocoiF3s7w9Ejfxt88NktVActiUbhmY9i"

io.use(function(socket, next){
  // console.log('try jwt query')
  // console.log(socket.handshake.query.token)
  if (socket.handshake.query && socket.handshake.query.token){
    //console.log('token in query')
    jwt.verify(socket.handshake.query.token, jwt_key, function(err, user) {
      if (err) return next(); // next(new Error('Authentication error'));
      socket.user = user;
      // Если пользователь передал ключ (он зарегистрирован)
      if (socketByUserId[user.id] === undefined)
        socketByUserId[user.id] = 0
      socketByUserId[user.id]++
      // console.log("Зафиксирован вход с ключем. Всего таких: " + socketByUserId[user.id] )
      // console.log(socketByUserId)

      // Добавить вход о пользователе в редис
      try {
        clientRedis.set("New_User_Id_" + user.id, JSON.stringify(user));
        let socketsCount = clientRedis.get("socketByUserId_" + user.id, (err, data) => {
          if (err) {
            console.log("Redis Callback err")
            console.log(err)
            data = 0
          }
          data++
          clientRedis.set("socketByUserId_" + user.id, data);
        });

      } catch (e) {
        console.log("Redis Error")
      }

      //Сообщить всем, кто ждет этого пользователя что он пришел
      socket.to("from_user_id_" + socket.user.id).emit('new_login', {
        user: user,
        message: "new socket open"
      })
      next();
    });
  }
  else {
    next()
    // next(new Error('Authentication error'));
  }
}).on('connection', socket => {

  numUsers++; // Добавлю количество пользователей на сервере
  console.log("++ users count: " + numUsers)
  console.log('user incoming')
  console.log(socket.user)

  if(socket.user) {
    console.log("Create Room for User Id")
    socket.join("by_user_id_" + socket.user.id) // Комната для сообщений к пользователю
    socket.join("from_user_id_" + socket.user.id) // Комната для сообщений от пользователя (например я все еще онлайн)
    socket.to("by_user_id_" + socket.user.id).emit("message", "Message from Room")
  }

  socket.join("from_user_id_10") // Комната для сообщений от пользователя (например я все еще онлайн)



  console.log("new: " + socket.handshake.address )


  // Когда кто то устанавливает соединение с сокетом
  // я отсылаю ему сообщение
  socket.emit('my-name-is', serverName);

  // Напишу запрос
  socket.on('is-online', data =>{
    console.log("кто то спросил - есть ли онлайн такой пользователь: " + data)

    socket.emit('is-online', {
      userId: data,
      isOnline: (socketByUserId[data] !== undefined && socketByUserId[data] !== 0)
    })
    //
    // if (socketByUserId[data] !== undefined && socketByUserId[data] !== 0) {
    //   socket.emit('is-online', {
    //     userId: data,
    //     isOnline: true
    //   })
    // } else {
    //   socket.emit('is-online', {
    //     userId: data,
    //     isOnline: false
    //   })
    // }
  })


  socket.on('new-message', data => {
    console.log(data)
    // we tell the client to execute 'new message'
    socket.broadcast.emit('new-message', {
      username: " Test Message ",
      message: data
    });

    socket.emit('new-message', {
      username: " Test Message ",
      message: data
    })
  });

  // when the user disconnects.. perform this
  socket.on('disconnect', () => {
    --numUsers; // Отминусовал пользователя
    console.log("-- users count: " + numUsers)
    if(socket.user !== undefined) {
      socketByUserId[socket.user.id]--
      // socket.to("from_user_id_" + socket.user.id).emit('disconnect', {
      //   user: socket.user,
      //   message: "socket close"
      // })

      clientRedis.get("socketByUserId_" + socket.user.id, (err, data) => {
        if (err) {
          console.log("Redis Callback err")
          console.log(err)
          data = 0
        }
        data--
        if (data === 0)
          clientRedis.del("socketByUserId_" + socket.user.id)
        else
          clientRedis.set("socketByUserId_" + socket.user.id, data);
      });

      if (socketByUserId[socket.user.id] === 0) {
        console.log("Пользователь закрыл все вкладки")
        // socket.to("from_user_id_" + socket.user.id).emit('disconnect', {
        //   user: user,
        //   message: "All socket closed"
        // })
        delete socketByUserId[socket.user.id]
      } else {
        console.log("Пользователь оставил вкладки Всего таких: " + socketByUserId[socket.user.id] )
      }
      console.log(socketByUserId)
    }
  });

});


/*

  let addedUser = false;

  // when the client emits 'new message', this listens and executes
  socket.on('new message', data => {
    // we tell the client to execute 'new message'
    socket.broadcast.emit('new message', {
      username: socket.username,
      message: data
    });
  });

  // when the client emits 'add user', this listens and executes
  socket.on('add user', username => {
    if (addedUser) return;

    // we store the username in the socket session for this client
    socket.username = username;
    ++numUsers;
    addedUser = true;
    socket.emit('login', {
      numUsers: numUsers
    });
    // echo globally (all clients) that a person has connected
    socket.broadcast.emit('user joined', {
      username: socket.username,
      numUsers: numUsers
    });
  });

  // when the client emits 'typing', we broadcast it to others
  socket.on('typing', () => {
    socket.broadcast.emit('typing', {
      username: socket.username
    });
  });

  // when the client emits 'stop typing', we broadcast it to others
  socket.on('stop typing', () => {
    socket.broadcast.emit('stop typing', {
      username: socket.username
    });
  });

  // when the user disconnects.. perform this
  socket.on('disconnect', () => {
    if (addedUser) {
      --numUsers;

      // echo globally that this client has left
      socket.broadcast.emit('user left', {
        username: socket.username,
        numUsers: numUsers
      });
    }
  });

 */
