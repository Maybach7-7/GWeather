package com.maybach7.gweather.services;

import com.maybach7.gweather.dto.responseDto.WeatherCurrentResponseDto;
import com.maybach7.gweather.dto.responseDto.WeatherForecastResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate rest;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public WeatherCurrentResponseDto getCurrentWeather(String city) {
        String url = String.format("https://api.weatherapi.com/v1/current.json?q=%s&lang=%s&key=%s", city, "en", apiKey);
        return rest.getForObject(url, WeatherCurrentResponseDto.class);
    }

    public WeatherForecastResponseDto getWeatherForecast(String city) {
        String url = String.format("https://api.weatherapi.com/v1/forecast.json?q=%s&days=%d&lang=%s&key=%s", city, 3, "en", apiKey);
        return rest.getForObject(url, WeatherForecastResponseDto.class);
    }
}