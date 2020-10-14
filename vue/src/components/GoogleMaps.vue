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
// import axios from 'axios';

// const http = axios.create({
//     baseURL: "https://maps.googleapis.com/maps/api/geocode"
// });

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
          let marker = new window.google.maps.Marker({
            setposition : points,
            map: this.map,
          })
        }
    },
    
    created() {
        landmarkService.getLandmarks().then((response)=>{
        this.landmarks=response.data;

        // let place = this.landmarks[0];
        // console.log(encodeURIComponent(place.address));
        // // const headers = {'Access-Control-Allow-Headers' : "*", 'Access-Control-Allow-Origin' : '*'}
        // http.get('json?address=' + encodeURIComponent(place.address)+`CA&key=AIzaSyBwqiIiWzxhNGZ2fxocq1tCHMz17TWEMRA`).then(
        //   (response) => {
        //   console.log(response.data.results.gemoetry.location.lat);
        //   console.log(response.data.results.gemoetry.location.lng);
        //   }
        // )

        this.landmarks.forEach(landmark => {
          this.points.push({
            "lat" : landmark.lat,
            "lng" : landmark.lng
          })
          })
          })
    console.log(this.points)
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