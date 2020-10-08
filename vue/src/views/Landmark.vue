<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin</h1>

<landmark-map/>
<landmark-list/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import LandmarkMap from '@/components/LandmarkMap.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkList,
      LandmarkMap
    }
}

</script>


<style>

</style>