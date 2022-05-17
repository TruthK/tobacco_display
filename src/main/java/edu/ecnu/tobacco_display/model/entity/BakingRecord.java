package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class BakingRecord {

    @JsonProperty("id")
    private int id;
    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("start_time")
    private Date startTime;
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


    @JsonProperty("loss_rate")
    private double lossRate;
    @JsonProperty("loss_rate_upper_bound")
    private double lossRateUpperBound;
    @JsonProperty("loss_rate_lower_bound")
    private double lossRateLowerBound;

    @JsonProperty("cyanosis_rate")
    private double cyanosisRate;
    @JsonProperty("cyanosis_rate_upper_bound")
    private double cyanosisRateUpperBound;
    @JsonProperty("cyanosis_rate_lower_bound")
    private double cyanosisRateLowerBound;

    @JsonProperty("noise_rate")
    private double noiseRate;
    @JsonProperty("noise_rate_upper_bound")
    private double noiseRateUpperBound;
    @JsonProperty("noise_rate_lower_bound")
    private double noiseRateLowerBound;

    @JsonProperty("water_rate")
    private double waterRate;

    @JsonProperty("single_leaf_before")
    private double singleLeafBefore;
    @JsonProperty("single_leaf_after")
    private double singleLeafAfter;

    @JsonProperty("leaf_area")
    private String leafArea;
    @JsonProperty("install_way")
    private String installWay;


    @JsonProperty("yellow_rate")
    private double yellowRate;
    @JsonProperty("yellow_rate_upper_bound")
    private double yellowRateUpperBound;
    @JsonProperty("yellow_rate_lower_bound")
    private double yellowRateLowerBound;


    @JsonProperty("location")
    private String location;
    @JsonProperty("parent_location")
    private String parentLocation;
    @JsonProperty("station_id")
    private String stationId;


    @JsonProperty("group_id")
    private String groupId;

    @JsonProperty("tobacco_info")
    private String tobaccoInfo;

    @JsonProperty("bake_pic_before")
    private String bakePicBefore;
    @JsonProperty("bake_pic_after")
    private String bakePicAfter;

    @JsonProperty("farmer_id")
    private String farmerId;
    @JsonProperty("technician_id")
    private String technicianId;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("nname")
    private String nname;

    public BakingRecord() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public double getLossRate() {
        return lossRate;
    }

    public void setLossRate(double lossRate) {
        this.lossRate = lossRate;
    }

    public double getLossRateUpperBound() {
        return lossRateUpperBound;
    }

    public void setLossRateUpperBound(double lossRateUpperBound) {
        this.lossRateUpperBound = lossRateUpperBound;
    }

    public double getLossRateLowerBound() {
        return lossRateLowerBound;
    }

    public void setLossRateLowerBound(double lossRateLowerBound) {
        this.lossRateLowerBound = lossRateLowerBound;
    }

    public double getCyanosisRate() {
        return cyanosisRate;
    }

    public void setCyanosisRate(double cyanosisRate) {
        this.cyanosisRate = cyanosisRate;
    }

    public double getCyanosisRateUpperBound() {
        return cyanosisRateUpperBound;
    }

    public void setCyanosisRateUpperBound(double cyanosisRateUpperBound) {
        this.cyanosisRateUpperBound = cyanosisRateUpperBound;
    }

    public double getCyanosisRateLowerBound() {
        return cyanosisRateLowerBound;
    }

    public void setCyanosisRateLowerBound(double cyanosisRateLowerBound) {
        this.cyanosisRateLowerBound = cyanosisRateLowerBound;
    }

    public double getNoiseRate() {
        return noiseRate;
    }

    public void setNoiseRate(double noiseRate) {
        this.noiseRate = noiseRate;
    }

    public double getNoiseRateUpperBound() {
        return noiseRateUpperBound;
    }

    public void setNoiseRateUpperBound(double noiseRateUpperBound) {
        this.noiseRateUpperBound = noiseRateUpperBound;
    }

    public double getNoiseRateLowerBound() {
        return noiseRateLowerBound;
    }

    public void setNoiseRateLowerBound(double noiseRateLowerBound) {
        this.noiseRateLowerBound = noiseRateLowerBound;
    }

    public double getYellowRate() {
        return yellowRate;
    }

    public void setYellowRate(double yellowRate) {
        this.yellowRate = yellowRate;
    }

    public double getYellowRateUpperBound() {
        return yellowRateUpperBound;
    }

    public void setYellowRateUpperBound(double yellowRateUpperBound) {
        this.yellowRateUpperBound = yellowRateUpperBound;
    }

    public double getYellowRateLowerBound() {
        return yellowRateLowerBound;
    }

    public void setYellowRateLowerBound(double yellowRateLowerBound) {
        this.yellowRateLowerBound = yellowRateLowerBound;
    }

    public String getBakePicBefore() {
        return bakePicBefore;
    }

    public void setBakePicBefore(String bakePicBefore) {
        this.bakePicBefore = bakePicBefore;
    }

    public String getBakePicAfter() {
        return bakePicAfter;
    }

    public void setBakePicAfter(String bakePicAfter) {
        this.bakePicAfter = bakePicAfter;
    }

    public double getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(double waterRate) {
        this.waterRate = waterRate;
    }

    public double getSingleLeafBefore() {
        return singleLeafBefore;
    }

    public void setSingleLeafBefore(double singleLeafBefore) {
        this.singleLeafBefore = singleLeafBefore;
    }

    public double getSingleLeafAfter() {
        return singleLeafAfter;
    }

    public void setSingleLeafAfter(double singleLeafAfter) {
        this.singleLeafAfter = singleLeafAfter;
    }

    public String getLeafArea() {
        return leafArea;
    }

    public void setLeafArea(String leafArea) {
        this.leafArea = leafArea;
    }

    public String getInstallWay() {
        return installWay;
    }

    public void setInstallWay(String installWay) {
        this.installWay = installWay;
    }
}
