package edu.ecnu.tobacco_display.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class LoginUser {
    @JsonProperty("nname")
    private String nname;

    @JsonProperty("token")
    private String token;

    @JsonProperty("head_img")
    private String headImg;
    @JsonProperty("user_id")
    private String userId;


    @JsonProperty("phone")
    private String phone;

    @JsonProperty("category")
    private String category;

    public LoginUser() {
    }

    public LoginUser(String nname, String token, String headImg, String userId, String phone, String category) {
        this.nname = nname;
        this.token = token;
        this.headImg = headImg;
        this.userId = userId;
        this.phone = phone;
        this.category = category;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
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


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "nname='" + nname + '\'' +
                ", token='" + token + '\'' +
                ", headImg='" + headImg + '\'' +
                ", userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}
