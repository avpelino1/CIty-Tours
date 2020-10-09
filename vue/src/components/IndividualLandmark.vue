<template>
  <div>

      {{landmarkId}}
      {{landmarkName}}

    <!-- <h3 class = 'landmark-name'>{{landmarkName}}</h3> <br>
    <h4 class = 'venue-type'>{{landmark.venue_type}} </h4> <br>
    <p class='landmark-description'> {{landmark.description}} </p> <br>
    <p class='landmark-address'>{{landmark.address}} </p> <br>

     <button class="add-itinerary">Add to Itinerary</button> -->

  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';

export default {
    name: 'individual-landmark',

    data() {
       return {
           landmark: {}
       } 
    },

    methods: {
        
    },

    created() {
        getLandmark() {
            landmarkService.getOneLandmark(this.$route.params.id);
        }
    
    }

}
</script>

<style>

</style>