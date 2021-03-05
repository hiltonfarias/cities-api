package com.github.hiltonfarias.citiesapi.cities.resources;

import com.github.hiltonfarias.citiesapi.cities.service.DistanceService;
import com.github.hiltonfarias.citiesapi.cities.service.EarthRadius;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {
    Logger logger = LoggerFactory.getLogger(DistanceResource.class);
    private final DistanceService distanceService;

    public DistanceResource(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        logger.info("byPoints");
        return ResponseEntity.ok().body(distanceService.distanceByPointsInMiles(city1, city2));
    }

    @GetMapping("/by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        logger.info("byCube");
        return ResponseEntity.ok().body(distanceService.distanceByCubeInMeters(city1, city2));
    }

    @GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius earthRadius) {
        logger.info("byMath");
        return distanceService.distanceUsingMath(city1, city2, earthRadius);
    }
}
