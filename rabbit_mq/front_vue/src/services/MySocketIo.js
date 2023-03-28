import {connect, io} from "socket.io-client"
import {toast} from "vue3-toastify"
import myLocalStorage from "@/services/myLocalStorage";
import MyLocalStorage from "@/services/myLocalStorage";

let socket = io('http://localhost', {
    query: {'token': MyLocalStorage.getItem('token')}
})

socket.on( 'connect',  () => {
    console.log('Connect')
    toast.info('Socket Connect from Module')
})

socket.on ('error', () => {
    console.log('Error')
    toast.error('Socket Error')
})


socket.on('my-name-is', (data) => {
    toast.info("connect to:" + data)
})


socket.on('message', (data) => {
    console.log(data)
    toast.info("Some message: \n" + data)
})


// socket.on("new-message", (data) => {
//     console.log(data)
//     toast.info("New Message: " + data.username + " : " + data.message)
// })

console.log('Socket Start')

export default socket
