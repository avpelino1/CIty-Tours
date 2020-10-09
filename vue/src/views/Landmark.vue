<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin</h1>

<landmark-map/>
<landmark-list/>
<landmark-form/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import LandmarkMap from '@/components/LandmarkMap.vue';
import LandmarkForm from '@/components/LandmarkForm.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkList,
      LandmarkMap,
      LandmarkForm
    }
}

</script>


<style>

</style>