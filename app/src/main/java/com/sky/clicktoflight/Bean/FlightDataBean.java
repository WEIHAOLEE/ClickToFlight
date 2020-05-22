package com.sky.clicktoflight.Bean;

import java.io.Serializable;

public class FlightDataBean implements Serializable {
    private int flightNum;
    private String flightCompany;
    private String planeModel;
    private String depTime;
    private String depAirport;
    private String arrTime;
    private String arrAirport;
    private String onTime;
    private int price;
    private int flightTime;

    public FlightDataBean(int flightNum, String flightCompany, String planeModel, String depTime, String depAirport, String arrTime, String arrAirport, String onTime, int price, int flightTime) {
        this.flightNum = flightNum;
        this.flightCompany = flightCompany;
        this.planeModel = planeModel;
        this.depTime = depTime;
        this.depAirport = depAirport;
        this.arrTime = arrTime;
        this.arrAirport = arrAirport;
        this.onTime = onTime;
        this.price = price;
        this.flightTime = flightTime;
    }

    @Override
    public String toString() {
        return "FlightDataBean{" +
                "flightNum=" + flightNum +
                ", flightCompany='" + flightCompany + '\'' +
                ", planeModel='" + planeModel + '\'' +
                ", depTime='" + depTime + '\'' +
                ", depAirport='" + depAirport + '\'' +
                ", arrTime='" + arrTime + '\'' +
                ", arrAirport='" + arrAirport + '\'' +
                ", onTime='" + onTime + '\'' +
                ", price=" + price +
                ", flightTime=" + flightTime +
                '}';
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public FlightDataBean() {
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
