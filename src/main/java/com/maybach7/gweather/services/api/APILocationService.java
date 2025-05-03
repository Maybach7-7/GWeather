package com.maybach7.gweather.services.api;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class APILocationService {

    @Value("${weather.api.key}")
    private String apiKey;

    private RestTemplate rest;

    @Autowired
    public APILocationService(RestTemplate rest) {
        this.rest = rest;
    }

    public List<LocationDto> getLocations(String city) {
        String url = String.format("https://api.weatherapi.com/v1/search.json?q=%s&key=%s&lang=%s", city, apiKey, "en");
        LocationDto[] locations = rest.getForObject(url, LocationDto[].class);
        log.info(Arrays.toString(locations));
        return List.of(locations);
    }

    public List<LocationDto> getLocations(double lat, double lon) {
        String url = URLEncoder.encode(String.format("https://api.weatherapi.com/v1/search.json?q=%f,%f&key=%s$lang=%s", lat, lon, apiKey, "en"));
        LocationDto[] locations = rest.getForObject(url, LocationDto[].class);
        log.info(Arrays.toString(locations));
        return List.of(locations);
    }
}