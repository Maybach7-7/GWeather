package com.maybach7.gweather.services;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.List;

@Service
public class LocationService {

    @Value("${weather.api.key}")
    private String apiKey;

    private RestTemplate rest;

    @Autowired
    public LocationService(RestTemplate rest) {
        this.rest = rest;
    }

    public List<LocationDto> getLocations(String city) {
        String url = String.format("https://api.weatherapi.com/v1/search.json?q=%s&key=%s", city, apiKey);
        LocationDto[] locations = rest.getForObject(url, LocationDto[].class);
        return List.of(locations);
    }

    public List<LocationDto> getLocations(double lat, double lon) {
        String url = URLEncoder.encode(String.format("https://api.weatherapi.com/v1/search.json?q=%f,%f&key=%s", lat, lon, apiKey));
        LocationDto[] locations = rest.getForObject(url, LocationDto[].class);
        return List.of(locations);
    }
}