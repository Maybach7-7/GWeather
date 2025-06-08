package com.maybach7.gweather.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maybach7.gweather.services.WeatherService;
import com.maybach7.gweather.services.api.APIWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forecast")
public class ForecastController {

    private final APIWeatherService apiWeatherService;
    private final WeatherService weatherService;

    @Autowired
    public ForecastController(APIWeatherService apiWeatherService,
                              WeatherService weatherService) {
        this.apiWeatherService = apiWeatherService;
        this.weatherService = weatherService;
    }

    @GetMapping
    public String index(@RequestParam("lat") String latitude,
                        @RequestParam("long") String longitude,
                        Model model) throws JsonProcessingException {
        // делаем необходимый запрос к API
        System.out.println("Делаем запрос прогноза погоды для " + latitude + " " + longitude);
        var apiResult = apiWeatherService.getWeatherForecast(latitude, longitude);
        apiResult = weatherService.adjustHoursOfForecast(apiResult, 2, 3);

        model.addAttribute("locationName", apiResult.getLocation().getName());
        model.addAttribute("forecastDayDto", apiResult.getForecast().getForecastday());

        model.addAttribute("forecastJson", apiResult.getForecast());

        return "forecast";
    }
}