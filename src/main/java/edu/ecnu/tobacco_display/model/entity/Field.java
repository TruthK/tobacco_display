package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * fieldId：烟田编号
 * location：烟田位置(具体位置，而非编号)
 * info：烟田信息，暂时未定具体内容
 * owner：烟田所属用户对应的编号，一块烟田只能有一个用户，一个用户可有多块烟田
 */
public class Field {
    @JsonProperty("field_id")
    private String fieldId;

    @JsonProperty("location")
    private String location;

    @JsonProperty("info")
    private String info;

    @JsonProperty("owner")
    private String owner;



    @JsonProperty("nname")
    private String nname;

    public Field() {
    }

    @Override
    public String toString() {
        return "Field{" +
                "fieldId='" + fieldId + '\'' +
                ", location='" + location + '\'' +
                ", info='" + info + '\'' +
                ", owner='" + owner + '\'' +
                ", nname='" + nname + '\'' +
                '}';
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setUserId(String owner) {
        this.owner = owner;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }
}
