<template>
  <div>
    <h1>Map of Landmarks</h1>
  </div>
</template>

<script>
import landmarkService from "../services/LandmarkService.js";

export default {
  name: "landmark-map",
  data() {
    return {
      landmarks: [],
    };
  },
  created() {
    landmarkService.getLandmarks().then((response) => {
      this.landmarks = response.data;
    });
  },
};
</script>

<style>
</style>