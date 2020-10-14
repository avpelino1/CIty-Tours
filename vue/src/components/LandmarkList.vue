<template>
  <div> <br>
      <!-- <div>
        <select id="categoryFilter" v-for='landmark in filteredList'>
          <option value="parksAndGardens">Parks & Gardens</option>
          <option value="museumsAndHistoricalSites">Museums & Historical Sites</option>
          <option value="restaurants">Restaurants</option>
          <option value="shopping">Shopping</option>
          <option value="kidFriendly">Kid-Friendly</option>
        </select>
      </div> -->
    <div class='landmark-list' v-for='landmark in landmarks' v-bind:key='landmark.id'>
      <router-link v-bind:to="{name: 'landmark-details', params: {id: landmark.id} }">
          <h3 class='sub-header'>{{landmark.name}}</h3> <br>
      </router-link>
      <img class='thumbsUp' src = "https://imgur.com/LLPYyXY.png" v-on:click="addThumbsUp(landmark.id)"/><img class='thumbsDown' src = "https://imgur.com/lKO2G1K.png" v-on:click="addThumbsDown(landmark.id)"/> <br>
          <p class='thumbsUpCount'>{{landmark.thumbsUp}}</p> <p class='thumbsDownCount'>{{landmark.thumbsDown}}</p>

      <p class='description'>{{landmark.description}}</p>
      <br><br>
      <input type="checkbox" v-on:click="addLandmark(landmark.id)"/><label name='addToItinerary'> Add to Itinerary </label>
    </div>

  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import reviewService from '../services/ReviewService.js';

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
      newReview: {},
      selectedLandmarks: this.$store.state.selectedLandmarks,
      filter: {
        venueType: {},
        
      }
      
    }
  },

  methods: {
    addThumbsUp(id) {
      this.newReview = {
        "title" : "",
        "thumbsUp" : true,
        "landmarkId" : id
      }
      reviewService.createReview(this.newReview)
      window.location.reload()
    },

    addThumbsDown(id) {
      this.newReview = {
        "title" : "",
        "thumbsDown" : true,
        "landmarkId" : id
      }
      reviewService.createReview(this.newReview)
      window.location.reload()
    },
    addLandmark(id) {
      this.selectedLandmarks.push(id);
    }

  },
  
  created() {
    landmarkService.getLandmarks().then((response)=>{
      this.landmarks=response.data;
    })
  },

  computed: {
    filteredList(){
      return this.landmarks.filter(landmark=>{
        return landmark.indexOf(this.filter) > -1;
      });
    }
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