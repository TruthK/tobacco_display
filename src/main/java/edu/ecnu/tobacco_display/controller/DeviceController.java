package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.Device;
import edu.ecnu.tobacco_display.service.BakingService;
import edu.ecnu.tobacco_display.service.DeviceService;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
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
@Api(tags = "设备管理接口")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private BakingService bakingRecordService;


    @PostMapping("addDevice")
    @Operation(summary = "添加")
    public JsonData addDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.saveDeviceInfo(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("showDevices")
    @Operation(summary = "查询")
    public JsonData showDevices(@RequestBody Map<String, String> deviceInfo) {
        List<Device> devices = deviceService.findDeviceByOptions(deviceInfo);
        return devices != null ? JsonData.buildSuccess(devices) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterDevice")
    @Operation(summary = "修改")
    public JsonData alterDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.alterDeviceInfo(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteDevice")
    @Operation(summary = "删除")
    public JsonData deleteDevice(@RequestBody Map<String, String> deviceInfo) {
        int rows = deviceService.deleteDevice(deviceInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("bakingDevice")
    @Operation(summary = "正在烘烤的")
    public JsonData bakingDevice(@RequestBody Map<String, String> deviceInfo) {
        List<BakingRecord> bakingRecords = bakingRecordService.CountBakingRecordsNumbers(deviceInfo);
        return bakingRecords != null ? JsonData.buildSuccess(bakingRecords) : JsonData.buildError("请确认输入无误");
    }


}
