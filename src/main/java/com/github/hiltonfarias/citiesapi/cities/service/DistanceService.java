package com.github.hiltonfarias.citiesapi.cities.service;

import com.github.hiltonfarias.citiesapi.cities.entities.City;
import com.github.hiltonfarias.citiesapi.cities.repositories.CityRepository;
import com.github.hiltonfarias.citiesapi.utils.StringLocationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger logger = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * 1st option
     *
     * @param city1 Long
     * @param city2 Long
     * @param unit EarthRadius
     * @return Double
     */
    public Double distanceUsingMath(final Long city1, final Long city2, final EarthRadius unit) {
        logger.info("distanceUsingMath({}, {}, {})", city1, city2, unit);
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1,city2));

        final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
        final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());

        return doCalculation(location1[0], location1[1], location2[0], location2[1], unit);
    }

    /***
     *  2st option
     *
     * @param city1 Long
     * @param city2 Long
     * @return Double
     */
    public Double distanceByPointsInMiles(final Long city1, final Long city2) {
        logger.info("nativePostgresInMiles({}, {})", city1, city2);
        return cityRepository.distanceByPoints(city1, city2);
    }

    /***
     * 3st option
     *
     * @param city1 Long
     * @param city2 Long
     * @param unit EarthRadius
     * @return Double
     */
    public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius unit) {
        logger.info("distanceUsingPoints({}, {}, {})", city1, city2, unit);
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1,city2));

        Point point1 = cities.get(0).getLocation();
        Point point2 = cities.get(1).getLocation();
        return doCalculation(point1.getX(), point1.getY(), point2.getX(), point2.getY(), unit);
    }

    /***
     *
     * @param city1 Long
     * @param city2 Long
     * @return Double
     */
    public Double distanceByCubeInMeters(Long city1, Long city2) {
        logger.info("distanceByCubeInMeters({}, {})", city1, city2);
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1,city2));

        Point point1 = cities.get(0).getLocation();
        Point point2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

    private double doCalculation(
            final double lat1,
            final double lon1,
            final double lat2,
            final double lon2,
            final EarthRadius earthRadius
    ) {
        double lat = toRadians(lat2-lat1);
        double lon = toRadians(lon2-lon1);
        double a = sin(lat / 2) * sin(lat / 2)
                + cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return earthRadius.getValue() * c;
    }
}
