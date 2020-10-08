<template>
  <div class='itinerary-list'>
      <div v-for='itinerary in itineraries' v-bind:key='itinerary.id' class='itinerary'>
          <!--
            <router-link :to='{ name: 'ItineraryDetails'}'> View Itinerary Details <router-link>
            -->
    </div>
   </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService.js';
// import ItineraryDetails from './views/ItineraryDetails.vue';

export default {
    name: 'itinerary-list',
    data(){
        return{
            itineraries: []
        }
    },
    created(){
        ItineraryService.getItineraries().then((response)=>{
            this.itineraries = response.data;
        });
    }
}
</script>

<style>
.topic-list {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
</style>