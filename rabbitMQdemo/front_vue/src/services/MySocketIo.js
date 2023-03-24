import {io} from "socket.io-client"
import {toast} from "vue3-toastify"

let socket = io('http://localhost')

socket.on ('connect', () => {
    console.log('Connect')
    toast.info('Socket Connect')
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
