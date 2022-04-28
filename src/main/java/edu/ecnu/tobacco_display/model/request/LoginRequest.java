package edu.ecnu.tobacco_display.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录 request
 */
public class LoginRequest {
    @ApiModelProperty(value = "手机号", required = true, example = "15021118366")
    private String phone;

    @JsonProperty("user_id")
    @ApiModelProperty(value = "用户id", required = true, example = "admin")
    private String userId;

    @ApiModelProperty(value = "用户密码", required = true, example = "123456")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        this.phone = userId;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
