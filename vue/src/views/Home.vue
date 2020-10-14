<template>
  <div class="home">
    <h1>Home</h1>
    <h4>Welcome, {{this.$store.state.user.username}}!</h4> 

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
  GoogleMaps
};
</script>