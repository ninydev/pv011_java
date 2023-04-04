import {connect, io} from "socket.io-client"
import {toast} from "vue3-toastify"
import myLocalStorage from "@/services/myLocalStorage";
import MyLocalStorage from "@/services/myLocalStorage";
import MyLog from "@/services/myLog";

let socket = io('http://localhost', {
    query: {'token': MyLocalStorage.getItem('token')}
})
//
// socket.on( 'connect',  () => {
//     console.log('Connect')
//     toast.info('Socket Connect from Module')
// })
//
// socket.on ('error', () => {
//     console.log('Error')
//     toast.error('Socket Error')
// })
//
//
// socket.on('my-name-is', (data) => {
//     toast.info("connect to:" + data)
// })
//
// socket.on('stay_online', (data) => {
//     toast("stay online at " + data)
// })
//
//
// // Вещаю в свою комнату, что я онлайн
// let i = setInterval(() => {
//     let d = Date.now()
//     MyLog("stay " + d)
//     socket.to('from_user_id_10').emit('stay_online', d)
// }, 1000)


// socket.on('message', (data) => {
//     console.log(data)
//     toast.info("Some message: \n" + data)
// })


// socket.on("new-message", (data) => {
//     console.log(data)
//     toast.info("New Message: " + data.username + " : " + data.message)
// })

console.log('Socket Start')

export default socket
