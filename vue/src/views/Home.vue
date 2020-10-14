<template>
  <div class="home">
    <div class="header">
      <h1>Home</h1>
      <h4>Welcome, {{this.$store.state.user.username}}!</h4> 
    </div>

    <googleMaps />

    
    <router-link :to="{ name: 'landmark'}"> View a List of Landmarks in Austin, TX  </router-link><br><br>
    <router-link :to="{ name: 'landmark'}"> Create a New Itinerary  </router-link><br><br>
    <router-link :to="{ name: 'itinerary'}"> View or Edit Your Existing Itineraries </router-link>
  </div>
</template>

<script>
import GoogleMaps from '@/components/GoogleMaps.vue'

export default {
  name: "home",
  components: {
  GoogleMaps
  }
};
</script>

<style>
  h1{
    text-align: center;
    padding: 10px 0;
    font-weight: 800;
  }
  h4{
    text-align: center;
    font-weight: 100;
  }
  .header {
    width: 100%;
    padding:60px 0;
    text-align: center;
    background: lavender;
    color: navy;
  }
</style>