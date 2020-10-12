<template>
  <div>
    <router-link :to="{ name: 'landmark' }">Back to Landmarks</router-link>
    <h1 class="landmark-name"> {{ landmark.name }} </h1> 
    <h3 class="venue-type"> {{ landmark.venueType }} </h3> <br> 
    {{ landmark.address }} <br> <br>
    {{ landmark.description }} <br>
    <br>
    <div class='business-hours' v-for='hours in landmark.businessHours' v-bind:key='hours.day_of'>
        {{ hours.day }} : {{ hours.open_time }} - {{ hours.close_time }} <br>
    </div>
    <br>
    <div class='landmark-images' v-for='images in landmark.images' v-bind:key='images.imgUrl'>
        <img v-bind:src= images.imgUrl /> <br>
        
    </div>
    
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