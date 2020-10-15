<template>
  <div id="landmark" class="text-center">
<<<<<<< HEAD
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>
=======
    <div class="header">
      <h1>Explore Landmarks in Austin, TX</h1>
    </div>
<googleMaps/>
>>>>>>> bb85cf243ee74fac28ee02ee670492c425bfb9fd
<landmark-list/>

  <div class='components'>
    <create-itinerary/>
    <div class='landmark-form'>
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
.components{
  padding-left: 10px;
  padding-right: 10px;
  display: flex;
  flex-grow: 2;
  justify-content: space-between;
  background: lavenderblush;
}
</style>