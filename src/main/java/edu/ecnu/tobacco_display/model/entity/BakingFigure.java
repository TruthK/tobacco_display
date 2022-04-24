package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class BakingFigure {

    @JsonProperty("end_time")
    private Date endTime;
    @JsonProperty("find_start_time")
    private Date findStartTime;
    @JsonProperty("find_end_time")
    private Date findEndTime;


    @JsonProperty("baking_weight_before")
    private double bakingWeightBefore;
    @JsonProperty("baking_weight_after")
    private double bakingWeightAfter;
    @JsonProperty("score")
    private double score;
    @JsonProperty("score_upper_bound")
    private double scoreUpperBound;
    @JsonProperty("score_lower_bound")
    private double scoreLowerBound;

    @JsonProperty("station_id")
    private String stationId;
    @JsonProperty("location")
    private String location;
    @JsonProperty("parent_location")
    private String parentLocation;
    @JsonProperty("tobacco_info")
    private String tobaccoInfo;

    public BakingFigure() {
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getFindStartTime() {
        return findStartTime;
    }

    public void setFindStartTime(Date findStartTime) {
        this.findStartTime = findStartTime;
    }

    public Date getFindEndTime() {
        return findEndTime;
    }

    public void setFindEndTime(Date findEndTime) {
        this.findEndTime = findEndTime;
    }

    public double getBakingWeightBefore() {
        return bakingWeightBefore;
    }

    public void setBakingWeightBefore(double bakingWeightBefore) {
        this.bakingWeightBefore = bakingWeightBefore;
    }

    public double getBakingWeightAfter() {
        return bakingWeightAfter;
    }

    public void setBakingWeightAfter(double bakingWeightAfter) {
        this.bakingWeightAfter = bakingWeightAfter;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScoreUpperBound() {
        return scoreUpperBound;
    }

    public void setScoreUpperBound(double scoreUpperBound) {
        this.scoreUpperBound = scoreUpperBound;
    }

    public double getScoreLowerBound() {
        return scoreLowerBound;
    }

    public void setScoreLowerBound(double scoreLowerBound) {
        this.scoreLowerBound = scoreLowerBound;
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

    public String getTobaccoInfo() {
        return tobaccoInfo;
    }

    public void setTobaccoInfo(String tobaccoInfo) {
        this.tobaccoInfo = tobaccoInfo;
    }
}
