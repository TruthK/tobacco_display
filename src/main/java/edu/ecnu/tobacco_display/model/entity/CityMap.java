package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class CityMap implements Serializable {
    @JsonProperty("location")
    private String location;

    private String name;
    private int total;
    private int abnormal;
    private ArrayList<CityMap> children;

    public CityMap(String location, String name, int total, int abnormal, ArrayList<CityMap> children) {
        this.location = location;
        this.name = name;
        this.total = total;
        this.abnormal = abnormal;
        this.children = children;
    }

    @Override
    public String toString() {
        return "CityMap{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", abnormal=" + abnormal +
                ", children=" + children +
                '}';
    }

    public CityMap(String location, String name, ArrayList<CityMap> children) {
        this.location = location;
        this.name = name;
        this.children = children;
    }

    public CityMap() {
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setAbnormal(int abnormal) {
        this.abnormal = abnormal;
    }

    public void setChildren(ArrayList<CityMap> children) {
        this.children = children;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public int getAbnormal() {
        return abnormal;
    }

    public ArrayList<CityMap> getChildren() {
        return children;
    }

}
