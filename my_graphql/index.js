// Вебсервер
const express = require('express')
// Сервис работы с запросами
const {graphqlHTTP} = require('express-graphql')
// Построение правил ответа
const {buildSchema} = require('graphql')
const {GraphQLObjectType, GraphQLString, GraphQLInt, GraphQLList, GraphQLSchema} = require("graphql/type")

// порт веб сервера
const port = 3000

// Опишем наши данные (Временные)
// В большом проекте - именно тут запросы в разные сервисы
const Authors =  require('./db/Authors')
const Posts =  require('./db/Posts')

// Опишем типы данных
let AuthorType = new GraphQLObjectType( {
    name: 'Author',
    description: 'Описание модели',
    fields: () => ({
        id: {type: GraphQLInt, description: ' Id автора в базе'},
        name: { type: GraphQLString, description: 'В этом поле имя автора' }
    })
})
// Опишем тип запроса
let BloqQueryType = new GraphQLObjectType({
    name: 'blogSchema',
    description: 'Описание запросов к базе блога',
    fields: () => ({
        authors: {
            type:new GraphQLList(AuthorType),
            description: ' All Authors ',
            resolve: () => {
                return Authors
            }
        }
    })
})

// return Authors::all();


// Что фронт имеет право спрашивать
let mySchema = new GraphQLSchema({
    query: BloqQueryType
})


// Запустим сам веб сервер с поддержкой graphQl
const app = express()
app.use('/', graphqlHTTP( {
    schema: mySchema,
    graphiql: true // Поддержка документации (плеер)
}))

app.listen(port)
