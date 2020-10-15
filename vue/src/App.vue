<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
h1{
  text-align: center
}
#nav{
  background-color: lavender;
  padding-top: 10px;
  padding-left: 10px;
  padding-right: 10px;
  display: flex;
  justify-content: flex-end;
}
/* #app{
  justify-content: right;
} */
</style>