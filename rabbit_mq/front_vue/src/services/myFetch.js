import {toast} from "vue3-toastify";
import myLocalStorage from "@/services/myLocalStorage";

export default function (url, options = {}) {

    return new Promise((resole, reject) => {

        // Настраиваю параметры запроса
        // url = 'http://localhost/' + url
        // console.log('+ Fetch +')
        // console.log(url)

        // Подключаем в заголовок JWT
        options.headers = {
            'token': myLocalStorage.getItem('token')
        }


        fetch(url, options)
            .then(response => {
                // Обрабатываю ответ сервера
                if (response.status !== 200)
                    throw new {message: 'Status != 200'}
                try {
                    return response.json()
                } catch (er) {
                    throw new {message: 'Json Error'}
                }
            })
            .then(data => {
                toast.info("Api request Ok")
                resole(data)
            })
            .catch(err => {
                console.log(err)
                toast.error(err)
                reject(err)
            })
    })

}
