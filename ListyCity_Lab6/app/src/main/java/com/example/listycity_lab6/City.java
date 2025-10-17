package com.example.listycity_lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
    This is a class that defines a City.
    Have attributes city and province
 **/
public class City implements Comparable<City>{
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    public String getCityName() {
        return city;
    }

    public String getProvinceName() {
        return province;
    }

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Two cities are equal if both their names and provinces match.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return city.equals(other.city) && province.equals(other.province);
    }

    /**
     * When overriding equals(), always override hashCode() too.
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
