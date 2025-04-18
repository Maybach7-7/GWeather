package com.maybach7.gweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDayDto {

    private String date;
    private long date_epoch;
    private DayDto day;
}