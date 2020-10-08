import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getItineraries(){
        return http.get('/itinerary');
    },
   
    createItinerary(itinerary) {
        return axios.post('/login', itinerary)
    },

}
