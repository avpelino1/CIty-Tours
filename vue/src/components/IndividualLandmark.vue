<template>
  <div class="individual-landmark">
    <router-link :to="{ name: 'landmark' }">Back to Landmarks</router-link>
    <h1 class="landmark-name"> {{ landmark.name }} </h1> 

    <div class="row">
    <div class='landmark-images' v-for='images in landmark.images' v-bind:key='images.imgUrl'>
        <img class="landmark-photos" v-bind:src= images.imgUrl /> <br>
    </div>
    </div>

    <h3 class="venue-type"> {{ landmark.venueType }} </h3> <br> 
    {{ landmark.address }} <br> <br>
    {{ landmark.description }} <br>
    <br>
    <div class='business-hours' v-for='hours in landmark.businessHours' v-bind:key='hours.day_of'>
        {{ hours.day }} : {{ hours.open_time }} - {{ hours.close_time }} <br>
    </div>
    <br>



    
  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';

export default {
    name: 'individual-landmark',

    data() {
       return {
            landmark: {},
       } 
    },

    methods: {
        updateItinerary(){

        }
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
.row {
    display: flex;
}

.landmark-images {
    flex: 33.33%;
    padding: 5px;
}
.landmark-photos {
    float: left;
    width: 600px;
    height: 400px;
    background-size: cover;
    justify-content: center;
}
.individual-landmark {
    font-family: 'Ubuntu', sans-serif;
}

</style>