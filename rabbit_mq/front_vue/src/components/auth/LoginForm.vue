<template>
  <h1>Форма входа</h1>
  <button @click="authStore.apiLogin()"> Login </button>
</template>

<script setup>
  import {useAuthStore} from "@/stores/auth";

  const authStore = useAuthStore()

</script>


<style scoped>

</style>
