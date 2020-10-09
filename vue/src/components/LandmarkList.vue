<template>
  <div>
    <h2 class='sub-header'>List of Landmarks</h2>

    <div class='landmark-list' v-for='landmark in landmarks' v-bind:key='landmark.id'>
      <router-link v-bind:to="{name: 'landmark-details', params: {id: landmark.id} }">
          <h3 class='sub-header'>{{landmark.name}}</h3>
      </router-link>
      <p class='description'>{{landmark.description}}</p>
      <br><br>
      
    </div>

    <h2>Want to add a landmark? Fill out this form!</h2>
    <form v-on:submit.prevent='createLandmark'>
      <div class='field'>
        <label for = 'name'>Name</label>
        <input type='text' name='name' v-model='newLandmark.name'/>
      </div>
      <div class='field'>
        <label for = 'address'>Address</label>
        <input type='text' name='address' v-model='newLandmark.address'/>
      </div>
      <div class='field'>
        <label for = 'description'>Description</label>
        <input type='text' name='description' v-model='newLandmark.description'/>
      </div>
      <div class='field'>
        <label for = 'venue-type'>Venue Type</label>
        <input type='text' name='venue-type' v-model='newLandmark.venueType'/>
      </div>
      <div class='field'>
        <label for = 'images'>List of Image Links (seperated by a comma)</label>
        <input type='text' name='images' v-model='newLandmark.images'/>
      </div>
      <div class='field'>
        <label for = 'business-hours'>Business Hours</label>
        <select name='business-hours' v-model='newLandmark.businessHours'>
          <option>12:00</option>
        </select>
      </div>
      <div class='actions'>
         <button>Click here to add a Landmark!</button>
      </div>
    </form>



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
    
      createLandmark() {

          landmarkService.createLandmark(this.newLandmark);
      },

      retrieveAllLandmarks() {
        landmarkService.getLandmarks().then((response) => {
            this.landmarks = response.date;
        })

      },

      retrieveOneLandmark(id) {
        landmarkService.getOneLandmark(id);

      }

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