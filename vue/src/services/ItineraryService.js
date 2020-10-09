import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getMyItineraries(){
        return http.get('/itinerary/all');
    },

    getFriendsItineraries(){
        return http.get('/itinerary/shared');
    },
   
    createItinerary(itinerary) {
        return http.post('/itinerary/create', itinerary)
    },

    updateItinerary(itinerary) {
        return http.post('/itinerary/:id/update', itinerary)
    },

    deleteItinerary() {
        return http.delete('/itinerary/:id')
    }

}
