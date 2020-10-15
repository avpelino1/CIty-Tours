<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>
<landmark-list/>
<create-itinerary/>
<landmark-form/>
      
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

</style>