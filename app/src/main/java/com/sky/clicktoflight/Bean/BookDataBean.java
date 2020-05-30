package com.sky.clicktoflight.Bean;

public class BookDataBean {
    private int UID;
    private int BID;
    private String FlightNumber;
    private String Seat;
    private String FlightCompany;

    public BookDataBean() {
    }

    public BookDataBean(int UID, int BID, String flightNumber, String seat, String flightCompany) {
        this.UID = UID;
        this.BID = BID;
        FlightNumber = flightNumber;
        Seat = seat;
        FlightCompany = flightCompany;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    public String getFlightCompany() {
        return FlightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        FlightCompany = flightCompany;
    }

    @Override
    public String toString() {
        return "BookDataBean{" +
                "UID=" + UID +
                ", BID=" + BID +
                ", FlightNumber='" + FlightNumber + '\'' +
                ", Seat='" + Seat + '\'' +
                ", FlightCompany='" + FlightCompany + '\'' +
                '}';
    }
}
