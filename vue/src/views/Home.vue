<template>
  <div class="home">
    <div class="header">
      <div id='header-foreground'>
        <h1 id='header-words'>City Tour of Austin, TX</h1>
        <h4 id='header-words'>Welcome, {{this.$store.state.user.username}}!</h4>
      </div>
    <div class="container">
      <router-link class='link' :to="{ name: 'landmark'}"> View a List of Landmarks in Austin, TX  </router-link>
      <router-link class='link' :to="{ name: 'landmark'}"> Create a New Itinerary  </router-link>
      <router-link class='link' :to="{ name: 'itinerary'}"> View or Edit Your Existing Itineraries </router-link>
    </div>
    </div>
    
    <div class='home-description'>
      <div class='blurb'>
      <h4>The city of Austin is a beautiful place, full of diversity. Regardless of which landmarks you choose to visit, you are sure to have a wonderful time!</h4>
      <h3 class='weird'>Keep Austin Weird!</h3>
      </div>
    <!-- <img class='skyline' src='https://storage.needpix.com/rsynced_images/austin-4064427_1280.jpg'/> -->
    </div>

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
    color: navy;
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
    color: navy;
    background-image: url("https://aquilacommercial.com/wp-content/uploads/2019/05/city-of-austin-skyline.jpg"); /* The image used */
    background-color: #cccccc; /* Used if the image is unavailable */
    height: 250px; /* You must set a specified height */
    background-position: center; /* Center the image */
    background-repeat: no-repeat; /* Do not repeat the image */
    background-size: cover; /* Resize the background image to cover the entire container */
    border-radius: 20px;

  }
  #header-foreground{
    background-color:lavenderblush;
    opacity: 0.75;
    border-radius: 700px;
    margin-left: 700px;
    margin-right: 700px;
    margin-top: 50px;
    margin-bottom: 25px;
    padding-bottom: 5px;
  }
  #header-words{
    opacity: 1;
    color: navy;
  }
  .container {
    display: flex;
    flex-grow: 3;
    justify-content: space-between;
    color:white;
    border-radius: 0px;
    padding-top: 12px;
    padding-left: 10px;
    padding-right: 15px;
    padding-bottom: 5px;
    margin-bottom: 5px;
  }
  .skyline{
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
    border-radius: 100px;
    margin-top: 30px;
  }
  .weird{
    font-style: italic;
    text-align: center;
  }
  .home {
     font-family: 'Ubuntu', sans-serif;
  }
  .link{
    background-color:lavenderblush;
    opacity: 0.75;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 15px;
    padding-left: 15px;
    margin-bottom: 5px;
    border-radius: 40px;
  }
  .home-description{
    display: grid;
    grid-template-columns: auto;
    grid-template-areas:
      "blurb skyline"
      ;
    /* margin-top: 50px; */
    justify-content: center;
  }
  .blurb{
    padding: 50px;
    margin: 50px;
    background-image: linear-gradient(to bottom right, lightblue, lavender);
    border-radius: 50px;
  }
</style>