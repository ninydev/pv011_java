// Вебсервер
const express = require('express')
// Сервис работы с запросами
const graphqlHTTP = require('express-graphql')
// Построение правил ответа
const {buildSchema} = require('graphql')

// порт веб сервера
const port = 3000

// Что фронт имеет право спрашивать
let mySchema = buildSchema(`
    type Query {
    postTitle: String,
    blogTitle: String
`)

// Опишем наши данные (Временные)
// В большом проекте - именно тут запросы в разные сервисы
let root = {
    postTitle: () => {
        return ' Post Title '
    },
    blogTitle: () => {
        return ' Blog title'
    }
}

// Запустим сам веб сервер с поддержкой graphQl
const app = express()
app.use('/', graphqlHTTP( {
    schema: mySchema,
    rootValue: root,
    graphiql: true
}))
app.listen(port)
