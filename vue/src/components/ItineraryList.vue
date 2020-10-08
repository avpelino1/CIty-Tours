<template>
  <div>
      <h1>placeholder</h1>
  </div>
</template>

<script>
import itineraryService from '../services/ItineraryService.js';

export default {
    name: 'itinerary-list',
    data(){
        return{
            myItineraries: [],
            myFriendsItineraries: []
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

</style>