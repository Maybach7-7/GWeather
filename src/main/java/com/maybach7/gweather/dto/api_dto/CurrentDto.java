package com.maybach7.gweather.dto.api_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentDto {

    @JsonProperty("last_updated_epoch")
    private long last_updated_time_epoch;

    @JsonProperty("last_updated")
    private String last_updated_time;

    @JsonProperty("temp_c")
    private double temp;

    @JsonProperty("condition")
    private ConditionDto condition;

    @JsonProperty("wind_kph")
    private double wind_speed;

    @JsonProperty("pressure_mb")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("feelslike_c")
    private double feelslike;

    @JsonProperty("uv")
    private double uv;
}