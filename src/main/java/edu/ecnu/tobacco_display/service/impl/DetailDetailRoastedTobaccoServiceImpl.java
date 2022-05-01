package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.DetailRoastedTobaccoMapper;
import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.model.request.QueryOptionsRequest;
import edu.ecnu.tobacco_display.service.DetailRoastedTobaccoService;
import edu.ecnu.tobacco_display.utils.BaseCache;
import edu.ecnu.tobacco_display.utils.CommonUtils;
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
        DetailRoastedTobacco record = parseToQueryOption(queryOptionMap);
        // 需要使用mybaits关联复杂查询
        List<DetailRoastedTobacco> detailRoastedTobaccoList = detailRoastedTobaccoMapper.findDetailByOptions(record);
        return detailRoastedTobaccoList;
    }

    /**
     * 解析 QueryOption 对象
     *
     * @param queryOptionMap
     * @return
     */
    private DetailRoastedTobacco parseToQueryOption(Map<String, String> queryOptionMap) {
        queryOptionMap = CommonUtils.formatHumpName(queryOptionMap);
        DetailRoastedTobacco record = JSONObject.parseObject(
                JSONObject.toJSONString(queryOptionMap), DetailRoastedTobacco.class);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        QueryOptionsRequest option = new QueryOptionsRequest();
//        try {
//            option.setStartTime(queryOptionMap.get("start_time") != null ? simpleDateFormat.parse(queryOptionMap.get("start_time")) : null);
//            option.setEndTime(queryOptionMap.get("end_time") != null ? simpleDateFormat.parse(queryOptionMap.get("end_time")) : null);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        option.setDryBallTemp(queryOptionMap.get("dry_ball_Temp") != null ? Double.valueOf(queryOptionMap.get("dry_ball_Temp")) : -999);
//        option.setWetBallTemp(queryOptionMap.get("wet_ball_Temp") != null ? Double.valueOf(queryOptionMap.get("wet_ball_Temp")) : -999);
//        option.setDryBallTarget(queryOptionMap.get("dry_ball_target") != null ? Double.valueOf(queryOptionMap.get("dry_ball_target")) : -999);
//        option.setWetBallTarget(queryOptionMap.get("wet_ball_target") != null ? Double.valueOf(queryOptionMap.get("wet_ball_target")) : -999);
//
//        option.setLocation(queryOptionMap.get("location") != null ? queryOptionMap.get("location") : null);
//        option.setDeviceId(queryOptionMap.get("device_id") != null ? queryOptionMap.get("device_id") : null);
        return record;

    }
}
