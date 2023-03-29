const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);
const { createAdapter } = require('@socket.io/redis-adapter');
const { createClient } = require('redis');
const port = process.env.PORT || 3000;
const serverName = process.env.NAME || 'Unknown';

const pubClient = createClient({ host: 'redis', port: 6379 });
const subClient = pubClient.duplicate();

io.adapter(createAdapter(pubClient, subClient));

server.listen(port, () => {
  console.log('Server listening at port %d', port);
  console.log('Hello, I\'m %s, how can I help?', serverName);
});

// Chatroom
let numUsers = 0;

// Авторизация
const jwt = require('jsonwebtoken');
const jwt_key ="uTurgrInrmtmuS91HLRwxO7J4N6tAHvSocoiF3s7w9Ejfxt88NktVActiUbhmY9i"

io.use(function(socket, next){
  console.log('try jwt query')
  console.log(socket.handshake.query.token)
  if (socket.handshake.query && socket.handshake.query.token){
    console.log('token in query')
    jwt.verify(socket.handshake.query.token, jwt_key, function(err, user) {
      if (err) return next(); // next(new Error('Authentication error'));
      socket.user = user;
      next();
    });
  }
  else {
    next()
    // next(new Error('Authentication error'));
  }
}).on('connection', socket => {
  console.log('user incoming')
  console.log(socket.user)

  console.log("new: " + socket.handshake.address )


  // Когда кто то устанавливает соединение с сокетом
  // я отсылаю ему сообщение
  socket.emit('my-name-is', serverName);


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
