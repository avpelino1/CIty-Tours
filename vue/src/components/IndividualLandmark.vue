<template>
  <div>
    {{ landmark.id }} <br>
    {{ landmark.name }} <br>
    {{ landmark.description }} <br>
    {{ landmark.address }} <br>
    {{ landmark.venue_type }} <br>
    {{ landmark.business_hours }} <br>
    {{ landmark.images }}  <!-- write a loop to display all images -->

    
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
        landmarkService.getOneLandmark(this.$route.params.id).then(
            (response) => {
                this.landmark = response.data;
            }
        );

      
    
    }

}
</script>

<style>
</style>