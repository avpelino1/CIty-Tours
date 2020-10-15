<template>
  <div>
    <div class='header'>
        <h1>View Available Itineraries</h1>
    </div>

      <div class="grid-container">

          <div class="grid-child-personal">

    <h2>Personal Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myItineraries' v-bind:key="itinerary.itineraryId">
        <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>
        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br>
        <router-link :to="{ name: 'itinerary-details', params: {id: itinerary.itineraryId}}"> Edit Itinerary </router-link><br><br>
        <button v-on:click.prevent='deleteItinerary(itinerary.itineraryId)'> Delete </button>
    </div>
            </div>

            <div class="grid-child-shared">

    <h2>Itineraries Shared With You</h2>
    <div class='itinerary-list' v-for='itinerary in myFriendsItineraries' v-bind:key="itinerary.id">
        <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        Starting Location: {{itinerary.startingLocation}} <br>
        Date: {{itinerary.date}} <br><br>
        User ID: {{itinerary.userId}} <br>
        Itinerary ID: {{itinerary.itineraryId}} <br>
        
    </div>
    </div>
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
            myFriendsItineraries: [],
        
        }
    },
    methods:{
        deleteItinerary(id) {
            if (
                confirm("Are you sure you want to delete this itinerary? This action cannot be undone.")
            ) {
                itineraryService.deleteItinerary(id)
                
            }
            window.location.reload().then(
                    alert("Itinerary successfully deleted."));
            
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
     .grid-container {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 20px;
    }
    .sub-header{
        color: navy;
    }
   
</style>