package com.maybach7.gweather.services;

import com.maybach7.gweather.dto.api_dto.responseDto.WeatherCurrentResponseDto;
import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.services.api.APIWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final APIWeatherService apiWeatherService;

    public List<WeatherCurrentResponseDto> getCurrentWeatherForLocations(List<Location> userLocationList) {
        return userLocationList.parallelStream()
                .map(location -> apiWeatherService.getCurrentWeather(
                        location.getId().getLatitude(),
                        location.getId().getLongitude()))
                .toList();
    }
}