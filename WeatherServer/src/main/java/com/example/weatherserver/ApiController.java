package com.example.weatherserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ApiController {

    @GetMapping("/weather")
    public String weather() throws Exception {
        String appid = "34e63e481c60b1b46230039f780c3e19";
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://api.openweathermap.org/data/2.5/weather")
                .queryParam("lat" , "36.4777955")
                .queryParam("lon", "127.2650979")
                .queryParam("appid", appid)
                .build();
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri.toUri(), String.class);
        return responseEntity.getBody();
    }
}
