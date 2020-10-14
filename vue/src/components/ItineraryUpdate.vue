<template>
  <div>
      <h2 class = 'sub-header'>{{itinerary.name}}</h2>
        <form v-on:submit.prevent='updateItinerary(itinerary)'>
        <div class='field'>
            <label for = 'name'>Name: </label>
            <input type='text' name='name' v-model='itinerary.name'/>
        </div> <br>
        <div class='field'>
            <label for = 'startingLocation'>Starting Address: </label>
            <input type='text' name='startingLocation' v-model='itinerary.startingLocation'/>
        </div> <br>
        <div class='field'>
            <label for = 'date'>Date: </label>
            <input type='date' name='date' v-model='itinerary.date'/>
        </div> <br>
        <div class='actions'>
            <button>Submit</button>
        </div>
        </form>

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
        },

        updateItinerary(itinerary){
            console.log(itinerary);
            ItineraryService.updateItinerary(itinerary);
           // window.location.reload();
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