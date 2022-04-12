package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int save(User user);

    int alterUserInfo(User user);

    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    User findByUserIdAndPassword(@Param("user_id") String UserId, @Param("password") String password);

    User findByUserId(String userId);
}
