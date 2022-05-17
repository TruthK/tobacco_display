package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.DeviceGroup;
import edu.ecnu.tobacco_display.service.DeviceGroupService;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 设备管理接口
 *
 * @author TruthK
 */
@RestController
@RequestMapping("/deviceGroup")
@Api(tags = "烤房群接口")
public class DeviceGroupController {
    @Autowired
    private DeviceGroupService deviceGroupService;


    @PostMapping("addDeviceGroup")
    @Operation(summary = "添加")
    public JsonData addDeviceGroup(@RequestBody Map<String, String> deviceGroupInfo) {
        int rows = deviceGroupService.saveDeviceGroupInfo(deviceGroupInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("showDeviceGroups")
    @Operation(summary = "查找")
    public JsonData showDeviceGroups(@RequestBody Map<String, String> deviceGroupInfo) {
        List<DeviceGroup> deviceGroups = deviceGroupService.findDeviceGroupByOptions(deviceGroupInfo);
        return deviceGroups != null ? JsonData.buildSuccess(deviceGroups) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterDeviceGroup")
    @Operation(summary = "修改")
    public JsonData alterDeviceGroup(@RequestBody Map<String, String> deviceGroupInfo) {
        int rows = deviceGroupService.alterDeviceGroupInfo(deviceGroupInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteDeviceGroup")
    @Operation(summary = "删除")
    public JsonData deleteDeviceGroup(@RequestBody Map<String, String> deviceGroupInfo) {
        int rows = deviceGroupService.deleteDeviceGroup(deviceGroupInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }



}
