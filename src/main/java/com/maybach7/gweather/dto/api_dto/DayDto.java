package com.maybach7.gweather.dto.api_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DayDto {

    @JsonProperty("maxtemp_c")
    private double maxtemp;

    @JsonProperty("mintemp_c")
    private double mintemp;

    @JsonProperty("avgtemp_c")
    private double avgtemp;

    @JsonProperty("avghumidity")
    private int avghumidity;

    @JsonProperty("condition")
    private ConditionDto condition;

    @JsonProperty("uv")
    private double uv;
}