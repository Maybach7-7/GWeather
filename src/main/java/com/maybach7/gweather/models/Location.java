package com.maybach7.gweather.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
public class Location {

    @EmbeddedId
    private LocationId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public void setLocationId(LocationId locationId) {
        this.id = locationId;
    }

    public void setUser(User user) {
        this.user = user;
    }
}