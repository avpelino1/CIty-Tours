<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>
       
<GoogleMapAllLandmark class="landmark-map"/>
<landmark-list/>
<landmark-form/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import LandmarkForm from '@/components/LandmarkForm.vue';
import GoogleMapAllLandmark from '@/components/GoogleMapAllLandmarks.vue'

export default {
    name: 'landmark',
    components: {
      GoogleMapAllLandmark,
      LandmarkList,
      LandmarkForm
    }
}

</script>


<style>

</style>