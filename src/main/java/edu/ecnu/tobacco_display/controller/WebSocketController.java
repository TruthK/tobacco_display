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
    @Autowired
    private WebSocketServer webSocketServer;
    private Map<String, Float> tobaccoSetting = new HashMap<>();
    private Map<String, Float> curveSetting = new HashMap<>();


    /**
     * 设置曲线各阶段温度
     *
     * @param setting {"stage":temperature}
     * @return
     */
    @PostMapping(value = "/setCurveSetting")
    @Operation(summary = "设置曲线各阶段温度")
    public JsonData setCurveSetting(@RequestBody Map<String, Float> setting) {
        this.curveSetting = setting;
        return JsonData.buildSuccess();

    }

    /**
     * 设置某个阶段的温度
     * @param stage       阶段
     * @param temperature 温度
     * @return
     */
    @GetMapping("uploadCurveData")
    @Operation(summary = "设置某个阶段的温度，如果过高会通过websocket警告")
    public JsonData uploadCurveData(String stage, Float temperature) throws IOException {
        if (curveSetting.getOrDefault(stage, Float.MAX_VALUE) < temperature) {
            webSocketServer.broadCastInfo("第" + stage + "阶段，温度：" + temperature + "过高");
        }
        return JsonData.buildSuccess();
    }

    /**
     * 设置参数与其对应阈值
     *
     * @param setting {"参数param":"阈值threshold"}
     * @return
     */
    @PostMapping(value = "/setThreshold")
    @Operation(summary = "设置参数的阈值")
    public JsonData setTobaccoSetting(@RequestBody Map<String, Float> setting) {

        this.tobaccoSetting = setting;
        return JsonData.buildSuccess();
    }

    /**
     * 烘烤过程预警
     *
     * @param param 参数
     * @param data  参数对应的值
     * @throws IOException
     */
    @GetMapping(value = "/uploadTobaccoData")
    @Operation(summary = "设置某个参数的当前值，如果过高会通过websocket警告")
    public JsonData uploadTobaccoData(String param, Float data) throws IOException {
        if (this.tobaccoSetting.getOrDefault(param, Float.MAX_VALUE) < data) {
            webSocketServer.broadCastInfo("参数" + param + "，当前值为：" + data + "，过高");
        }
        return JsonData.buildSuccess();

    }
}