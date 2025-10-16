package com.example.listycity_lab6;

import java.util.ArrayList;
import java.util.List;

/**
    This is a class that defines a City.
    Have attributes city and province
 **/
public class City implements Comparable<City>{
    private String city;
    private String province;

    City(String city, String province) {
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
}
