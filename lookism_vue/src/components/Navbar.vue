<template>
  <div class="navbar">
    <p><router-link to="/main" class="nav-link">Lookism</router-link></p>
    <p><router-link to="/error" class="nav-link">testErrorPage</router-link></p>
    <p><router-link to="/login" class="nav-link">Login</router-link></p>
  </div>
</template>

<script>
export default {
  name: 'AppNavbar'
}
</script>

<style>
.navbar {
  background-color: #FFC7F1;
  padding: 15px;
}

.nav-link {
  color: black;
  margin: 0 10px;
  text-decoration: none;
}

.nav-link:hover {
  color: lightgray;
}
</style>