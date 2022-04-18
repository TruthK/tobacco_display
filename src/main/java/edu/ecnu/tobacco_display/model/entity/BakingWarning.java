package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class BakingWarning {

    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("location")
    private String location;
    @JsonProperty("parent_location")
    private String parentLocation;

    @JsonProperty("warning_time")
    private Date warningTime;

    @JsonProperty("start_time")
    private Date startTime;
    @JsonProperty("end_time")
    private Date endTime;

    @JsonProperty("warning_1")
    private int warning1;
    @JsonProperty("warning_2")
    private int warning2;
    @JsonProperty("warning_3")
    private int warning3;
    @JsonProperty("warning_4")
    private int warning4;
    @JsonProperty("warning_5")
    private int warning5;
    @JsonProperty("warning_6")
    private int warning6;
    @JsonProperty("warning_7")
    private int warning7;

    public BakingWarning() {
    }


    public BakingWarning(String deviceId, String location, String parentLocation, Date warningTime, Date startTime, Date endTime, int warning1, int warning2, int warning3, int warning4, int warning5, int warning6, int warning7) {
        this.deviceId = deviceId;
        this.location = location;
        this.parentLocation = parentLocation;
        this.warningTime = warningTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.warning1 = warning1;
        this.warning2 = warning2;
        this.warning3 = warning3;
        this.warning4 = warning4;
        this.warning5 = warning5;
        this.warning6 = warning6;
        this.warning7 = warning7;
    }

    @Override
    public String toString() {
        return "BakingWarning{" +
                "deviceId='" + deviceId + '\'' +
                ", location='" + location + '\'' +
                ", parentLocation='" + parentLocation + '\'' +
                ", warningTime=" + warningTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", warning1=" + warning1 +
                ", warning2=" + warning2 +
                ", warning3=" + warning3 +
                ", warning4=" + warning4 +
                ", warning5=" + warning5 +
                ", warning6=" + warning6 +
                ", warning7=" + warning7 +
                '}';
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public int getWarning1() {
        return warning1;
    }

    public void setWarning1(int warning1) {
        this.warning1 = warning1;
    }

    public int getWarning2() {
        return warning2;
    }

    public void setWarning2(int warning2) {
        this.warning2 = warning2;
    }

    public int getWarning3() {
        return warning3;
    }

    public void setWarning3(int warning3) {
        this.warning3 = warning3;
    }

    public int getWarning4() {
        return warning4;
    }

    public void setWarning4(int warning4) {
        this.warning4 = warning4;
    }

    public int getWarning5() {
        return warning5;
    }

    public void setWarning5(int warning5) {
        this.warning5 = warning5;
    }

    public int getWarning6() {
        return warning6;
    }

    public void setWarning6(int warning6) {
        this.warning6 = warning6;
    }

    public int getWarning7() {
        return warning7;
    }

    public void setWarning7(int warning7) {
        this.warning7 = warning7;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(Date warningTime) {
        this.warningTime = warningTime;
    }

}
