package com.maybach7.gweather.dto.responseDto;

import com.maybach7.gweather.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponseDto {

    private List<LocationDto> locations;
}