package com.github.hiltonfarias.citiesapi;

import com.github.hiltonfarias.citiesapi.countries.Country;
import com.github.hiltonfarias.citiesapi.exception.BadRequestException;
import com.github.hiltonfarias.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Country> countries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Country id not found")));
    }
}
