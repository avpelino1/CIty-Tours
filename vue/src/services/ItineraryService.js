import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/itinerary"
});

export default {
    getMyItineraries(){
        return http.get('/all');
    },

    getOneItinerary(id){
        return http.get(`/getOne/${id}`);
    },

    getFriendsItineraries(){
        return http.get('/shared');
    },

    getItineraryLandmarks(id){
        return http.get(`/destinations/${id}`);
    },
   
    createItinerary(itinerary) {
        console.log("You are in itineraryService.vue");
        return http.post('/create', itinerary);
    },

    updateItinerary(itinerary) {
        return http.put(`/${itinerary.id}/update`, itinerary);
    },

    deleteItinerary(id) {
        return http.delete(`/${id}/delete`);
    }

}
