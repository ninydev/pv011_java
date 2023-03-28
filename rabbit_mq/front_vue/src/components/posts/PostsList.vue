<template>
  <h1> Посты на сайте: </h1>

  <LoginForm></LoginForm>

  <div v-if="postsStore.isLoaded">
    <ul>
      <li v-for="post in postsStore.posts" :key="post.id">
        {{post.title}}
      </li>
    </ul>
  </div>

  <div v-else>
    Данные не загружены
  </div>

  <button @click="postsStore.loadFromServer()"> Load </button>

</template>

<script setup>
import {usePostsStore} from "@/stores/posts";
import {onMounted, onUnmounted} from "vue";
import LoginForm from "@/components/auth/LoginForm.vue";
const postsStore = usePostsStore()

onMounted(() => {
  postsStore.loadFromServer()
  postsStore.startSocket()
})

onUnmounted(() => {
  postsStore.stopSocket()
})

</script>


<style scoped>
</style>
