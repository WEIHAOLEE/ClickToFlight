package com.sky.clicktoflight.Model.DAO;

public interface AirportDao {

    void icaoQuery(String airportName);

    void airportQuery(String icao);

    void insert();
}
