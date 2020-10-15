<template>
  <div class="itinerary-div">
    <div class='header'>
    <br><br><h1 class='header-name'>Your Itinerary Details</h1>
    <router-link class='header-link' :to="{ name: 'itinerary'}">Back to All Itineraries</router-link>
    </div>
    <itineraryUpdate/>
  </div>
</template>

<script>
import itineraryUpdate from '../components/ItineraryUpdate.vue';
export default {
    name: 'itinerary-details',
    components: {
        itineraryUpdate
    },
}
</script>

<style>

.itinerary-div {
  font-family: 'Ubuntu', sans-serif;
}

</style>