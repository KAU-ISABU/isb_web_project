<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <header>
    <RouterView />
  </header>
</template>

<style>
@import "@/assets/base.css";
@import "@/assets/css/index.css";

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
body {
  padding: 0;
  margin: 0;
}

</style>
