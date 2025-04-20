package com.maybach7.gweather.dto.responseDto;

import com.maybach7.gweather.dto.CurrentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherCurrentResponseDto {

    private LocationDto location;
    private CurrentDto current;
}