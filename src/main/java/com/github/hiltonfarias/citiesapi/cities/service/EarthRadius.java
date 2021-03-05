package com.github.hiltonfarias.citiesapi.cities.service;

public enum EarthRadius {
    METERS("m", 6378168),
    KILOMETERS("km", 6378.168f),
    MILES("mi", 3958.747716f);

    private final String unit;
    private final float value;

    EarthRadius(String unit, float value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public float getValue() {
        return value;
    }
}
