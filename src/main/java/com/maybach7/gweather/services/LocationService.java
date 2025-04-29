package com.maybach7.gweather.services;

import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.models.LocationId;
import com.maybach7.gweather.models.User;
import com.maybach7.gweather.repositories.LocationRepository;
import com.maybach7.gweather.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getUserLocations(User user) {
        return locationRepository.findAllByUser(user);
    }

    public void addLocation(CustomUserDetails userDetails,
                            double latitude,
                            double longitude) {

        LocationId locationId = new LocationId(userDetails.getId(), latitude, longitude);
        Location location = new Location();
        location.setLocationId(locationId);
        location.setUser(userDetails.toUser());

        locationRepository.save(location);
    }

    @Transactional
    public void removeLocation(CustomUserDetails userDetails,
                               double lat,
                               double lon) {
        LocationId locationId = new LocationId(userDetails.getId(), lat, lon);
        locationRepository.deleteById(locationId);
    }
}