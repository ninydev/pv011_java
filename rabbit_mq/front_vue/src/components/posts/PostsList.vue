<template>
  <h1> Посты на сайте: </h1>

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
import {onMounted} from "vue";
const postsStore = usePostsStore()

onMounted(() => {
  postsStore.loadFromServer()
})

</script>


<style scoped>
</style>
