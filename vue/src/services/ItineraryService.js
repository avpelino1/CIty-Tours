import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/itinerary"
});

export default {
    getMyItineraries(){
        return http.get('/all');
    },

    getFriendsItineraries(){
        return http.get('/shared');
    },
   
    createItinerary(itinerary) {
        return http.post('/create', itinerary)
    },

    updateItinerary(itinerary) {
        return http.post(`/${itinerary.id}/update`, itinerary)
    },

    deleteItinerary(id) {
        return http.delete(`/${id}/delete`)
    }

}
