package com.github.hiltonfarias.citiesapi;

import com.github.hiltonfarias.citiesapi.countries.Country;
import com.github.hiltonfarias.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> countries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }
}
