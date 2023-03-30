<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Cache;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;
use PHPOpenSourceSaver\JWTAuth\Facades\JWTAuth;
use SocketIO\Emitter;
use TCG\Voyager\Models\Post;


use Nowakowskir\JWT\JWT;
use Nowakowskir\JWT\TokenDecoded;
use Nowakowskir\JWT\TokenEncoded;


class PostController extends Controller
{

    /**
     * Получить все посты по апи
     * @return \Illuminate\Database\Eloquent\Collection
     */
    public function index(Request $request){
        $content = Cache::remember('appPosts', 60, function () {
           return Post::all();
        });

        // return response()->json(['error' => 'Unauthenticated.'], 419);

//        try {
//            $redis = new \Redis(); // Using the Redis extension provided client
//            $redis->connect('redis', '6379');
//            $emitter = new Emitter($redis);
//            $emitter->broadcast->emit('new-message', [
//                'username' => 'serverApi: ' . env('NAME', ' Some api Server '),
//                'message' => 'Hello From API'
//            ]);
//        } catch (Exception $exception) {
//            Log::error($exception->getMessage());
//        }

        return $content;
    }


    /**
     * Пример возврата состояния запроса вместе с ошибками
     * @param Request $request
     * @return mixed
     */
    public function withError(Request $request) {
        $content = Cache::remember('appPosts', 60, function () {
            return Post::all();
        });

        $res = [
            'success'=> true, // Результат выполнения запроса
            'data' => $content, // Данные
            'errors' => [] // Сообщения об ошибках
        ];

        $res = [
            'success'=> false, // Результат выполнения запроса
            'data' => $content, // Данные
            'errors' => [
                'Email error',
                'Password Error'
            ] // Сообщения об ошибках
        ];

        return $res;
    }

    //        Storage::cloud()->put("test.json", $content);

}
