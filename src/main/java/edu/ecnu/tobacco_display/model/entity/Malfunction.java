package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Malfunction {
    /**
     * CREATE TABLE IF NOT EXISTS `malfunction`(
     * `id` int primary key not null auto_increment COMMENT '自增id',
     * `device_id` varchar(32)  NOT NULL  COMMENT '',
     * `trouble_unit` varchar(64)  COMMENT '故障部件：如风机电机、冷风进风门电机、 控制器保险管等',
     * `troubleshooting` VARCHAR(32) COMMENT '故障排除方式：如维修、更换等',
     * `repair_price` DOUBLE COMMENT '维修/更换价格（元）',
     * `repair_merchant` varchar(32)  COMMENT '维修/更换方：如自行、合作社、供应商等。',
     * `maintain_after_baking` VARCHAR(32) COMMENT '烤后保养维护：已/未保养维护 ',
     * `maintainer` VARCHAR(32) COMMENT '保养维护人员',
     * `supervision` VARCHAR(32) COMMENT '烤房使用管护监督：已/未监督',
     * `monitors` VARCHAR(32) COMMENT '监督人员',
     * index info(device_id,trouble_unit))ENGINE=InnoDB DEFAULT CHARSET=utf8;
     */

    @JsonProperty("id")
    private int id;

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("trouble_unit")
    private String troubleUnit;
    @JsonProperty("troubleshooting")
    private String troubleshooting;

    @JsonProperty("repair_price")
    private String repairPrice;
    @JsonProperty("repair_merchant")
    private String repairMerchant;
    @JsonProperty("maintain_after_baking")
    private String maintainAfterBaking;

    @JsonProperty("maintainer")
    private String maintainer;
    @JsonProperty("supervision")
    private String supervision;
    @JsonProperty("monitors")
    private String monitors;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonProperty("address")
    private String address;
    @JsonProperty("device_name")
    private String deviceName;
    @JsonProperty("station_id")
    private String stationId;

    @JsonProperty("group_id")
    private String groupId;
    @JsonProperty("GPS")
    private String GPS;
    @JsonProperty("beneficiary_entity")
    private String beneficiaryEntity;


    @JsonProperty("technician_id")
    private String technicianId;
    @JsonProperty("fuel_type")
    private String fuelType;
    @JsonProperty("specificationsRoom")
    private String specificationsRoom;

    @JsonProperty("supplier_device")
    private String supplierDevice;
    @JsonProperty("airflow_mode")
    private String airflowMode;
    @JsonProperty("structural_form")
    private String structuralForm;

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

    public String getTroubleUnit() {
        return troubleUnit;
    }

    public void setTroubleUnit(String troubleUnit) {
        this.troubleUnit = troubleUnit;
    }

    public String getTroubleshooting() {
        return troubleshooting;
    }

    public void setTroubleshooting(String troubleshooting) {
        this.troubleshooting = troubleshooting;
    }

    public String getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(String repairPrice) {
        this.repairPrice = repairPrice;
    }

    public String getRepairMerchant() {
        return repairMerchant;
    }

    public void setRepairMerchant(String repairMerchant) {
        this.repairMerchant = repairMerchant;
    }

    public String getMaintainAfterBaking() {
        return maintainAfterBaking;
    }

    public void setMaintainAfterBaking(String maintainAfterBaking) {
        this.maintainAfterBaking = maintainAfterBaking;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getSupervision() {
        return supervision;
    }

    public void setSupervision(String supervision) {
        this.supervision = supervision;
    }

    public String getMonitors() {
        return monitors;
    }

    public void setMonitors(String monitors) {
        this.monitors = monitors;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getBeneficiaryEntity() {
        return beneficiaryEntity;
    }

    public void setBeneficiaryEntity(String beneficiaryEntity) {
        this.beneficiaryEntity = beneficiaryEntity;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getSpecificationsRoom() {
        return specificationsRoom;
    }

    public void setSpecificationsRoom(String specificationsRoom) {
        this.specificationsRoom = specificationsRoom;
    }

    public String getSupplierDevice() {
        return supplierDevice;
    }

    public void setSupplierDevice(String supplierDevice) {
        this.supplierDevice = supplierDevice;
    }

    public String getAirflowMode() {
        return airflowMode;
    }

    public void setAirflowMode(String airflowMode) {
        this.airflowMode = airflowMode;
    }

    public String getStructuralForm() {
        return structuralForm;
    }

    public void setStructuralForm(String structuralForm) {
        this.structuralForm = structuralForm;
    }
}
