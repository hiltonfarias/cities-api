package com.github.hiltonfarias.citiesapi.staties.resources;

import com.github.hiltonfarias.citiesapi.staties.entities.State;
import com.github.hiltonfarias.citiesapi.staties.repositories.StateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public List<State> staties() {
        return stateRepository.findAll();
    }
}
