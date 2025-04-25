package com.maybach7.gweather.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
public class Location {

    @EmbeddedId
    private LocationId id;

    private String cityName;
    private String country;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public Location(User user, String cityName, String counter, double lat, double lon) {
        this.user = user;
        this.cityName = cityName;
        this.country = counter;
        this.id = new LocationId();
        this.id.setUserId(user.getId());
    }
}