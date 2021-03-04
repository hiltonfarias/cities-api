package com.github.hiltonfarias.citiesapi.staties.repository;

import com.github.hiltonfarias.citiesapi.staties.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
