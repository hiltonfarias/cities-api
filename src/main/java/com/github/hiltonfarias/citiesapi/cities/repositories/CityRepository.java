package com.github.hiltonfarias.citiesapi.cities.repositories;

import com.github.hiltonfarias.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {
    String QUERY = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> " +
            "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance";

    @Query(value = QUERY, nativeQuery = true)
    Double distanceByPoints(Long cityId1, Long cityId2);

    String QUERY_RADIUS = "SELECT earth_distance(ll_to_earth(?1, ?2), ll_to_earth(?3, ?4)) as distance";

    @Query(value = QUERY_RADIUS, nativeQuery = true)
    Double distanceByCube(double lat1, double lon1, double lat2, double lon2);
}
