package com.maybach7.gweather.repositories;

import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByUser(User user);
}
