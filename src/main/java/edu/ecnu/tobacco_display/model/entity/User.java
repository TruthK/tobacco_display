package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * CREATE TABLE IF NOT EXISTS `user`(
 * `user_id` VARCHAR(256) unique NOT NULL COMMENT '用户id',
 * `phone` varchar(64) unique NOT NULL COMMENT '手机号',
 * `password` VARCHAR(256) NOT NULL COMMENT '用户密码',
 * `nname` VARCHAR(16) NOT NULL COMMENT '用户昵称',
 * `category` varchar(32) DEFAULT '1' COMMENT '类别',
 * `head_img` VARCHAR(256) COMMENT '头像图片',
 * `create_time` timestamp NULL default CURRENT_TIMESTAMP COMMENT '用户创建时间',
 * PRIMARY KEY (user_id),
 * index info(user_id,phone))ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 * @author TruthK
 */
@ApiModel("用户实体类")
public class User {
    @JsonProperty("nname")
    @ApiModelProperty(value = "用户昵称", required = false, example = "测试用户昵称")
    private String nname;

    @JsonIgnore
    @ApiModelProperty(value = "用户密码", required = true, example = "123456")
    private String password;

    @JsonProperty("head_img")
    @ApiModelProperty(value = "用户头像", required = false)
    private String headImg;
    @JsonProperty("user_id")
    @ApiModelProperty(value = "用户id", required = true, example = "admin")
    private String userId;


    @JsonProperty("phone")
    @ApiModelProperty(value = "手机号", required = false, example = "15021118366")
    private String phone;

    @JsonProperty("category")
    @ApiModelProperty(value = "权限类别", required = false, example = "1")
    private String category;

    @JsonProperty("permission_range")
    @ApiModelProperty(value = "权限范围（烟站），针对烟站人员和普通用户",
            required = false, example = "671000")
    private String permissionRange;

    @JsonProperty("create_time")
    @ApiModelProperty(value = "用户创建时间", required = false)
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
