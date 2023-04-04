import {defineStore} from "pinia";
import {toast} from "vue3-toastify";
import myFetch from "@/services/myFetch";
import myLocalStorage from "@/services/myLocalStorage";
import MySocketIo from "@/services/MySocketIo";
import socket from "@/services/MySocketIo";
import MyLocalStorage from "@/services/myLocalStorage";
import {io} from "socket.io-client";
import MyLog from "@/services/myLog";

export const useAuthStore = defineStore('auth', {
   state: () => ({
       isAuth: false, // пользователь вошел в систему
       isProcessing: false, // происходит обработка запроса
       token: null, // ключ, полученный от сервера
       user: null
   }),
    actions: {
       async isOnline() {
           await socket.emit('is-online', 10)
           console.log("Test")
           await socket.on('is-online', data => {
               toast("user " + data.userId + " online: " + data.isOnline)
           })
       },
       apiLogin() {
           this.isProcessing = true
           myFetch('/api/auth/login', {
               method: "POST",
           })
               .then( data => {
                   console.log(data)
                   this.token = data.token
                   myLocalStorage.setItem('token', data.token, 10000000)
                   this.user = data.user
                   toast.info(data.message)
                   this.isProcessing = false
                   this.isAuth = true
                   socket.close()
                   socket = io('http://localhost', {
                       query: {'token': MyLocalStorage.getItem('token')}
                   })
                   socket.on("message", data => {
                       toast(data)
                   })

                   socket.on('stay_online', (data) => {
                       toast("stay online at " + data)
                   })



                   // Вещаю в свою комнату, что я онлайн
                   let i = setInterval(() => {
                       let d = Date.now()
                       MyLog("stay " + d)
                       socket.to('from_user_id_10').emit('stay_online', d)
                   }, 1000)

               })
       }
    }

});
