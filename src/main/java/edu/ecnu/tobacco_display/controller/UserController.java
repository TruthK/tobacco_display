package edu.ecnu.tobacco_display.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.model.entity.Field;
import edu.ecnu.tobacco_display.model.entity.LoginUser;
import edu.ecnu.tobacco_display.model.entity.User;
import edu.ecnu.tobacco_display.model.request.LoginRequest;
import edu.ecnu.tobacco_display.service.UserService;
import edu.ecnu.tobacco_display.utils.CommonUtils;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * 根据地区查询技师
     *
     * @param location
     * @return
     */
    @GetMapping("findTechnicians")
    @ApiOperation("根据用户id查询用户信息")
    public JsonData findTechnicians(@RequestParam("location") String location,@RequestParam("user_id") String userId) {
        if(location.length()>0||userId.length()>0){
            User user = userService.findTechnicians(location,userId);
            return JsonData.buildSuccess(user);
        }else {
            return JsonData.buildError("请确认输入无误");
        }

    }

    /**
     * 批量注册接口
     *
     * @param usersList
     * @return
     */
    @PostMapping("batchRegister")
    public JsonData batchRegister(@RequestBody List<Map<String, String>> usersList) {
        ArrayList<User> failRegisterList = new ArrayList<>();
        for (int i = 0; i < usersList.size(); i++) {
            int rows = userService.save(usersList.get(i));
            if(rows!=1){
                Map<String, String> failUserMap = CommonUtils.formatHumpName(usersList.get(i));
                User failedUser = JSONObject.parseObject(JSONObject.toJSONString(failUserMap), User.class);
                failRegisterList.add(failedUser);
            }
        }

        return failRegisterList.size() !=usersList.size() ? JsonData.buildSuccess(failRegisterList) :
                JsonData.buildError(
                "注册失败，请确认输入无误");
    }

}
