<template>
  <h1>Форма входа</h1>
  <label>Email: <input type="email" placeholder="email"></label><br>
  <label>Password: <input type="password" placeholder="password"></label><br>
  <button @click="authStore.apiLogin()"> Login </button>
</template>

<script setup>
  import {useAuthStore} from "@/stores/auth";

  const authStore = useAuthStore()

</script>


<style scoped>

</style>
