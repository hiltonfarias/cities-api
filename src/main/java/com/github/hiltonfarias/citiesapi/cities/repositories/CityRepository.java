package com.github.hiltonfarias.citiesapi.cities.repositories;

import com.github.hiltonfarias.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
