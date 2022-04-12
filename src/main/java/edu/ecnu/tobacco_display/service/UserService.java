package edu.ecnu.tobacco_display.service;


import edu.ecnu.tobacco_display.model.entity.LoginUser;
import edu.ecnu.tobacco_display.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    /**
     * 修改用户信息
     *
     * @param userInfo
     * @return
     */
    int alterUserInfo(Map<String, String> userInfo);

    /**
     * 比如密码和用户名是否一致
     *
     * @param userId password
     * @return
     */
    LoginUser findByUserIdAndPassword(String userId, String password);

    User findByUserId(String userId);

    User findByPhone(String phone);
}
