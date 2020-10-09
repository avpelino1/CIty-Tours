<template>
  <div>
      {{landmarkId}}
  </div>
</template>

<script>
//import landmarkService from '../services/LandmarkService.js';

export default {
    name: 'individual-landmark',

    data() {
       return {
           landmarkId: -1
       } 
    },

    methods: {
        
    },

    created() {
        this.landmarkId = this.$route.params.id;
    }

}
</script>

<style>

</style>