<script setup la
  components: { SideNav },ng="ts">
  import SideNav from "../components/common/SideNav.vue";
</script>

<template>
  <main class="h-screen w-screen m-0 p-0">
    <router-view :key="$route.fullPath"/>
    <side-nav/>
  </main>
</template>
