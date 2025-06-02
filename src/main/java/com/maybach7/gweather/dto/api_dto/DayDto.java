package com.maybach7.gweather.dto.api_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DayDto {

    private double maxtemp;
    private double mintemp;
    private double avgtemp;
    private int avghumidity;
    private int daily_chance_of_rain;
    private int daily_chance_of_snow;
    private ConditionDto condition;
    private double uv;
}