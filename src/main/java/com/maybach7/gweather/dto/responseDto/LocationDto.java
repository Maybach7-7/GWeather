package com.maybach7.gweather.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lon")
    private double longitude;

    @JsonProperty("tz_id")
    private String timezone;

    @JsonProperty("localtime_epoch")
    private long localtime_epoch;

    @JsonProperty("localtime")
    private String localtime;

    private boolean isTracked = false;

    public void setTracked(boolean tracked) {
        isTracked = tracked;
    }
}