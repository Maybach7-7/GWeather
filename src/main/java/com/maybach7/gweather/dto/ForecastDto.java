package com.maybach7.gweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDto {

    private List<ForecastDayDto> forecastday;
}