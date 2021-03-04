package com.github.hiltonfarias.citiesapi.countries.repository;

import com.github.hiltonfarias.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
