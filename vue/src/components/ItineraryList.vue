<template>
  <div class="itinerary-div">
    <div class='header'>
        <br><br><h1 class='header-name'>View Available Itineraries</h1>
    </div>

      <div class="grid-container">

          <div class="grid-child-personal">

    <h2 class='itinerary-header'>Personal Itineraries</h2>
    <div class='itinerary-list' v-for='itinerary in myItineraries' v-bind:key="itinerary.itineraryId">
        <h3 class = 'sub-header'>Name: {{itinerary.name}} </h3> <br>
        <b>Starting Location: </b> {{itinerary.startingLocation}} <br><br>
        <b>Date:</b> {{itinerary.date}} <br><br>
        <router-link :to="{ name: 'itinerary-details', params: {id: itinerary.itineraryId}}"> Edit Itinerary </router-link><br><br>
        <button v-on:click.prevent='deleteItinerary(itinerary.itineraryId)'> Delete </button>
    </div>
            </div>

            <div class="grid-child-shared">

    <h2 class='itinerary-header'>Itineraries Shared With You</h2>
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
    .header-name{
        background: lavenderblush;
        opacity: .75;
        border-radius: 100px;
        margin-left: 700px;
        margin-right: 700px;
    }
    .itinerary-list{
        padding: 20px;
        margin-left: 150px;
        border: 1px;
        width: 500px;
        background-image: linear-gradient(to bottom right, lavender, lightblue);
        border-radius: 40px;
        justify-content: center;
    }
     .grid-container {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 200px;
        justify-content: center;
    }
    .sub-header{
        color: navy;
    }
    .itinerary-div {
        font-family: 'Ubuntu', sans-serif;
    }
   .itinerary-header{
       text-align: center;
   }
</style>