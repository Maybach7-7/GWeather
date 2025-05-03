package com.maybach7.gweather.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
@Setter
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
}