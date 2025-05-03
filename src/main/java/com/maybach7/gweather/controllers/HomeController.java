package com.maybach7.gweather.controllers;

import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.security.CustomUserDetails;
import com.maybach7.gweather.services.LocationService;
import com.maybach7.gweather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.security.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final LocationService locationService;
    private final WeatherService weatherService;

    @GetMapping
    public String homePage(Principal principal,
                           Model model) {
        if (principal != null) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Location> userLocationList = locationService.getUserLocations(userDetails.toUser());

            var startTime = System.currentTimeMillis();
            var currentWeatherList = weatherService.getCurrentWeatherForLocations(userLocationList);
            var endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Time taken to fetch current weather: " + duration + " ms");

            model.addAttribute("currentWeatherList", currentWeatherList);
        }
        return "home";
    }

    @PostMapping("/remove")
    public String removeLocation(@RequestParam("lat") String latitude,
                                 @RequestParam("long") String longitude) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        locationService.removeByApproximateLocation(userDetails, latitude, longitude);

        return "redirect:/";
    }
}