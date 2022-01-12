package edu.ecnu.tobacco_display.service;


import edu.ecnu.tobacco_display.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);


    String findByUserIdAndPassword(String userId, String password);

    User findByUserId(String userId);

    User findByPhone(String phone);
}
