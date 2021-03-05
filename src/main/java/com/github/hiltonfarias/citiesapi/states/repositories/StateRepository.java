package com.github.hiltonfarias.citiesapi.states.repositories;

import com.github.hiltonfarias.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}