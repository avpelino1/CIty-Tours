<template>
  <div>
    {{ landmark.id }} <br>
    {{ landmark.name }} <br>
    {{ landmark.description }} <br>
    {{ landmark.address }} <br>
    {{ landmark.venue_type }} <br>

    <div class='business-hours' v-for='hours in landmark.business_hours' v-bind:key='hours.business_hours'>
        console.log(hours);
        {{ landmark.business_hours }} 
    </div>

    <div class='landmark-images' v-for='images in landmark.images' v-bind:key='images.imgUrl'>
        console.log(images);
        <img src={{ images.imgUrl }} />
        
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