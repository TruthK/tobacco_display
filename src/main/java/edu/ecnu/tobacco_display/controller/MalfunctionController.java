package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.Malfunction;
import edu.ecnu.tobacco_display.service.BakingService;
import edu.ecnu.tobacco_display.service.MalfunctionService;
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
@RequestMapping("/malfunction")
@Api(tags = "设备管理接口")
public class MalfunctionController {
    @Autowired
    private MalfunctionService malfunctionService;

    @PostMapping("addMalfunction")
    @Operation(summary = "添加")
    public JsonData addMalfunction(@RequestBody Map<String, String> malfunctionInfo) {
        int rows = malfunctionService.saveMalfunctionInfo(malfunctionInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("showMalfunctions")
    @Operation(summary = "查询")
    public JsonData showMalfunctions(@RequestBody Map<String, String> malfunctionInfo) {
        List<Malfunction> malfunctions = malfunctionService.findMalfunctionByOptions(malfunctionInfo);
        return malfunctions != null ? JsonData.buildSuccess(malfunctions) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterMalfunction")
    @Operation(summary = "修改")
    public JsonData alterMalfunction(@RequestBody Map<String, String> malfunctionInfo) {
        int rows = malfunctionService.alterMalfunctionInfo(malfunctionInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteMalfunction")
    @Operation(summary = "删除")
    public JsonData deleteMalfunction(@RequestBody Map<String, String> malfunctionInfo) {
        int rows = malfunctionService.deleteMalfunction(malfunctionInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

}
