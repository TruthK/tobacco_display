package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.service.DetailRoastedTobaccoService;
import edu.ecnu.tobacco_display.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author TruthK
 */
@RestController
@RequestMapping("/api/query")
public class DetailRoastedTobaccoController {


    @Autowired
    private DetailRoastedTobaccoService detailRoastedTobaccoService;


    /**
     * 查询烤烟数据
     *
     * @param
     * @return
     */
    @PostMapping("detailRoastedTobacco")
    public JsonData findDetailByOptions(@RequestBody Map<String, String> queryOptions) {


        List<DetailRoastedTobacco> detailRoastedTobaccoList = detailRoastedTobaccoService.findDetailByOptions(queryOptions);

        return JsonData.buildSuccess(detailRoastedTobaccoList);

    }


}
