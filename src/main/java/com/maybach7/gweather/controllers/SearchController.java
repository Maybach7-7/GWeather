package com.maybach7.gweather.controllers;

import com.maybach7.gweather.dto.responseDto.LocationDto;
import com.maybach7.gweather.repositories.LocationRepository;
import com.maybach7.gweather.security.CustomUserDetails;
import com.maybach7.gweather.services.LocationService;
import com.maybach7.gweather.services.api.APILocationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final APILocationService apiLocationService;
    private final LocationRepository locationRepository;
    private final LocationService locationService;
    private Logger logger = LoggerFactory.getLogger(SearchController.class);

    @GetMapping
    public String search(@RequestParam(value = "name", required = false) String name,
                         Model model) {
        if(name != null) {
            logger.info("Received parameter: " + name);
            List<LocationDto> locationList = apiLocationService.getLocations(name);
            logger.info("Found " + locationList.size() + " locations");
            model.addAttribute("locationList", locationList);
        }
        return "search";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> addLocation(@RequestParam("lat") double latitude,
                              @RequestParam("long") double longitude) {
        logger.info("Received latitude: " + latitude + ", longitude: " + longitude);
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        locationService.addLocation(userDetails, latitude, longitude);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Added");
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<String> removeLocation(@RequestParam("lat") double latitude,
                                              @RequestParam("long") double longitude) {
        logger.info("Received latitude: " + latitude + ", longitude: " + longitude);
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        locationService.removeLocation(userDetails, latitude, longitude);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removed");
    }
}