<template>
  <div class="home">
    <div class="header">
      <h1>City Tour of Austin, TX</h1>
      <h4>Welcome, {{this.$store.state.user.username}}!</h4>
    </div>
    <div class="container">
      <router-link :to="{ name: 'landmark'}"> View a List of Landmarks in Austin, TX  </router-link>
      <router-link :to="{ name: 'landmark'}"> Create a New Itinerary  </router-link>
      <router-link :to="{ name: 'itinerary'}"> View or Edit Your Existing Itineraries </router-link>
    </div>
    
    <img id='skyline' src='https://aquilacommercial.com/wp-content/uploads/2019/05/city-of-austin-skyline.jpg'/>

    <h4>The city of Austin is a beautiful place, full of diversity. Regardless of which landmarks you choose to visit, you are sure to have a wonderful time!</h4>
    <h3 class='weird'>Keep Austin Weird!</h3>

  </div>
</template>

<script>


export default {
  name: "home",
  components: {
    
}
}
</script>

<style>
  h1{
    text-align: center;
    padding: 10px 0;
    font-weight: 800;
  }
  h4{
    text-align: center;
    font-weight: 100;
  }
  .header {
    width: 100%;
    padding-top: 5px;
    padding-bottom: 20px;
    text-align: center;
    background: lavender;
    color: navy;
  }
  .container {
    display: flex;
    flex-grow: 3;
    justify-content: space-between;
    background: lavender;
    padding-bottom: 10px;
    padding-left: 10px;
    padding-right: 10px;
  }
  #skyline{
    width: 100%;
  }
  h3{
    font-style: italic;
    text-align: center;
  }
  .home {
     font-family: 'Ubuntu', sans-serif;
  }
</style>