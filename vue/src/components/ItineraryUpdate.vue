<template>
  <div>
      <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>

        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br><br>

        Add/Remove landmarks:
        <form v-for="landmark in landmarks" v-bind:key='landmark.id'>
            <form v-for='destination in destinations' v-bind:key='destination.id'>
                <input type='checkbox' v-if="destination.id==landmark.id" Checked/>
                <input type='checkbox' v-else/>
                <label >{{landmark.name}}<br></label>
            </form>
        </form>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService'
import LandmarkService from '../services/LandmarkService'

export default {
    data() {
        return{
            itinerary: {},
            landmarks: [],
            destinations: [],
        }
    },

    computed:{
        filteredLandmarks: function() {
            
            return this.landmarks;
        }
    },

    created() {
        ItineraryService.getOneItinerary(this.$route.params.id).then((response)=>{
            this.itinerary=response.data;
        });
        LandmarkService.getLandmarks().then((response)=>{
            this.landmarks=response.data;
        });
        ItineraryService.getItineraryLandmarks(this.$route.params.id).then((response)=>{
            this.destinations=response.data;
        });
        }
    }

</script>

<style>

</style>