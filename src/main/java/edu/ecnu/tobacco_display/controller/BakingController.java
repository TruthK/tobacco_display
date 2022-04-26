package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.model.entity.BakingFigure;
import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.service.BakingService;
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
 * @author TruthK
 */
@RestController
@RequestMapping("/bake")
@Api(tags = "烘烤相关接口")
public class BakingController {
    @Autowired
    private BakingService bakingService;


    /**
     * 查询烤房警报数据.
     *
     * @param
     * @return
     */
    @PostMapping("alertData")
    @Operation(summary = "查询烤房警报数据")
    public JsonData findWarningsByOptions(@RequestBody Map<String, String> queryOptions) {
        List<BakingWarning> warningList = bakingService.findWarningsByOptions(queryOptions);
        return warningList != null ? JsonData.buildSuccess(warningList) : JsonData.buildError("请确认输入无误");
    }


    @PostMapping("findBakingFiguresByOptions")
    @Operation(summary = "findBakingFiguresByOptions")
    public JsonData findBakingFiguresByOptions(@RequestBody Map<String, String> bakingFigureInfo) {
        List<BakingFigure> figureList = bakingService.findBakingFiguresByOptions(bakingFigureInfo);
        return figureList != null ? JsonData.buildSuccess(figureList) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("findBakingRecordsByOptions")
    @Operation(summary = "findBakingRecordsByOptions")
    public JsonData findBakingRecordsByOptions(@RequestBody Map<String, String> bakingRecordInfo) {
        List<BakingRecord> bakingRecords = bakingService.findBakingRecordsByOptions(bakingRecordInfo);
        return bakingRecords != null ? JsonData.buildSuccess(bakingRecords) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("addBakingRecord")
    @Operation(summary = "添加烘烤记录")
    public JsonData addBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.saveBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }


    @PostMapping("alterBakingRecord")
    @Operation(summary = "修改烘烤记录")
    public JsonData alterBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.alterBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteBakingRecord")
    @Operation(summary = "删除烘烤记录")
    public JsonData deleteBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.deleteBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }



//    /**
//     * 烘烤技师数据
//     * @param
//     * @return
//     */
//    public JsonData findBakingUser() {
//
//    }

//    /**
//     * 查询烤房监控相关数据
//     * @param
//     * @return
//     */
//    public JsonData findBakingMonitor() {
//
//    }

//    // 曲线设置预警
//    public JsonData alertFigureByCondition(String threshold){
//        // todo
//        // 设置阈值
//        // 监控
//        return JsonData.buildSuccess();
//    }
//    // 烘烤过程预警
//    public JsonData alertTobaccoByCondition(String threshold){
//        // todo
//        // 设置阈值
//        // 监控
//        return JsonData.buildSuccess();
//    }
}
