<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Exception;
use Illuminate\Support\Facades\Cache;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;
use SocketIO\Emitter;
use TCG\Voyager\Models\Post;

class PostController extends Controller
{

    /**
     * Получить все посты по апи
     * @return \Illuminate\Database\Eloquent\Collection
     */
    public function index(){
        $content = Cache::remember('appPosts', 60, function () {
           return Post::all();
        });

        Cache::put('allPosts', $content);

        try {
            $redis = new \Redis(); // Using the Redis extension provided client
            $redis->connect('redis', '6379');
            $emitter = new Emitter($redis);
            $emitter->broadcast->emit('new-message', [
                'username' => 'serverApi: ' . env('NAME', ' Some api Server '),
                'message' => 'Hello From API'
            ]);
        } catch (Exception $exception) {
            Log::error($exception->getMessage());
        }

        return $content;
    }

    //        Storage::cloud()->put("test.json", $content);

}
