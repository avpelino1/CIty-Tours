<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>

<GoogleMapLoader class="GoogleMapLoader"/>
<landmark-list/>
<landmark-form/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import GoogleMapLoader from '@/components/GoogleMapLoader.vue';
import LandmarkForm from '@/components/LandmarkForm.vue';

export default {
    name: 'landmark',
    components: {
      GoogleMapLoader,
      LandmarkList,
      LandmarkForm
    }
}

</script>


<style>
  .GoogleMapLoader {
    width: 50%
  }
</style>