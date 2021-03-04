package com.github.hiltonfarias.citiesapi.staties.repositories;

import com.github.hiltonfarias.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
