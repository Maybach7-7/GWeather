package com.maybach7.gweather.services;

import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.models.LocationId;
import com.maybach7.gweather.models.User;
import com.maybach7.gweather.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addLocation(User user, String city, String country, double lat, double lon) {
        Location location = new Location(user, city, country, lat, lon);
        locationRepository.save(location);
    }

    public void deleteLocation(User user, double lat, double lon) {
        LocationId locationId = new LocationId(user.getId(), lat, lon);
        locationRepository.deleteById(locationId);
    }
}