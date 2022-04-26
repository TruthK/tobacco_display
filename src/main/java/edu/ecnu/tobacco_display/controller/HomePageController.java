package edu.ecnu.tobacco_display.controller;

import com.alibaba.fastjson.JSON;
import edu.ecnu.tobacco_display.model.entity.CityMap;
import edu.ecnu.tobacco_display.utils.JsonData;
import edu.ecnu.tobacco_display.utils.SerializeUtil;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.Map;

/**
 * 首页接口
 *
 * @author TruthK
 */
@RestController
@RequestMapping("/homePage")
@Api(tags = "首页接口")
public class HomePageController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 地区及设备信息分布数据接口
     */
    @PostMapping("queryData")
    @Operation(summary = "地区及设备信息分布数据接口")
    public JsonData queryDistribution(@RequestBody Map<String, Date> timeRange) {
        Date startTime = timeRange.get("startTime");
        Date endTime = timeRange.get("endTime");
        String cityMapJson = (String) redisTemplate.opsForValue().get("city_map");
        CityMap cityMap = JSON.parseObject(cityMapJson, CityMap.class);
//        if (bytes.length <= 2) {
//            CityMap cityMap = null;
//            byte[] serialize = SerializeUtil.serialize(cityMap);
//            redisTemplate.opsForValue().set("test_9", serialize);
//        }
        return cityMap.getChildren().size() >= 3 ? JsonData.buildSuccess(cityMap) : JsonData.buildError("查询失败，请确认输入无误");
    }

    /**
     * 设备运行时间概览查询接口
     */
    @PostMapping("mapData/run/")
    @Operation(summary = "设备运行时间概览查询接口")
    public JsonData queryRunEquipment(@RequestBody Map<String, String> runEquipmentInfo) {


        return 1 == 1 ? JsonData.buildSuccess() : JsonData.buildError("查询失败，请确认输入无误");
    }
}
