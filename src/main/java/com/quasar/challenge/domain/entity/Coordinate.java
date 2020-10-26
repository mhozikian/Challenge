package com.quasar.challenge.domain.entity;

/**
 * @author mhozikian
 */
public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(){}
    public Coordinate(double latitude, double longitude){
        this.latitude  = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double px) {
        latitude  = px;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLongitude(double py) {
        longitude  = py;
    }
    public double getLongitude() {
        return longitude;
    }
}
