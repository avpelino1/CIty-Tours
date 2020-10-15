<template>
  <div>
    <div class='header'>
    <h1>Your Itinerary Details</h1>
    <router-link :to="{ name: 'itinerary'}">Back to All Itineraries</router-link>
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

</style>