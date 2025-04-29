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

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public Location(User user, double lat, double lon) {
        this.user = user;
        this.id = new LocationId();
        this.id.setUserId(user.getId());
    }

    public void setLocationId(LocationId locationId) {
        this.id = locationId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}