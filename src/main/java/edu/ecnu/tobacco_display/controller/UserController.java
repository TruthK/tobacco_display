package edu.ecnu.tobacco_display.controller;


import com.alibaba.fastjson.JSON;
import edu.ecnu.tobacco_display.model.entity.LoginUser;
import edu.ecnu.tobacco_display.model.entity.User;
import edu.ecnu.tobacco_display.model.request.LoginRequest;
import edu.ecnu.tobacco_display.service.UserService;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    @ApiOperation(value = "注册")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "query", name = "nname", value = "用户昵称", dataTypeClass = String.class),
//            @ApiImplicitParam(paramType = "query", name = "user_id", value = "用户id", dataTypeClass = String.class),
//            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", dataTypeClass = String.class),
//            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", dataTypeClass = String.class),
//    }
//    )
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请确认输入无误");
    }


    /**
     * 登录接口
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    @ApiOperation(value = "登录")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        LoginUser loginUser = userService.findByUserIdAndPassword(loginRequest.getUserId(), loginRequest.getPassword());
        return loginUser == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(loginUser);
    }

    @PostMapping("alterUserInfo")
    @ApiOperation(value = "修改用户信息")
    public JsonData alterUserInfo(@RequestBody Map<String, String> userInfo) {
        int rows = userService.alterUserInfo(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("修改信息失败，请确认输入无误");
    }


    /**
     * 根据用户id查询用户信息
     *
     * @param queryInfo
     * @return
     */
    @GetMapping("findByUserIdOrPhone")
    @ApiOperation("根据用户id查询用户信息")
    public JsonData findByUserIdOrPhone(@ApiParam(value="用户id或手机号", required = true, example = "15021118366") @RequestParam("query_info") String queryInfo) {
        if (queryInfo == null) {
            return JsonData.buildError("请确认输入无误");
        }
        User user = userService.findByUserIdOrPhone(queryInfo);
        return JsonData.buildSuccess(user);
    }

}
