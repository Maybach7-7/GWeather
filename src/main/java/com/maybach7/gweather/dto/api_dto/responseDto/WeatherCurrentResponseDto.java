package com.maybach7.gweather.dto.api_dto.responseDto;

import com.maybach7.gweather.dto.api_dto.CurrentDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherCurrentResponseDto {

    private LocationDto location;
    private CurrentDto current;

    private String adviceMessage;
}