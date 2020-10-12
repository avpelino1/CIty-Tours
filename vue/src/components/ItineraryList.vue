<template>
  <div>
    <h1>View Available Itineraries</h1>

    <h2>View Personal Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myItineraries' v-bind:key="itinerary.itineraryId">
        <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>
        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br>
        <p>***MAP GOES HERE***</p>
        <router-link :to="{ name: 'itinerary-details'}"> Edit Itinerary </router-link><br><br>
        <button v-on:click.prevent='deleteItinerary(itinerary.itineraryId)'> Delete </button>
    </div>

    <h2>View Friends' Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myFriendsItineraries' v-bind:key="itinerary.id">
        <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>
        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br>
        <p>***MAP GOES HERE***</p>
    </div>
    
    <h2>Create a New Itinerary</h2>
    <form v-on:submit.prevent='createItinerary(newItinerary)'>
      <div class='field'>
        <label for = 'name'>Name </label> 
        <input type='text' name='name' v-model='newItinerary.name'/>
      </div> <br>
      <div class='field'>
        <label for = 'startingLocation'>Starting Address </label>
        <input type='text' name='starting-location' v-model='newItinerary.startingLocation'/>
      </div> <br>
      <div class='field'>
        <label for = 'date'>Date </label>
        <input type='date' name='description' v-model='newItinerary.date'/>
      </div> <br>
      <div class='actions'>
         <button>Create your Itinerary!</button>
      </div>
    </form>

  </div>
</template>

<script>
import itineraryService from '../services/ItineraryService.js';
import store from '../store/index';

export default {
    name: 'itinerary-list',
    data(){
        return{
            myItineraries: [],
            myFriendsItineraries: [],
            newItinerary: {
                "username" : store.state.user,
            }
        }
    },
    methods:{
        createItinerary() {
            itineraryService.createItinerary(this.newItinerary);
        },
        deleteItinerary(id) {
            itineraryService.deleteItinerary(id);
        },
        getItineraryLandmarks(id){
            itineraryService.getItineraryLandmarks(id);
        }

    },
    created(){
        itineraryService.getMyItineraries().then((response)=>{
            this.myItineraries=response.data;
        });
        itineraryService.getFriendsItineraries().then((response)=>{
            this.myFriendsItineraries=response.data;
        });
    }
}
</script>

<style>
    .itinerary-list{
        padding: 5px;
        margin: 5px;
        border: 1px;
        width: 500px;
        background-color: lavender;
    }
</style>