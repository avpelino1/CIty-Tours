<template>
  <div>
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