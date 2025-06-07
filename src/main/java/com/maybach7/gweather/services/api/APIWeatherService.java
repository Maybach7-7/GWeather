package com.maybach7.gweather.services.api;

import com.maybach7.gweather.dto.api_dto.responseDto.WeatherCurrentResponseDto;
import com.maybach7.gweather.dto.api_dto.responseDto.WeatherForecastResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIWeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate rest;
    private final Logger logger = LoggerFactory.getLogger(APIWeatherService.class);

    @Autowired
    public APIWeatherService(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public WeatherCurrentResponseDto getCurrentWeather(String city) {
        String url = String.format("https://api.weatherapi.com/v1/current.json?q=%s&key=%s&lang=%s", city, apiKey, "en");
        var result = rest.getForObject(url, WeatherCurrentResponseDto.class);
        logger.info(result.toString());
        return result;
    }

    public WeatherCurrentResponseDto getCurrentWeather(String latitude,
                                                       String longitude) {
        String url = String.format("https://api.weatherapi.com/v1/current.json?q=%s,%s&key=%s&lang=%s", latitude, longitude, apiKey, "en");
        var result = rest.getForObject(url, WeatherCurrentResponseDto.class);
        logger.info(result.toString());
        return result;
    }

    public WeatherForecastResponseDto getWeatherForecast(String latitude,
                                                         String longitude) {
        String url = String.format("https://api.weatherapi.com/v1/forecast.json?q=%s,%s&days=%d&key=%s&lang=%s", latitude, longitude, 3, apiKey, "en");
        var obj = rest.getForObject(url, WeatherForecastResponseDto.class);
        System.out.println("\n" + obj.toString() + "\n");
        return obj;
    }
}