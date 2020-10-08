<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link :to="{ name: 'landmark'}"> View Landmarks </router-link><br/>
    <router-link :to="{ name: 'itinerary'}"> View Itineraries </router-link>
  </div>
</template>

<script>


export default {
  name: "home"
};
</script>