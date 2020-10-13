<template>
  <div>
      <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>

        Your User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br><br>

        <h3>Current Landmarks:</h3>
        <form v-for='destination in destinations' :key='destination.description'>
            {{destination.name}}
            <button v-on:click='removeLandmark(itinerary.id, destination.id)'>-</button>
        </form> <br>

        <h3>Add Landmarks to Your Itinerary:</h3>

        <form v-for='landmark in landmarks' v-bind:key='landmark.id'>
            {{landmark.name}}
            <button v-on:click='addLandmark(itinerary.id, landmark.id)'>+</button>
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

    methods: {
        removeLandmark(itineraryID, landmarkID){
            ItineraryService.removeLandmark(itineraryID, landmarkID);
            window.location.reload();
        },
        addLandmark(itineraryID, landmarkID){
            ItineraryService.addLandmark(itineraryID, landmarkID);
            window.location.reload();
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