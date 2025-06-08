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
public class HourDto {

    @JsonProperty("temp_epoch")
    private long time_epoch;

    @JsonProperty("time")
    private String time;

    @JsonProperty("temp_c")
    private double temp;

    @JsonProperty("condition")
    private ConditionDto condition;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("uv")
    private double uv;

    public HourDto(HourDto dto) {
        this.time_epoch = dto.getTime_epoch();
        this.time = dto.getTime();
        this.temp = dto.getTemp();
        this.condition = dto.getCondition();
        this.humidity = dto.getHumidity();
        this.uv = dto.getUv();
    }
}