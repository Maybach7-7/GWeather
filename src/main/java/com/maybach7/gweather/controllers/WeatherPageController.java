package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import com.maybach7.gweather.dto.responseDto.WeatherCurrentResponseDto;
import com.maybach7.gweather.services.LocationService;
import com.maybach7.gweather.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WeatherPageController {

    private final LocationService locationService;
    private final WeatherService weatherService;

    @Autowired
    public WeatherPageController(LocationService locationService,
                                 WeatherService weatherService) {
        this.locationService = locationService;
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        return "current_weather";
    }

//    @GetMapping("/search")
//    public String search() {
//        return "search";
//    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam("city") String city, Model model) {
//        List<LocationDto> locations = locationService.getLocations(city);
//        model.addAttribute("locations", locations);
//        return "search";
//

    @GetMapping("/current")
    public String current(@RequestParam("city") String city, Model model) {
        WeatherCurrentResponseDto currentWeather =
                weatherService.getCurrentWeather(city);
        model.addAttribute("currentWeather", currentWeather);
        return "current_weather";
    }
}