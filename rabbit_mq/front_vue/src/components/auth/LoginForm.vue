<template>
  <h1>Форма входа</h1>
  <label>Email: <input type="email" placeholder="email"></label><br>
  <label>Password: <input type="password" placeholder="password"></label><br>
  <button @click="authStore.apiLogin()"> Login </button>
  <button @click="authStore.isOnline()"> test 10 online </button>
</template>

<script setup>
  import {useAuthStore} from "@/stores/auth";

  const authStore = useAuthStore()

</script>


<style scoped>

</style>
