package edu.ecnu.tobacco_display.service.impl;

import edu.ecnu.tobacco_display.mapper.DetailRoastedTobaccoMapper;
import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.model.request.QueryOptionsRequest;
import edu.ecnu.tobacco_display.service.DetailRoastedTobaccoService;
import edu.ecnu.tobacco_display.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * @author TruthK
 */
@Service
public class DetailDetailRoastedTobaccoServiceImpl implements DetailRoastedTobaccoService {

    @Autowired
    private DetailRoastedTobaccoMapper detailRoastedTobaccoMapper;

    @Override
    public List<DetailRoastedTobacco> findDetailByOptions(Map<String, String> queryOptionMap) {
        QueryOptionsRequest queryOptionsRequest = parseToQueryOption(queryOptionMap);
        System.out.println(queryOptionsRequest);
        // 需要使用mybaits关联复杂查询
        List<DetailRoastedTobacco> detailRoastedTobaccoList = detailRoastedTobaccoMapper.findDetailByOptions(queryOptionsRequest);

        return detailRoastedTobaccoList;
    }

    /**
     * 解析 QueryOption 对象
     *
     * @param queryOptionMap
     * @return
     */
    private QueryOptionsRequest parseToQueryOption(Map<String, String> queryOptionMap) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QueryOptionsRequest option = new QueryOptionsRequest();
        try {
            option.setStartTime(queryOptionMap.get("start_time") != null ? simpleDateFormat.parse(queryOptionMap.get("start_time")) : null);
            option.setEndTime(queryOptionMap.get("end_time") != null ? simpleDateFormat.parse(queryOptionMap.get("end_time")) : null);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        option.setDryBallTemp(queryOptionMap.get("dry_ball_Temp") != null ? Double.valueOf(queryOptionMap.get("dry_ball_Temp")) : -999);
        option.setWetBallTemp(queryOptionMap.get("wet_ball_Temp") != null ? Double.valueOf(queryOptionMap.get("wet_ball_Temp")) : -999);
        option.setDryBallTarget(queryOptionMap.get("dry_ball_target") != null ? Double.valueOf(queryOptionMap.get("dry_ball_target")) : -999);
        option.setWetBallTarget(queryOptionMap.get("wet_ball_target") != null ? Double.valueOf(queryOptionMap.get("wet_ball_target")) :-999);

        option.setLocation(queryOptionMap.get("location") != null ? queryOptionMap.get("location") : null);
        option.setEquipmentNo(queryOptionMap.get("equipment_No") != null ? queryOptionMap.get("location") : null);
        return option;

    }
}
