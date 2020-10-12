<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>


<landmark-list/>
<landmark-form/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
import LandmarkForm from '@/components/LandmarkForm.vue';

export default {
    name: 'landmark',
    components: {
      LandmarkList,

      LandmarkForm
    }
}

</script>


<style>

</style>