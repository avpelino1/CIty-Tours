<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin</h1>
         <div v-for = 'landmark in landmarks' v-bind:key='landmark.id'>
          <landmark-map />
         </div>


      
  </div>
</template>

<script>

import LandmarkMap from '@/components/LandmarkMap.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkMap
    }
    

}
</script>


<style>

</style>