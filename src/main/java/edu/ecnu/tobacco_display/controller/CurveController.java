package edu.ecnu.tobacco_display.controller;


import edu.ecnu.tobacco_display.model.entity.Curve;
import edu.ecnu.tobacco_display.service.CurveService;
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
@RequestMapping("/curve")
@Api(tags = "状态管理接口")
public class CurveController {
    @Autowired
    private CurveService curveService;


    @PostMapping("addCurve")
    @Operation(summary = "添加")
    public JsonData addCurve(@RequestBody Map<String, String> curveInfo) {
        int rows = curveService.saveCurveInfo(curveInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("showCurves")
    @Operation(summary = "查找")
    public JsonData showCurves(@RequestBody Map<String, String> curveInfo) {
        List<Curve> curves = curveService.findCurveByOptions(curveInfo);
        return curves != null ? JsonData.buildSuccess(curves) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterCurve")
    @Operation(summary = "修改")
    public JsonData alterCurve(@RequestBody Map<String, String> curveInfo) {
        int rows = curveService.alterCurveInfo(curveInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteCurve")
    @Operation(summary = "删除")
    public JsonData deleteCurve(@RequestBody Map<String, String> curveInfo) {
        int rows = curveService.deleteCurve(curveInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }



}
