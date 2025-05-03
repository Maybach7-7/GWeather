package com.maybach7.gweather.models;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LocationId implements Serializable {

    private Long userId;
    private String latitude;
    private String longitude;

    public LocationId() {}

    public LocationId(Long userId, String latitude, String longitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
