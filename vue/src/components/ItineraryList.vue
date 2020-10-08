<template>
  <div>
      <h1>View Available Itineraries</h1>

      <div class='itinerary-list' v-for='itinerary in myItineraries' v-bind:key="itinerary.id">
          {{itinerary.name}} <br>
          {{itinerary.starting_point}}
          {{itinerary.date_of}}
          {{itinerary.user_id}}

  </div>
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
    methods:{
        getMyItineraries() {
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

</style>