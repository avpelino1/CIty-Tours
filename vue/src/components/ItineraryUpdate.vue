<template>
  <div class="itinerary-update">
      
      <div class='details-form'>

      <h2 class = 'sub-header'>Details for: {{itinerary.name}}</h2>

      <p>You can change the name, starting address, or date below!</p>
        <form v-on:submit.prevent='updateItinerary(itinerary)'>
        <div class='field'>
            <label for = 'name'>Name: </label>
            <input type='text' name='name' v-model='itinerary.name'/>
        </div> <br>
        <div class='field'>
            <label for = 'startingLocation'>Starting Address: </label>
            <input type='text' name='startingLocation' v-model='itinerary.startingLocation'/>
        </div> <br>
        <div class='field'>
            <label for = 'date'>Date: </label>
            <input type='date' name='date' v-model='itinerary.date'/>
        </div> <br>
        <div class='actions'>
            <button>Submit Changes</button>
        </div>
        </form>
      </div>

        <div class='itinerary-details-grid'>

        <div class='landmark-add-remove'>

        <h3 class="itinerary-h3">Current Landmarks:</h3>

        <form v-for='destination in destinations' :key='destination.description'>
            <button v-on:click='removeLandmark(itinerary.itineraryId, destination.id)'>-</button>
            {{destination.name}}
        </form>

        <h3 class="itinerary-h3">Add Landmarks to Your Itinerary:</h3>

        <form v-for='landmark in landmarks' v-bind:key='landmark.id'>
            <button v-on:click.prevent='addLandmark(itinerary.itineraryId, landmark.id)'>+</button>
            {{landmark.name}}
        </form>
        </div>
        </div>

        <img id='itinerary-img' src='https://cdn.pixabay.com/photo/2015/04/21/13/53/downtown-733286_1280.jpg'/>

       </div>

  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService'
import LandmarkService from '../services/LandmarkService'

export default {
    data() {
        return{
            itinerary: {},
            landmarks: [],
            destinations: [],
        }
    },

    methods: {
        removeLandmark(itineraryID, landmarkID){
            ItineraryService.removeLandmark(itineraryID, landmarkID);
            window.location.reload();
        },

        addLandmark(itineraryID, landmarkID){
            let notFound = true;
           for (let i = 0; i < this.destinations.length; i++) {
                if (this.destinations[i].id == landmarkID) {
                notFound = false;
                window.alert("You already have this landmark in your current itinerary!")
                break;
                } 
            }
            if (notFound) {
            ItineraryService.addLandmark(itineraryID, landmarkID);
            window.location.reload();
            }
        },

        updateItinerary(itinerary){
            console.log(itinerary);
            ItineraryService.updateItinerary(itinerary);
           // window.location.reload();
           alert("Itinerary updated!");
        }
    },

    created() {
        ItineraryService.getOneItinerary(this.$route.params.id).then((response)=>{
            this.itinerary=response.data;
        });
        LandmarkService.getLandmarks().then((response)=>{
            this.landmarks=response.data;
        });
        ItineraryService.getItineraryLandmarks(this.$route.params.id).then((response)=>{
            this.destinations=response.data;
        });
        }
    }

</script>

<style>
.details-form{
    text-align: center;
    justify-content: center;
    margin-top: 60px;
    margin-right: 500px;
    margin-left: 500px;
    margin-bottom: 60px;
    padding: 20px;
    background-image: linear-gradient(to bottom right, lavender, lightblue);
    border-radius: 70px;
}
.itinerary-update {
    font-family: 'Ubuntu', sans-serif;
}
.itinerary-h3 {
    text-align: left;
}

.column-names{
    display: grid;
    grid-template-columns: auto 500px;
    grid-template-areas:
        "landmark-remove-add itinerary-img"
    ;
    margin-right: 100px;
    margin-left: 100px;
}
.landmark-add-remove{
    display: flex;
    flex-grow: 2;

}
</style>