package com.maybach7.gweather.services;

import com.maybach7.gweather.dto.api_dto.responseDto.WeatherCurrentResponseDto;
import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.services.api.APIWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final APIWeatherService apiWeatherService;

    private static final Set<String> RAIN_WEATHER = Set.copyOf(List.of(
            // Дождь, морось, ливни
            "Patchy rain possible",
            "Patchy light drizzle",
            "Light drizzle",
            "Freezing drizzle",
            "Heavy freezing drizzle",
            "Patchy light rain",
            "Light rain",
            "Moderate rain at times",
            "Moderate rain",
            "Heavy rain at times",
            "Heavy rain",
            "Light freezing rain",
            "Moderate or heavy freezing rain",
            "Light rain shower",
            "Moderate or heavy rain shower",
            "Torrential rain shower",
            "Patchy rain nearby",

            // Гроза
            "Thundery outbreaks possible",
            "Patchy light rain with thunder",
            "Moderate or heavy rain with thunder"
    ));

    private static final Set<String> SNOWY_WEATHER = Set.copyOf(List.of(
            "Patchy snow possible",
            "Blowing snow",
            "Blizzard",
            "Patchy light snow",
            "Light snow",
            "Patchy moderate snow",
            "Moderate snow",
            "Patchy heavy snow",
            "Heavy snow",
            "Light snow showers",
            "Moderate or heavy snow showers",
            "Patchy light snow with thunder",
            "Moderate or heavy snow with thunder",
            "Patchy sleet possible",
            "Patchy freezing drizzle possible",
            "Freezing drizzle",
            "Heavy freezing drizzle",
            "Light freezing rain",
            "Moderate or heavy freezing rain",
            "Light sleet",
            "Moderate or heavy sleet",
            "Light sleet showers",
            "Moderate or heavy sleet showers",
            "Ice pellets",
            "Light showers of ice pellets",
            "Moderate or heavy showers of ice pellets"
    ));


    public List<WeatherCurrentResponseDto> getCurrentWeatherForLocations(List<Location> userLocationList) {
        return userLocationList.parallelStream()
                .map(location -> apiWeatherService.getCurrentWeather(
                        location.getId().getLatitude(),
                        location.getId().getLongitude()))
                .toList();
    }

    public List<WeatherCurrentResponseDto> getCurrentAdviceMessages(List<WeatherCurrentResponseDto> weatherDtoList) {
        for(WeatherCurrentResponseDto dto : weatherDtoList) {
            var currentWeather = dto.getCurrent();
            if (currentWeather.getUv() >= 2.0) {
                dto.setAdviceMessage(
                        "Be careful in the sun! Don't forget a hat and SPF."
                );
            } else if (isRainyNow(dto)) {
                dto.setAdviceMessage(
                        "Don't forget an umbrella!"
                );
            } else if (isSnowyNow(dto)) {
                dto.setAdviceMessage(
                        "Don't forget your gloves!"
                );
            }
        }
        return weatherDtoList;
    }

    private boolean isRainyNow(WeatherCurrentResponseDto dto) {
        return RAIN_WEATHER.contains(dto.getCurrent().getCondition().getText());
    }

    private boolean isSnowyNow(WeatherCurrentResponseDto dto) {
        return SNOWY_WEATHER.contains(dto.getCurrent().getCondition().getText());
    }
}