<template>
<div class="reviews">
    <h2>Reviews</h2>
    <div class='review' v-for='review in reviews' v-bind:key='review.id'>
        <h3 id='reviewTitle'>{{review.title}}   </h3><img class='thumb' v-if="review.thumbsUp==true" src = "https://imgur.com/LLPYyXY.png"/><img class='thumb' v-if="review.thumbsDown==true" src = "https://imgur.com/lKO2G1K.png"/>
        <p id='reviewDescription'>{{review.description}}</p>
    </div>


  <h3> Add a Review </h3>

  <form v-on:submit='addReview(newReview)'>
      <div class='field'>
          <label for = 'title'>Title </label>
          <input type='text' name='title' v-model='newReview.title'/>
      </div> <br>
      <div class='field'>
          <label for = 'description'>Description </label>
          <input type='text' name='description' v-model='newReview.description'/>
      </div><br>
     <div class='actions'>
         <button v-on: click="window.location.reload();">Submit your Review </button>
     </div>
  </form>
</div> 
</template>

<script>
import reviewService from '../services/ReviewService.js';

export default {
    name: 'reviews',
    data() {
        return {
            newReview: {
                "landmarkId" : this.$route.params.id
            },
            reviews:[]
        }

    },

    methods: {
        addReview() {
            reviewService.createReview(this.newReview).then(
                alert("Thanks for your review!"));
                this.newReview = {
                    "landmarkId" : this.$route.params.id
                }
            
        }

    },

    created() {
        reviewService.getReviews(this.$route.params.id).then((response) => {
            this.reviews = response.data
        })
    }
}
</script>

<style>

    .thumb {
        display: inline-flex;
        width: 1%;
        padding-left: 10px;        
    }

    #reviewTitle {
        display:inline-flex
    }
    .reviews {
         font-family: 'Ubuntu', sans-serif;
    }

</style>