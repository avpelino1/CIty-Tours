<template>
  <div id="landmark" class="text-center">
       <h1 class="h3 mb-3 font-weight-normal">Explore Landmarks in Austin, TX</h1>

<<<<<<< HEAD

=======
<GoogleMapLoader class="GoogleMapLoader"/>
>>>>>>> af28a147098a67fea51cdcd8f24272c7a1a7cc5b
<landmark-list/>
<landmark-form/>
      
  </div>
</template>

<script>
import LandmarkList from '@/components/LandmarkList.vue';
<<<<<<< HEAD
=======
import GoogleMapLoader from '@/components/GoogleMapLoader.vue';
>>>>>>> af28a147098a67fea51cdcd8f24272c7a1a7cc5b
import LandmarkForm from '@/components/LandmarkForm.vue';

export default {
    name: 'landmark',
    components: {
      GoogleMapLoader,
      LandmarkList,
<<<<<<< HEAD

=======
>>>>>>> af28a147098a67fea51cdcd8f24272c7a1a7cc5b
      LandmarkForm
    }
}

</script>


<style>
  .GoogleMapLoader {
    width: 50%
  }
</style>