package com.github.hiltonfarias.citiesapi.cities;

import com.github.hiltonfarias.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private final CityRepository cityRepository;

    public CityResource(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // 1st
//    @GetMapping
//    public List<City> cities() {
//        return cityRepository.findAll();
//    }

    @GetMapping
    public Page<City> cities(final Pageable pageable) {
        return cityRepository.findAll(pageable);
    }
}