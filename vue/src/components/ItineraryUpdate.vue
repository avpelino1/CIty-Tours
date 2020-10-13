<template>
  <div>
      <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>

        Your User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br><br>

        <h3>Current Landmarks:</h3>
        <form v-for='destination in destinations' :key='destination.description'>
            <button v-on:click='removeLandmark(itinerary.itineraryId, destination.id)'>-</button>
            {{destination.name}}
        </form> <br>

        <h3>Add Landmarks to Your Itinerary:</h3>

        <form v-for='landmark in landmarks' v-bind:key='landmark.id'>
            <button v-on:click.prevent='addLandmark(itinerary.itineraryId, landmark.id)'>+</button>
            {{landmark.name}}
        </form>
       

        <!-- <button v-for='landmark in landmarks' v-bind:key='landmark.id'
        v-on:click.prevent='addLandmark(itinerary.itineraryId, landmark.id)'  
        >+ {{landmark.name}} </button> -->
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
            let notFound = true;
           for (let i = 0; i < this.destinations.length; i++) {
                if (this.destinations[i].id == landmarkID) {
                notFound = false;
                window.alert("You already have this landmark in your current itinerary!")
                break;
                } 
            }
            if (notFound) {
            ItineraryService.addLandmark(itineraryID, landmarkID);
            window.location.reload();
            }
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