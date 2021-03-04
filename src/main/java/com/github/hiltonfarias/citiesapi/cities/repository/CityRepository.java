package com.github.hiltonfarias.citiesapi.cities.repository;

import com.github.hiltonfarias.citiesapi.cities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
