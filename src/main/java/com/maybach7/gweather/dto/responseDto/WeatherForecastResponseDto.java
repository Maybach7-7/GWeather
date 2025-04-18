package com.maybach7.gweather.dto.responseDto;

import com.maybach7.gweather.dto.CurrentDto;
import com.maybach7.gweather.dto.ForecastDto;
import com.maybach7.gweather.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastResponseDto {

    private LocationDto location;
    private CurrentDto current;
    private ForecastDto forecast;
}