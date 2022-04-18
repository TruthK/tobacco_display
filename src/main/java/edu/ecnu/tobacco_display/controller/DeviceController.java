package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.Device;
import edu.ecnu.tobacco_display.service.DeviceService;
import edu.ecnu.tobacco_display.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 设备管理接口
 *
 * @author TruthK
 */
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;


    @PostMapping("addDevice")
    public JsonData addDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.saveDeviceInfo(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("showDevices")
    public JsonData showDevices(@RequestBody Map<String, String> deviceInfo) {
        List<Device> devices = deviceService.findDeviceByOptions(deviceInfo);
        return devices != null ? JsonData.buildSuccess(devices) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterDevice")
    public JsonData alterDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.alterDeviceInfo(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteDevice")
    public JsonData deleteDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.deleteDevice(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }



}
