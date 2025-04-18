package com.maybach7.gweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDto {

    private long last_updated_time_epoch;
    private String last_updated;
    private double temp;
    private ConditionDto condition;
    private double wind_speed;
    private double wind_dir;
    private int pressure;
    private int humidity;
    private double feelslike;
    private double uv;
}