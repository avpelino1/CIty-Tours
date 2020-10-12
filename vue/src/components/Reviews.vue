<template>
<div>


  <h3> Add a Review </h3>


      </div> 
</template>

<script>
import reviewService from '../services/ReviewService.js';

export default {
    name: 'reviews',
    data() {
        return {
            newReview: {
    
            }

        }

    },

    methods: {
        addReview() {
            reviewService.createReview(this.newReview);
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