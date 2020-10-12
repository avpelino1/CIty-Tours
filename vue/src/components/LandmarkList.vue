<template>
  <div>

    <form v-on:submit.prevent='updateItinerary'>
      <label name ='selectItinerary'>Select Itinerary: </label> 
      <select v-model="updatedItinerary.name">
        <option v-for="itinerary in itineraries" v-bind:key='itinerary.itineraryId'> {{itinerary.name}} </option>
      </select> <br> <br>

      <div class='actions'>
    <button>Click here to update your itinerary!</button> <br>
</div>

    <div class='landmark-list' v-for='landmark in landmarks' v-bind:key='landmark.id'>
      <router-link v-bind:to="{name: 'landmark-details', params: {id: landmark.id} }">
          <h3 class='sub-header'>{{landmark.name}}</h3> <br>
      </router-link>
      <img class='thumbsUp' src = "https://imgur.com/LLPYyXY.png" v-on:click="addThumbsUp"/><img class='thumbsDown' src = "https://imgur.com/lKO2G1K.png" v-on:click="addThumbsDown"/> <br>
          <p class='thumbsUpCount'>{{landmark.thumbsUp}}</p> <p class='thumbsDownCount'>{{landmark.thumbsDown}}</p>

      <p class='description'>{{landmark.description}}</p>
      <br><br>
      <input type="checkbox"/><label name='addToItinerary'> Add to Itinerary </label>
    </div>
    </form>

  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import itineraryService from '../services/ItineraryService.js';

export default {
  name: 'landmark-list',
  data(){
    return{
      landmarks: [],
      newLandmark: {},
      itineraries: [],
      updatedItinerary: {
        name: "",
      },
      
    }
  },

  methods: {
    updateItinerary() {
    },

    addThumbsUp() {
      alert("Thumbs up test");
    },

    addThumbsDown() {
      alert("Thumbs down test");
    }

  },
  
  created() {
    landmarkService.getLandmarks().then((response)=>{
      this.landmarks=response.data;

    }),
    itineraryService.getMyItineraries().then((response)=> {
      this.itineraries=response.data;
    })
  }

}

</script>

<style>
    .landmark-list{
        padding: 5px;
        margin: 5px;
        border: 1px;
        width: 500px;
        background-color: lavender;
    }
    .description{
      color:darkslategray;
    }

    .sub-header {
      display: inline-flex;
    }
    .thumbsUp {
      padding-right: 10px;
      width: 5%;
    }

    .thumbsDown {
      padding-left: 10px;
      width: 5%;
    }

    .thumbsUpCount {
      display: inline-flex;
      padding-left: 2.5%
    }

    .thumbsDownCount {
      display: inline-flex;
      padding-left: 6%
    }
</style>