<template>
  <AppNavbar></AppNavbar>
  <div class="router-view">
    <router-view/>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
//import ItemList from '@/views/item/ItemList.vue'
//import Navbar from "@/components/Navbar.vue";
//import MainSection from '@/views/common/Main.vue'
import AppNavbar from "@/components/Navbar.vue";

export default {
  name: 'App',
  components: {
    AppNavbar
    //Navbar,
    //MainSection


  }
}



</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
