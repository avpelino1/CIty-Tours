<template>
  <div>
  <div>
    <button id='getGeoLocation' v-on:click="getLocation()">Get Current Location</button><br>
    Enter Starting Location: <input id='userProvidedLocation' type='text' name='location' v-model='startingLocation'> <button id='manualLocation'>Submit</button>
  </div>
  <div id="map">  
    </div>
    </div>
</template>

<script>
import landmarkService from "@/services/LandmarkService.js"
import landmarkList from "@/components/LandmarkList.vue"

let startingLocation;

export default {
    name: 'Map',
    data() {
        return {
            map:null,
            location: null,
            gettingLocation: false,
            errorStr: null,
            landmarks: [],
            geoLandmarks: [],
        }

    },
    methods: {
        initMap() {
            this.map = new window.google.maps.Map(document.getElementById('map'),{
                center: {lat:30.2672, lng:-97.7431},
                zoom: 11,
                maxZoom: 20,
                minZoom: 3,
                streetViewControl: true,
                mapTypeControl: true,
                fullscreenControl: true,
                zoomControl: true
            })
        },
        getLocation() {
        //do we support geolocation
        if(!("geolocation" in navigator)) {
        this.errorStr = 'Geolocation is not available.';
        return;
        }

        this.gettingLocation = true;
        // get position
        navigator.geolocation.getCurrentPosition(pos => {
        this.gettingLocation = false;
        this.location = pos;
        startingLocation = pos;
        console.log(pos);
        }, err => {
        this.gettingLocation = false;
        this.errorStr = err.message;
        })
        }
    },
    created() {
        landmarkService.getLandmarks().then((response)=>{
      this.landmarks=response.data;

    }),
    
    forEach(landmark in landmarks) {
        geolocation = `https://maps.googleapis.com/maps/api/geocode/json?address=${landmark.address}+CA&key=AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA`;
        this.geoLandmarks.add(geolocation);
    }
    },
    mounted() {
        this.initMap();
    }
}
</script>

<style>
    #map{
        height: 500px;
    }
</style>