<template>
  <div class="home">
    <div class="header">
      <h1>City Tour of Austin, TX</h1>
      <h4>Welcome, {{this.$store.state.user.username}}!</h4>
    </div>
        <div class="container">
      <router-link :to="{ name: 'landmark'}"> View a List of Landmarks in Austin, TX  </router-link>
      <router-link :to="{ name: 'landmark'}"> Create a New Itinerary  </router-link>
      <router-link :to="{ name: 'itinerary'}"> View or Edit Your Existing Itineraries </router-link>
    </div>
    
    <googleMaps />
  </div>
</template>

<script>
import GoogleMaps from '@/components/GoogleMaps.vue'

export default {
  name: "home",
  components: {
    GoogleMaps
}
}
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
    padding-top:20px;
    padding-bottom: 20px;
    text-align: center;
    background: lavender;
    color: navy;
  }
  .container {
    display: flex;
    flex-grow: 3;
    justify-content: space-between;
    background: lavender;
    padding-bottom: 10px;
  }
</style>