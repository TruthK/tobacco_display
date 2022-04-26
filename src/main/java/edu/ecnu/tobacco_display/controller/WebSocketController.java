package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/open/socket")
@Api(tags = "各种警告相关接口")
public class WebSocketController {

    @Value("${webSocket.pwd}")
    public String myPwd;

    @Autowired
    private WebSocketServer webSocketServer;
    private Map<String, Float> tobaccoSetting = new HashMap<>();
    private Map<String, Float> curveSetting = new HashMap<>();


    /**
     * 设置曲线各阶段温度
     *
     * @param setting {"stage":temperature}
     * @param pwd
     * @return
     */
    @PostMapping(value = "/setCurveSetting")
    @Operation(summary = "设置曲线各阶段温度")
    public JsonData setCurveSetting(@RequestBody Map<String, Float> setting, String pwd) {
        try {
            if (pwd.equals(myPwd)) {
                this.curveSetting = setting;
                return JsonData.buildSuccess();
            } else return JsonData.buildError("密码错误");
        } catch (NullPointerException e) {
            return JsonData.buildError("请输入密码");
        }
    }

    /**
     * 设置某个阶段的温度
     *
     * @param stage       阶段
     * @param temperature 温度
     * @param pwd         密码
     * @return
     */
    @GetMapping("uploadCurveData")
    @Operation(summary = "设置某个阶段的温度，如果过高会通过websocket警告")
    public JsonData uploadCurveData(String stage, Float temperature, String pwd) throws IOException {
        try {
            if (pwd.equals(myPwd)) {
                if (curveSetting.getOrDefault(stage, Float.MAX_VALUE) < temperature) {
                    webSocketServer.broadCastInfo("第" + stage + "阶段，温度：" + temperature + "过高");
                }
                return JsonData.buildSuccess();
            } else return JsonData.buildError("密码错误");
        } catch (NullPointerException e) {
            return JsonData.buildError("请输入密码");
        }
    }

    /**
     * 设置参数与其对应阈值
     *
     * @param setting {"参数param":"阈值threshold"}
     * @param pwd     密码
     * @return
     */
    @PostMapping(value = "/setThreshold")
    @Operation(summary = "设置参数的阈值")
    public JsonData setTobaccoSetting(@RequestBody Map<String, Float> setting, String pwd) {
        try {
            if (pwd.equals(myPwd)) {  //密码校验一致（这里举例，实际开发还要有个密码加密的校验的），则进行群发
                this.tobaccoSetting = setting;
                return JsonData.buildSuccess();
            } else {
                return JsonData.buildError("密码错误");
            }
        } catch (NullPointerException e) {
            return JsonData.buildError("请输入密码");
        }
    }

    /**
     * 烘烤过程预警
     *
     * @param param 参数
     * @param data  参数对应的值
     * @param pwd   密码（实际开发记得加密）
     * @throws IOException
     */
    @GetMapping(value = "/uploadTobaccoData")
    @Operation(summary = "设置某个参数的当前值，如果过高会通过websocket警告")
    public JsonData uploadTobaccoData(String param, Float data, String pwd) throws IOException {
        try {
            if (pwd.equals(myPwd)) {  //密码校验一致（这里举例，实际开发还要有个密码加密的校验的），则进行群发
                if (this.tobaccoSetting.getOrDefault(param, Float.MAX_VALUE) < data) {
                    webSocketServer.broadCastInfo("参数" + param + "，当前值为：" + data + "，过高");
                }
                return JsonData.buildSuccess();
            } else {
                return JsonData.buildError("密码错误");
            }
        } catch (NullPointerException e) {
            return JsonData.buildError("请输入密码");
        }
    }


}