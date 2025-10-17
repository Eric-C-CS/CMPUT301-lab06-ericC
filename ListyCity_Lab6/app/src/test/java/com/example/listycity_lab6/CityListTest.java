package com.example.listycity_lab6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities().size());
        City city = new City("Regina","SK");
        cityList.add(city);
        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCityTrue() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testHasCityFalse() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    @Test
    void testCountCitiesInitial() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterAdd() {
        CityList cityList = mockCityList();
        cityList.add(new City("Calgary", "Alberta"));
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(3, cityList.countCities());
    }

    @Test
    void testCountCitiesAfterDelete() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
}