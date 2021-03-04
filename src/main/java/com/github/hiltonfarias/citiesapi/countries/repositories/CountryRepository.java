package com.github.hiltonfarias.citiesapi.countries.repositories;

import com.github.hiltonfarias.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
