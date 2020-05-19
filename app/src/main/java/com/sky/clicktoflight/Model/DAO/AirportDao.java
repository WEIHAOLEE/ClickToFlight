package com.sky.clicktoflight.Model.DAO;

public interface AirportDao {

    void icaoQuery(String airportName);

    String airportQuery(String icao);

    void insert();
}
