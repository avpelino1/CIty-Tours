<template>
  <div>
    <h1>View Available Itineraries</h1>
    <h2>View Personal Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myItineraries' v-bind:key="itinerary.id">
        <h3 class = 'sub-header'>{{itinerary.name}} </h3>
        {{itinerary.starting_point}} <br>
        {{itinerary.date_of}} <br>
        {{itinerary.user_id}} <br>
        <button> Delete this Itinerary? </button>
    </div>
    <h2>View Friends' Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myFriendsItineraries' v-bind:key="itinerary.id">
        <h3 class = 'sub-header'>{{itinerary.name}} </h3>
        {{itinerary.starting_point}} <br>
        {{itinerary.date_of}} <br>
        {{itinerary.user_id}} <br>
    </div>
    
    <h2>Create a New Itinerary</h2>
    <form v-on:submit.prevent='createItinerary(newItinerary)'>
      <div class='field'>
        <label for = 'name'>Name </label>
        <input type='text' name='name' v-model='newItinerary.name'/>
      </div>
      <div class='field'>
        <label for = 'startingLocation'>Starting Address </label>
        <input type='text' name='starting-location' v-model='newItinerary.startingLocation'/>
      </div>
      <div class='field'>
        <label for = 'date'>Date </label>
        <input type='date' name='description' v-model='newItinerary.date'/>
      </div>
      <div class='actions'>
         <button>Click here to create your Itinerary!</button>
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
            itineraryService.getItineraries();
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