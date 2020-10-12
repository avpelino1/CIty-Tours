<template>
<div>

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
            }

        }

    },

    methods: {
        addReview() {
            reviewService.createReview(this.newReview).then(
                alert("Thanks for your review!"));
                this.newReview = {
                    "landmarkId" : this.$route.params.id
                }
            
        },
        getReviews(id) {
            reviewService.getReviews(id);
        }

    },

    created() {

    }
}
</script>

<style>

</style>