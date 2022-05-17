package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class DeviceGroup {
    @JsonProperty("group_id")
    private String groupId;
    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("info")
    private String info;

    @JsonProperty("address")
    private String address;
    @JsonProperty("head")
    private String head;
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("station_name")
    private String stationName;

    @JsonProperty("location")
    private String location;
    @JsonProperty("parent_location")
    private String parentLocation;

    public DeviceGroup() {
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}