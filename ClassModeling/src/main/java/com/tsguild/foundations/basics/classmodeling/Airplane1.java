/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.classmodeling;
/**
 *
 * @author Bruce_Breslin
 */
public class Airplane1 {
    private String tailNumber;
    private String takeoffLocation;
    private String destination;
    private String planeType;
    private String airlineName;
    private int passengersAboard;
    private int crewAboard;
    private double speed;
    private double altitude;
    private double longitude;
    private double latitude;
    private String directionOfTravel;
    private String statusOfFlight;

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getTakeoffLocation() {
        return takeoffLocation;
    }

    public void setTakeoffLocation(String takeoffLocation) {
        this.takeoffLocation = takeoffLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getPassengersAboard() {
        return passengersAboard;
    }

    public void setPassengersAboard(int passengersAboard) {
        this.passengersAboard = passengersAboard;
    }

    public int getCrewAboard() {
        return crewAboard;
    }

    public void setCrewAboard(int crewAboard) {
        this.crewAboard = crewAboard;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDirectionOfTravel() {
        return directionOfTravel;
    }

    public void setDirectionOfTravel(String directionOfTravel) {
        this.directionOfTravel = directionOfTravel;
    }

    public String getStatusOfFlight() {
        return statusOfFlight;
    }

    public void setStatusOfFlight(String statusOfFlight) {
        this.statusOfFlight = statusOfFlight;
    }
    
}
