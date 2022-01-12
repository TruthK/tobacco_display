package edu.ecnu.tobacco_display.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class QueryOptionsRequest {
    @JsonProperty("start_time")
    private Date startTime;
    @JsonProperty("end_time")
    private Date endTime;
    @JsonProperty("equipment_No")
    private String equipmentNo;
    private String location;

    @JsonProperty("dry_ball_Temp")
    private Double dryBallTemp;
    @JsonProperty("wet_ball_Temp")
    private Double wetBallTemp;
    @JsonProperty("dry_ball_target")
    private Double dryBallTarget;
    @JsonProperty("wet_ball_target")
    private Double wetBallTarget;

    @Override
    public String toString() {
        return "QueryOptionsRequest{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", equipmentNo='" + equipmentNo + '\'' +
                ", location='" + location + '\'' +
                ", dryBallTemp=" + dryBallTemp +
                ", wetBallTemp=" + wetBallTemp +
                ", dryBallTarget=" + dryBallTarget +
                ", wetBallTarget=" + wetBallTarget +
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

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDryBallTemp() {
        return dryBallTemp;
    }

    public void setDryBallTemp(Double dryBallTemp) {
        this.dryBallTemp = dryBallTemp;
    }

    public Double getWetBallTemp() {
        return wetBallTemp;
    }

    public void setWetBallTemp(Double wetBallTemp) {
        this.wetBallTemp = wetBallTemp;
    }

    public Double getDryBallTarget() {
        return dryBallTarget;
    }

    public void setDryBallTarget(Double dryBallTarget) {
        this.dryBallTarget = dryBallTarget;
    }

    public Double getWetBallTarget() {
        return wetBallTarget;
    }

    public void setWetBallTarget(Double wetBallTarget) {
        this.wetBallTarget = wetBallTarget;
    }
}
