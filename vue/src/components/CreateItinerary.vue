<template>
  <div>
     <h2>Create a New Itinerary</h2>
    <form v-on:submit.prevent='createItinerary(newItinerary)'>
      <div class='field'>
        <label for = 'name'>Itinerary Name </label> 
        <input type='text' name='name' v-model='newItinerary.name'/>
      </div> <br>
      <div class='field'>
        <label for = 'startingLocation'>Starting Address </label>
        <input type='text' name='startingLocation' v-model='newItinerary.startingLocation'/>
      </div> <br>
      <div class='field'>
        <label for = 'date'>Start Date </label>
        <input type='date' name='date' v-model='newItinerary.date'/>
      </div> <br>
      <div class='actions'>
         <button>Create your Itinerary!</button>
      </div>
    </form>
  </div>
</template>

<script>
import itineraryService from '../services/ItineraryService.js';

export default {
    name: 'create-itinerary',
    data(){
        return{
            newItinerary: {
                "username" : this.$store.state.user.username,
                "destinations" : this.$store.state.selectedLandmarks
            }
        }
    },
    methods:{
        createItinerary() {
            itineraryService.createItinerary(this.newItinerary);
            this.newItinerary = {
                "username" : this.$store.state.user.username
            }
            window.location.href = "http://localhost:8081/itinerary"
        },

}
}
</script>

<style>

</style>