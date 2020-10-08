<template>
  <div>

  </div>
</template>

<script>
import itineraryService from '../services/ItineraryService.vue';

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