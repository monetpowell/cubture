package com.cubture.backend.activities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {

    @Value("${skiddle.api.key}")
    private String apiKey;

    public String getActivities() {

        String url = "https://www.skiddle.com/api/v1/events/search/"
                + "?api_key=" + apiKey
                + "&country=GB"
                + "&eventcode=KIDS"
                + "&limit=20"
                + "&imagefilter=1";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }
}