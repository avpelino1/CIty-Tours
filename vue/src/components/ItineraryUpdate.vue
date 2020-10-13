<template>
  <div>
      <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>

        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br><br>

        Remove landmarks:
        <form v-for="destination in destinations" v-bind:key='destination.id'>
            <input type='checkbox'/>
            <label >{{destination.name}}<br></label>
        </form>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService'

export default {
    data() {
        return{
            itinerary: {},
            destinations: [],
        }
    },

    created() {
        ItineraryService.getOneItinerary(this.$route.params.id).then((response)=>{
            this.itinerary=response.data;
            });
        ItineraryService.getItineraryLandmarks(this.$route.params.id).then((response)=>{
            this.destinations=response.data;
        });
        }
    }

</script>

<style>

</style>