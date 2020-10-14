<template>
  <div>
    <div>
      <button id="getGeoLocation" v-on:click="getLocation()">
        Get Current Location</button
      ><br />
      Enter Starting Location:
      <input
        id="userProvidedLocation"
        type="text"
        name="location"
        v-model="startingLocation"
      />
      <button id="manualLocation">Submit</button>
    </div>
    <div id="map"></div>
  </div>
</template>

<script>
import landmarkService from "@/services/LandmarkService.js";
import axios from 'axios';

const http = axios.create({
    baseURL: "https://maps.googleapis.com/maps/api/geocode/json?address="
});

export default {
    name: 'Map',
    data() {
        return {
            map:null,
            location: null,
            gettingLocation: false,
            errorStr: null,
            landmarks:[],
            points: [],
            startingLocation: ''
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
        this.location = this.startingLocation || pos;
        console.log(pos);
        }, err => {
        this.gettingLocation = false;
        this.errorStr = err.message;
        })
        },

        setMarker(points) {
          let markers = new window.google.maps.Marker({
            setposition : points,
            map: this.map,
          })
        }
    },
    
    created() {
        landmarkService.getLandmarks().then((response)=>{
        this.landmarks=response.data;
    })
        this.landmarks.forEach(landmark => {
          http.get(`${landmark.address}+CA&key=AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA`).then((response)=>{
            this.points.push(response.data)
          })
        })

    },    
    mounted() {
        this.initMap();
        this.setMarker(this.points);
    }
}
</script>

<style>
#map {
  height: 500px;
}
</style>