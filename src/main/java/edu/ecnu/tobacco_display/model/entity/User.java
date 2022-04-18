package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * CREATE TABLE IF NOT EXISTS `user`(
 * `user_id` VARCHAR(256) unique NOT NULL COMMENT '用户id',
 * `phone` varchar(64) unique NOT NULL COMMENT '手机号',
 * `password` VARCHAR(256) NOT NULL COMMENT '用户密码',
 * `nname` VARCHAR(16) NOT NULL COMMENT '用户昵称',
 * `category` varchar(32) DEFAULT '1' COMMENT '类别',
 * `head_img` VARCHAR(256) COMMENT '湿球目标温度',
 * `create_time` timestamp NULL default CURRENT_TIMESTAMP COMMENT '用户创建时间',
 * PRIMARY KEY (user_id),
 * index info(user_id,phone))ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 * @author TruthK
 */
public class User {
    @JsonProperty("nname")
    private String nname;

    @JsonIgnore
    private String password;

    @JsonProperty("head_img")
    private String headImg;
    @JsonProperty("user_id")
    private String userId;


    @JsonProperty("phone")
    private String phone;

    @JsonProperty("category")
    private String category;

    @JsonProperty("permission_range")
    private String permissionRange;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPermissionRange() {
        return permissionRange;
    }

    public void setPermissionRange(String permissionRange) {
        this.permissionRange = permissionRange;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
