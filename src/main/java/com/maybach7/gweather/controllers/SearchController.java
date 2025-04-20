package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import com.maybach7.gweather.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final LocationService locationService;
    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    public SearchController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String search() {
        return "search";
    }

    @GetMapping("/location")
    public String searchLocation(@RequestParam("name") String name,
                                 Model model) {
        logger.info("Received param: " + name);
        List<LocationDto> locations = locationService.getLocations(name);
        logger.info("Founded locations: " + locations);
        model.addAttribute("locations", locations);
        return "search";
    }
}