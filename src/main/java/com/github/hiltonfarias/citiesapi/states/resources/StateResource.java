package com.github.hiltonfarias.citiesapi.states.resources;

import com.github.hiltonfarias.citiesapi.states.entities.State;
import com.github.hiltonfarias.citiesapi.states.repositories.StateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public List<State> states() {
        return stateRepository.findAll();
    }
}
