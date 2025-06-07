package com.maybach7.gweather.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final APIWeatherService weatherService;

    @Autowired
    public ForecastController(APIWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String index(@RequestParam("lat") String latitude,
                        @RequestParam("long") String longitude,
                        Model model) throws JsonProcessingException {
        // делаем необходимый запрос к API
        System.out.println("Делаем запрос прогноза погоды для " + latitude + " " + longitude);
        var apiResult = weatherService.getWeatherForecast(latitude, longitude);

        model.addAttribute("locationName", apiResult.getLocation().getName());
        model.addAttribute("forecastDayDto", apiResult.getForecast().getForecastday());

        model.addAttribute("forecastJson", apiResult.getForecast());

        return "forecast";
    }
}