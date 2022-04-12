package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * <p>
 * CREATE TABLE IF NOT EXISTS `bakehouse_sensors_records`(
 * `produce_date` DATETIME NOT NULL COMMENT '传感器数据产生的时间',
 * `dry_ball_Temp` FLOAT NOT NULL COMMENT '干球温度',
 * `wet_ball_Temp` FLOAT NOT NULL COMMENT '湿球温度',
 * `dry_ball_target` FLOAT NOT NULL COMMENT '干球目标温度',
 * `wet_ball_target` FLOAT NOT NULL COMMENT '湿球目标温度',
 * `location`  VARCHAR(64) NOT NULL,
 * `equipment_No` VARCHAR(64) NOT NULL COMMENT '烤房编号',
 * index  info(location,equipment_No)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class DetailRoastedTobacco {


    private Integer id;

    @JsonProperty("produce_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date produceDate;

    private Double dryBallTemp;
    private Double wetBallTemp;
    private Double dryBallTarget;
    private Double wetBallTarget;

    @JsonProperty("location")
    private String location;
    @JsonProperty("equipment_No")
    private String equipmentNo;

//    @JsonProperty("roasted_tobacco_list")
//    private List<DetailRoastedTobacco> detailRoastedTobaccoList;

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

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

//    public List<DetailRoastedTobacco> getRoastedTobaccoList() {
//        return detailRoastedTobaccoList;
//    }
//
////    public void setRoastedTobaccoList(List<DetailRoastedTobacco> detailRoastedTobaccoList) {
////        this.detailRoastedTobaccoList = detailRoastedTobaccoList;
////    }
}
