<template>
  <div>
    <h1>***MAP SHOULD DISPLAY BELOW***</h1>
      <div class="google-map" ref="googleMap"></div>
      <template v-if="Boolean(this.google) && Boolean(this.map)">
        <slot
          :google="google"
          :map="map"
        />
      </template>
    </div>
</template>

<script>
import landmarkService from "../services/LandmarkService.js";
import GoogleMapsApiLoader from 'google-maps-api-loader';

export default {
  name: "landmark-map",
  props: {
    mapConfig: Object,
    },
  data() {
    return {
      apiKey: "AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA",
      landmarks: [],
      google: null,
      map: null
    };
  },
  async mounted() {
    const googleMapApi = await GoogleMapsApiLoader({
      apiKey: this.apiKey
    })
    this.google = googleMapApi
    this.initializeMap()
  },
  methods: {
       initializeMap() {
      const mapContainer = this.$refs.googleMap
      this.map = new this.google.maps.Map(
        mapContainer, this.mapConfig
      )
    },
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