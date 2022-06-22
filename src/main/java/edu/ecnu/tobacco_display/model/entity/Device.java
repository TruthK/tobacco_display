package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author TruthK
 */
public class Device {
    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("device_name")
    private String deviceName;
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
    @JsonProperty("head")
    private String head;
    @JsonProperty("head_phone")
    private String headPhone;

    @JsonProperty("kind")
    private int kind;

    @JsonProperty("sensors")
    private String sensors;
    @JsonProperty("group_id")
    private String groupId;


    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonProperty("GPS")
    private String GPS;
    @JsonProperty("elevation")
    private String elevation;
    @JsonProperty("fuel_type")
    private String fuelType;
    @JsonProperty("specifications_room")
    private String specificationsRoom;
    @JsonProperty("supplier_device")
    private String supplierDevice;
    @JsonProperty("airflow_mode")
    private String airflowMode;
    @JsonProperty("structural_form")
    private String structuralForm;
    @JsonProperty("beneficiary_entity")
    private String beneficiaryEntity;

    @JsonProperty("technician_id")
    private String technicianId;
    @JsonProperty("technician_name")
    private String technicianName;
    @JsonProperty("technician_phone")
    private String technicianPhone;


    public Device() {
    }


    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(String parentLocation) {
        this.parentLocation = parentLocation;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getHeadPhone() {
        return headPhone;
    }

    public void setHeadPhone(String headPhone) {
        this.headPhone = headPhone;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
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

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    public String getTechnicianPhone() {
        return technicianPhone;
    }

    public void setTechnicianPhone(String technicianPhone) {
        this.technicianPhone = technicianPhone;
    }
}