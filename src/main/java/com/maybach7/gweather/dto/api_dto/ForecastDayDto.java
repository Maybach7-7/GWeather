package com.maybach7.gweather.dto.api_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ForecastDayDto {

    @JsonProperty("date")
    private String date;

    @JsonProperty("date_epoch")
    private long date_epoch;

    @JsonProperty("day")
    private DayDto day;

    @JsonProperty("hour")
    private List<HourDto> hour;
}