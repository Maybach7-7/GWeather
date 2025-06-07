package com.maybach7.gweather.dto.api_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ForecastDto {

    private List<ForecastDayDto> forecastday;
}