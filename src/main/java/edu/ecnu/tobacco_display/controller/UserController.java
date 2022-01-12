package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.User;
import edu.ecnu.tobacco_display.model.request.LoginRequest;
import edu.ecnu.tobacco_display.service.UserService;
import edu.ecnu.tobacco_display.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/LoginPage")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("Register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);

        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请重试");

    }


    /**
     * 登录接口
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("Login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getUserId() + "   " + loginRequest.getPassword());
        String token = userService.findByUserIdAndPassword(loginRequest.getUserId(), loginRequest.getPassword());

        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);

    }


    /**
     * 根据用户id查询用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {

        String userId = (String) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }

        User user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);

    }

}
