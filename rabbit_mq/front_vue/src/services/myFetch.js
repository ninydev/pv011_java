import {toast} from "vue3-toastify";

export default function (url, options = {}) {

    return new Promise((resole, reject) => {

        // Настраиваю параметры запроса
        // url = 'http://localhost/' + url
        // console.log('+ Fetch +')
        // console.log(url)

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
                toast.info("Get")
                resole(data)
            })
            .catch(err => {
                console.log(err)
                toast.error(err)
                reject(err)
            })
    })

}
