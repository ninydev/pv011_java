import {defineStore} from "pinia";
import {toast} from "vue3-toastify";
import myFetch from "@/services/myFetch";
import myLocalStorage from "@/services/myLocalStorage";
import MySocketIo from "@/services/MySocketIo";
import socket from "@/services/MySocketIo";
import MyLocalStorage from "@/services/myLocalStorage";
import {io} from "socket.io-client";

export const useAuthStore = defineStore('auth', {
   state: () => ({
       isAuth: false, // пользователь вошел в систему
       isProcessing: false, // происходит обработка запроса
       token: null, // ключ, полученный от сервера
       user: null
   }),
    actions: {
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
               })
       }
    }

});
