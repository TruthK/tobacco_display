package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.service.DetailRoastedTobaccoService;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author TruthK
 */
@RestController
@RequestMapping("/query")
@Api(tags = "DetailRoastedTobacco相关接口")
public class DetailRoastedTobaccoController {
    @Autowired
    private DetailRoastedTobaccoService detailRoastedTobaccoService;

    /**
     * 查询烤烟数据
     * @param
     * @return
     */
    @PostMapping("detailRoastedTobacco")
    @Operation(summary = "查询烤烟数据")
    public JsonData findDetailByOptions(@RequestBody Map<String, String> queryOptions) {
        List<DetailRoastedTobacco> detailRoastedTobaccoList = detailRoastedTobaccoService.findDetailByOptions(queryOptions);
        return detailRoastedTobaccoList != null ? JsonData.buildSuccess(detailRoastedTobaccoList) : JsonData.buildError("请确认输入无误");

    }

}
