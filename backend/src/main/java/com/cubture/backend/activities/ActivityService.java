package com.cubture.backend.activities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    // Gets the Skiddle API key from the application configuration
    @Value("${skiddle.api.key}")
    private String apiKey;

    public String getActivities() {
        // Builds the Skiddle API URL using the API key and search parameters
        String url = "https://www.skiddle.com/api/v1/events/search/"
                + "?api_key=" + apiKey
                + "&country=GB"
                + "&eventcode=KIDS"
                + "&limit=20"
                + "&imagefilter=1";

        // Creates a RestTemplate to make the request to the Skiddle API
        // RestTemplate is a Spring class that lets your Java backend send HTTP requests
        // to another API
        RestTemplate restTemplate = new RestTemplate();

        // Sends a GET request to Skiddle and returns the response as a String
        return restTemplate.getForObject(url, String.class);
    }
}