<template>
  <div> <br>
      <form>
        <p>View Landmarks By Category:</p>
        <select id="categoryFilter" v-model='filter.venueType'>
          <option value="viewAll">View All</option>
          <option value="Parks & Gardens">Parks & Gardens</option>
          <option value="Museums & Historical Sites">Museums & Historical Sites</option>
          <option value="Restaurants">Restaurants</option>
          <option value="Shopping">Shopping</option>
          <option value="Kid-Friendly">Kid-Friendly</option>
        </select>
        <div>

        </div>
      </form>
    <div class='landmark-list' v-for='landmark in filteredList' v-bind:key='landmark.id'>
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
// import itineraryService from '@/services/ItineraryService.js';

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
    // ,
  
    // itineraryService.getMyItineraries().then((response) => {
    //   this.itineraries=response.data;
    // }),

    // itineraryService.getItineraryLandmarks().then((response)=> {
    //   this.destinations=response.data;
    // })
  },

  computed: {
    filteredList(){
      if(this.filter.venueType=='viewAll'){
        return this.landmarks;
      }
      else {
        return this.landmarks.filter(landmark=>{
          return Object.values(landmark).includes(this.filter.venueType);
      });
    }
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