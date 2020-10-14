<template>
  <div>
       <p><router-link :to="{ name: 'itinerary'}">Back to All Itineraries</router-link></p>
      <h1>Your Itinerary Details</h1>
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