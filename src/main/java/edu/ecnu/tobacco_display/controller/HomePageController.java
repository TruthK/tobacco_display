package edu.ecnu.tobacco_display.controller;

import com.alibaba.fastjson.JSON;
import edu.ecnu.tobacco_display.model.entity.CityMap;
import edu.ecnu.tobacco_display.utils.JsonData;
import edu.ecnu.tobacco_display.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 首页接口
 *
 * @author TruthK
 */
@RestController
@RequestMapping("/homePage")
public class HomePageController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 地区及设备信息分布数据接口
     */
    @PostMapping("queryData")
    public JsonData queryDistribution(@RequestBody Map<String, Date> timeRange) {
        Date startTime = timeRange.get("startTime");
        Date endTime = timeRange.get("endTime");
        byte[] bytes = (byte[]) redisTemplate.opsForValue().get("city_map");

//        if (bytes.length <= 2) {
//            CityMap cityMap = null;
//            byte[] serialize = SerializeUtil.serialize(cityMap);
//            redisTemplate.opsForValue().set("test_9", serialize);
//        }
        CityMap citymap = (CityMap) SerializeUtil.unserialize(bytes);
        return citymap.getChildren().size() >= 3 ? JsonData.buildSuccess(JSON.toJSONString(citymap)) : JsonData.buildError("查询失败，请重试");
    }

    /**
     * 设备运行时间概览查询接口
     */
    @PostMapping("mapData/run/")
    public JsonData queryRunEquipment(@RequestBody Map<String, String> runEquipmentInfo) {


        return 1 == 1 ? JsonData.buildSuccess() : JsonData.buildError("查询失败，请重试");
    }
}
