<template>
  <div>
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
      <!-- <div class='field'>
        <label for = 'business-hours'>Business Hours</label><br> -->
        <!-- <input name='business-hours' v-model='newLandmark.businessHours.value'> -->
          <!-- <label for='1'>Monday </label>
          <input type='text' name='Monday-open' v-model="findDay.value"> - <input type='text' name='Monday-close' v-model="findDay.value"><br>
          <label for='2'>Tuesday </label>
          <input type='text' name='Tuesday-open' v-model="findDay.value"> - <input type='text' name='Tuesday-close' v-model="findDay.value"><br>
          <label for='3'>Wednesday </label>
          <input type='text' name='Wednesday-open' v-model="findDay.value"> - <input type='text' name='Wednesday-close' v-model="findDay.value"><br>
          <label for='4'>Thursday </label>
          <input type='text' name='Thursday-open' v-model="findDay.value"> - <input type='text' name='Thursday-close' v-model="findDay.value"><br>
          <label for='5'>Friday </label>
          <input type='text' name='Friday-open' v-model="findDay.value"> - <input type='text' name='Friday-close' v-model="findDay.value"><br>
          <label for='6'>Saturday </label>
          <input type='text' name='Saturday-open' v-model="findDay.value"> - <input type='text' name='Saturday-close' v-model="findDay.value"><br>
          <label for='7'>Sunday </label>
          <input type='text' name='Sunday-open' v-model="findDay.value"> - <input type='text' name='Sunday-close' v-model="findDay.value"><br>
      </div> -->
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
      newLandmark: {},
      businessHours: []
    }
  },

  methods: {
      createLandmark() {
          landmarkService.createLandmark(this.newLandmark);
      },
      findDay: function () {
        this.businessHours.push({value: ''});
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
</style>