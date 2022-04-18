package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author TruthK
 */
public class Station {
    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("station_name")
    private String stationName;

    @JsonProperty("location")
    private String location;
    @JsonProperty("parent_location")
    private String parentLocation;

    @JsonProperty("address")
    private String address;


    public Station() {
    }

    public Station(String stationId, String stationName, String location, String parentLocation, String address) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.location = location;
        this.parentLocation = parentLocation;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId='" + stationId + '\'' +
                ", stationName='" + stationName + '\'' +
                ", location='" + location + '\'' +
                ", parentLocation='" + parentLocation + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(String parentLocation) {
        this.parentLocation = parentLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}