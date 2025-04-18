package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.LocationDto;
import com.maybach7.gweather.dto.responseDto.LocationResponseDto;
import com.maybach7.gweather.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WeatherPageController {

    private final LocationService locationService;

    @Autowired
    public WeatherPageController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam("city") String city, Model model) {
        List<LocationDto> locations = locationService.getLocations(city);
        model.addAttribute("locations", locations);
        return "index";
    }
}