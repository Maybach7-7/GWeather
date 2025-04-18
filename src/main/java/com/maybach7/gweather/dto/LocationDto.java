package com.maybach7.gweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private String name;
    private String region;
    private String country;
    private double latitude;
    private double longitude;
    private String timezone;
    private long localtime_epoch;
    private String localtime;
}