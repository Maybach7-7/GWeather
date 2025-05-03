package com.maybach7.gweather.repositories;

import com.maybach7.gweather.models.Location;
import com.maybach7.gweather.models.LocationId;
import com.maybach7.gweather.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAllByUser(User user);

    void deleteById(LocationId id);

    @Modifying
    @Transactional
    @Query(value= """
    DELETE FROM locations
    WHERE user_id = :userId
    AND ABS(CAST(:latitude AS double precision) - CAST(latitude AS DOUBLE precision) ) <= 0.01
    AND ABS(CAST(:longitude AS double precision) - CAST(longitude AS DOUBLE precision) ) <= 0.01
    """, nativeQuery = true)
    void deleteByApproximateLocationId(@Param("userId") Long userId,
                                       @Param("latitude") String latitude,
                                       @Param("longitude") String longitude);
}