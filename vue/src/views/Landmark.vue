<template>

  <div id="landmark" class="text-center">
    <div class="header">
      <h1>Explore Landmarks in Austin, TX</h1>
  </div>

<googleMaps/>

<landmark-list/>

  <div class='components'>
        <create-itinerary/>
  <!-- <div class='landmark-form'>
        <landmark-form/>
    </div> -->

</div>
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
//import LandmarkForm from '@/components/LandmarkForm.vue';
//import GoogleMaps from '@/components/GoogleMaps.vue';
import CreateItinerary from '@/components/CreateItinerary.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkList,
      //LandmarkForm,
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
.components{
  padding-left: 10px;
  padding-right: 10px;
  display: flex;
  flex-grow: 2;
  justify-content: space-between;

}
.landmark-form {
  background: white;
}
</style>