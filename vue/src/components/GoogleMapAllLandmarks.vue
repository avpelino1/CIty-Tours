<template>
  <div id="map">

  </div>
</template>

<script>
export default {
    name: 'Map',
    data() {
        return {
            map:null,
            mapCenter: {
                "lat" : "30.2672",
                "lng" : "97.7431"
            }
        }
    }
}
</script>

<style>
    .map{
        width: 100%
    }
</style>