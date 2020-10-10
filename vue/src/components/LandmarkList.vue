<template>
  <div>
    <h2 class='sub-header'>List of Landmarks</h2>

    <div class='landmark-list' v-for='landmark in landmarks' v-bind:key='landmark.id'>
      <router-link v-bind:to="{name: 'landmark-details', params: {id: landmark.id} }">
          <h3 class='sub-header'>{{landmark.name}}</h3>
      </router-link>
      <p class='description'>{{landmark.description}}</p>
      <br><br>
      <button>Add Landmark to Itinerary<button>
    </div>

  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';

export default {
  name: 'landmark-list',
  data(){
    return{
      landmarks: [],
      newLandmark: {}
    }
  },

  methods: {
      retrieveAllLandmarks() {
        landmarkService.getLandmarks().then((response) => {
            this.landmarks = response.date;
        })
      },
  },
  
  created(){
    landmarkService.getLandmarks().then((response)=>{
      this.landmarks=response.data;
    });
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
</style>