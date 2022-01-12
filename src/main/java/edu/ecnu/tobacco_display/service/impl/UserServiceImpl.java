package edu.ecnu.tobacco_display.service.impl;


import edu.ecnu.tobacco_display.mapper.UserMapper;
import edu.ecnu.tobacco_display.model.entity.User;
import edu.ecnu.tobacco_display.service.UserService;
import edu.ecnu.tobacco_display.utils.CommonUtils;
import edu.ecnu.tobacco_display.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (user != null) {
            return userMapper.save(user);
        } else {
            return -1;
        }

    }


    @Override
    public String findByUserIdAndPassword(String userId, String password) {
        User user = userMapper.findByUserIdAndPassword(userId, CommonUtils.MD5(password));
        if (user == null) {
            return null;

        } else {
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }

    }

    @Override
    public User findByUserId(String userId) {
        User user = userMapper.findByUserId(userId);
        return user;
    }

    @Override
    public User findByPhone(String phone) {
        User user = userMapper.findByUserId(phone);
        return user;
    }

    /**
     * 解析 user 对象
     *
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("user_id") && userInfo.containsKey("password") && userInfo.containsKey("nname") && userInfo.containsKey("phone")) {
            User user = new User();
            user.setPhone(userInfo.get("phone"));
            user.setCreateTime(new Date());
            user.setUserId(userInfo.get("user_id"));
            String password = userInfo.get("password");
            if (userInfo.get("category") == null) {
                user.setCategory("1");
            } else {
                user.setCategory(userInfo.get("category"));

            }
            //MD5加密
            user.setPassword(CommonUtils.MD5(password));

            user.setNname(userInfo.get("nname"));
            user.setHeadImg(getRandomImg());
            return user;
        } else {
            return null;
        }

    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String[] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }

}
