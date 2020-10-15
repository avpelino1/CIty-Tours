<template>

  <div id="landmark" class="text-center">
    <div class="header">
      <br><br><h1 id='header-names'>Explore Landmarks in Austin, TX</h1>
  </div>

<googleMaps/>

<landmark-list/>

<div class="landmark-grid-container">

  <div class='components'>

        <create-itinerary/>
        <landmark-form/>
  
  </div>
</div>

  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import LandmarkForm from '@/components/LandmarkForm.vue';
//import GoogleMaps from '@/components/GoogleMaps.vue';
import CreateItinerary from '@/components/CreateItinerary.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkList,
      LandmarkForm,
      CreateItinerary
    }
};

</script>


<style>
.header{
  background-color: lavender;
  padding-top: 1px;
  font-family: 'Ubuntu', sans-serif;
}
#header-names{
  background-color: lavenderblush;
  border-radius: 40px;
  opacity: 0.75;
  margin-left: 700px;
  margin-right: 700px;
}
.components{
  padding-left: 10px;
  padding-right: 10px;
  display: flex;
  flex-grow: 2;
  justify-content: flex-start;

}
.landmark-form {
  background: white;
}
/* .landmark-grid-container {
  display: grid;
  grid-template-columns: auto auto;
  justify-content: start;
  padding: 30px;
} */
</style>