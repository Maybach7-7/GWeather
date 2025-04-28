package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import com.maybach7.gweather.services.LocationService;
import com.maybach7.gweather.services.api.APILocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final APILocationService locationService;
    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    public SearchController(APILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String search(@RequestParam(value = "name", required = false) String name,
                         Model model) {
        if(name != null) {
            logger.info("Received parameter: " + name);
            List<LocationDto> locationList = locationService.getLocations(name);
            logger.info("Found " + locationList.size() + " locations");
            model.addAttribute("locationList", locationList);
        }
        return "search";
    }

    @PostMapping("/add")
    public String addLocation(@RequestParam("lat") double latitude,
                              @RequestParam("long") double longitude,
                              Model model) {
        logger.info("Received latitude: " + latitude + ", longitude: " + longitude);
        
    }
}