package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.model.entity.Field;
import edu.ecnu.tobacco_display.service.TobaccoFieldService;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/field")
@Api(tags = "烟田管理接口")
public class TobaccoFieldController {
    @Autowired
    private TobaccoFieldService tobaccoFieldService;

    @PostMapping("showFields")
    @ApiOperation(value = "查询")
    public JsonData findFieldByOptions(@RequestBody Map<String, String> fieldInfo) {
        List<Field> fields = tobaccoFieldService.findFieldByOptions(fieldInfo);
        return fields != null ? JsonData.buildSuccess(fields) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("addField")
    @ApiOperation(value = "添加")
    public JsonData addField(@RequestBody Map<String, String> fieldInfo) {
        int rows = tobaccoFieldService.saveFieldInfo(fieldInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("alterField")
    @ApiOperation(value = "修改")
    public JsonData alterField(@RequestBody Map<String, String> fieldInfo) {
        int rows = tobaccoFieldService.alterFieldInfo(fieldInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteField")
    @ApiOperation(value = "删除")
    public JsonData deleteField(@RequestBody Map<String, String> fieldInfo) {
        int rows = tobaccoFieldService.deleteField(fieldInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }
}
