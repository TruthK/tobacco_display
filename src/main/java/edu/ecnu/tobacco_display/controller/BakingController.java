package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.model.entity.BakingFigure;
import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.service.BakingService;
import edu.ecnu.tobacco_display.utils.JsonData;
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
    public JsonData findWarningsByOptions(@RequestBody Map<String, String> queryOptions) {
        List<BakingWarning> warningList = bakingService.findWarningsByOptions(queryOptions);
        return warningList != null ? JsonData.buildSuccess(warningList) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("findBakingFiguresByOptions")
    public JsonData findBakingFiguresByOptions(@RequestBody Map<String, String> bakingFigureInfo) {
        List<BakingFigure> figureList = bakingService.findBakingFiguresByOptions(bakingFigureInfo);
        return figureList != null ? JsonData.buildSuccess(figureList) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("findBakingRecordsByOptions")
    public JsonData findBakingRecordsByOptions(@RequestBody Map<String, String> bakingRecordInfo) {
        List<BakingRecord> bakingRecords = bakingService.findBakingRecordsByOptions(bakingRecordInfo);
        return bakingRecords != null ? JsonData.buildSuccess(bakingRecords) : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("addBakingRecord")
    public JsonData addBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.saveBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }


    @PostMapping("alterBakingRecord")
    public JsonData alterBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.alterBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }

    @PostMapping("deleteBakingRecord")
    public JsonData deleteBakingRecord(@RequestBody Map<String, String> bakingRecordInfo) {
        int rows = bakingService.deleteBakingRecord(bakingRecordInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("请确认输入无误");
    }


}
