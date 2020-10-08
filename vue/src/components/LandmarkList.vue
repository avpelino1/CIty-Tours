<template>
  <div>
    <h1>List of Landmarks</h1>

    <div class='landmark-list' v-for='landmark in landmarks' v-bind:key='landmark.id'>
      <p>hello world</p>
      {{landmark.name}} <br>
      {{landmark.description}} <br>
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
      }

  },
  created(){
    landmarkService.getLandmarks().then((response)=>{
      this.landmarks=response.data;
    });
    landmarkService.createLandmark(this.newLandmark)
    .then(window.alert("You have submitted a new landmark for approval."));
  }
}

</script>

<style>
    .landmark-list{
        padding: 5px;
        margin: 5px;
        border: 1px;
        width: 250px;
        background-color: lavender;
    }
</style>