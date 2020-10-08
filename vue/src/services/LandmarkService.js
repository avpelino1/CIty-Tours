import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getLandmarks(){
        return http.get('/landmarks/all');
    },
   
    createLandmark(landmark) {
        return http.post('/landmark/add', landmark);
    },

    getOneLandmark() {
        return http.get('/landmarks/:id');
    },

    pendingLandmarks() {
        return http.get('/landmarks/pending');
    }

    }
