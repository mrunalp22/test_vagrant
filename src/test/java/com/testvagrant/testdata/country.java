package com.testvagrant.testdata;

public enum country {

    SOUTHAFRICA("South Africa"),
    INDIA("India"),
    AUSTRALIA("Australia"),
    SRILANKA("Srilanka");


    private final String countryName;


    country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
