package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * CREATE TABLE IF NOT EXISTS `bakehouse_sensors_records`(
 * `produce_date` DATETIME NOT NULL COMMENT '传感器数据产生的时间',
 * `dry_ball_Temp` FLOAT NOT NULL COMMENT '干球温度',
 * `wet_ball_Temp` FLOAT NOT NULL COMMENT '湿球温度',
 * `dry_ball_target` FLOAT NOT NULL COMMENT '干球目标温度',
 * `wet_ball_target` FLOAT NOT NULL COMMENT '湿球目标温度',
 * `location`  VARCHAR(64) NOT NULL,
 * `deviceId` VARCHAR(64) NOT NULL COMMENT '烤房编号',
 * index  info(location,deviceId)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class DetailRoastedTobacco {


    private Integer id;

    @JsonProperty("produce_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date produceDate;

    private Double dryBallTemp;
    @JsonProperty("dry_ball_temp_upper_bound")
    private double dryBallTempUpperBound;
    @JsonProperty("dry_ball_temp_lower_bound")
    private double dryBallTempLowerBound;

    private Double wetBallTemp;
    @JsonProperty("wet_ball_temp_upper_bound")
    private double wetBallTempUpperBound;
    @JsonProperty("wet_ball_temp_lower_bound")
    private double wetBallTempLowerBound;

    private Double dryBallTarget;
    @JsonProperty("dry_ball_target_upper_bound")
    private double dryBallTargetUpperBound;
    @JsonProperty("dry_ball_target_lower_bound")
    private double dryBallTargetLowerBound;

    private Double wetBallTarget;
    @JsonProperty("wet_ball_target_upper_bound")
    private double wetBallTargetUpperBound;
    @JsonProperty("wet_ball_target_lower_bound")
    private double wetBallTargetLowerBound;

    @JsonProperty("start_time")
    private Date startTime;
    @JsonProperty("end_time")
    private Date endTime;

    @JsonProperty("location")
    private String location;
    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("pic")
    private String pic;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public double getDryBallTempUpperBound() {
        return dryBallTempUpperBound;
    }

    public void setDryBallTempUpperBound(double dryBallTempUpperBound) {
        this.dryBallTempUpperBound = dryBallTempUpperBound;
    }

    public double getDryBallTempLowerBound() {
        return dryBallTempLowerBound;
    }

    public void setDryBallTempLowerBound(double dryBallTempLowerBound) {
        this.dryBallTempLowerBound = dryBallTempLowerBound;
    }

    public double getWetBallTempUpperBound() {
        return wetBallTempUpperBound;
    }

    public void setWetBallTempUpperBound(double wetBallTempUpperBound) {
        this.wetBallTempUpperBound = wetBallTempUpperBound;
    }

    public double getWetBallTempLowerBound() {
        return wetBallTempLowerBound;
    }

    public void setWetBallTempLowerBound(double wetBallTempLowerBound) {
        this.wetBallTempLowerBound = wetBallTempLowerBound;
    }

    public double getDryBallTargetUpperBound() {
        return dryBallTargetUpperBound;
    }

    public void setDryBallTargetUpperBound(double dryBallTargetUpperBound) {
        this.dryBallTargetUpperBound = dryBallTargetUpperBound;
    }

    public double getDryBallTargetLowerBound() {
        return dryBallTargetLowerBound;
    }

    public void setDryBallTargetLowerBound(double dryBallTargetLowerBound) {
        this.dryBallTargetLowerBound = dryBallTargetLowerBound;
    }

    public double getWetBallTargetUpperBound() {
        return wetBallTargetUpperBound;
    }

    public void setWetBallTargetUpperBound(double wetBallTargetUpperBound) {
        this.wetBallTargetUpperBound = wetBallTargetUpperBound;
    }

    public double getWetBallTargetLowerBound() {
        return wetBallTargetLowerBound;
    }

    public void setWetBallTargetLowerBound(double wetBallTargetLowerBound) {
        this.wetBallTargetLowerBound = wetBallTargetLowerBound;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
