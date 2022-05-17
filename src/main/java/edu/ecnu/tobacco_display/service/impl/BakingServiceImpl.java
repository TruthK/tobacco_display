package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.BakingMapper;
import edu.ecnu.tobacco_display.model.entity.BakingFigure;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.service.BakingService;
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
public class BakingServiceImpl implements BakingService {

    @Autowired
    private BakingMapper bakingMapper;

    @Override
    public List<BakingWarning> findWarningsByOptions(Map<String, String> queryOptions) {
        BakingWarning warning = parseToWarning(queryOptions);
        List<BakingWarning> warningList = bakingMapper.findWarningsByOptions(warning);
        return warningList;
    }

    @Override
    public List<BakingFigure> findBakingFiguresByOptions(Map<String, String> queryOptions) {
        BakingFigure bakingFigure = parseToBakingFigure(queryOptions);
        List<BakingFigure> figuresList = bakingMapper.findBakingFiguresByOptions(bakingFigure);
        return figuresList;
    }

    @Override
    public List<BakingRecord> findBakingRecordsByOptions(Map<String, String> queryOptions) {
        BakingRecord bakingRecord = parseToBakingRecord(queryOptions);
        List<BakingRecord> bakingRecordsList = bakingMapper.findBakingRecordsByOptions(bakingRecord);
        return bakingRecordsList;
    }

    @Override
    public List<BakingRecord> CountBakingRecordsNumbers(Map<String, String> queryOptions) {
        BakingRecord bakingRecord = parseToBakingRecord(queryOptions);
        List<BakingRecord> bakingRecordList = bakingMapper.CountBakingRecordsNumbers(bakingRecord);
        return bakingRecordList;
    }

    @Override
    public int alterBakingRecord(Map<String, String> queryOptions) {
        BakingRecord bakingRecord = parseToBakingRecord(queryOptions);
        if (bakingRecord != null) {
            return bakingMapper.alterBakingRecord(bakingRecord);
        } else {
            return -1;
        }
    }

    @Override
    public int saveBakingRecord(Map<String, String> queryOptions) {
        BakingRecord bakingRecord = parseToBakingRecord(queryOptions);
        if (bakingRecord != null) {
            if (bakingRecord.getDeviceId() != null &&
                    bakingRecord.getStartTime() != null) {
                return bakingMapper.saveBakingRecord(bakingRecord);
            }
        }
        return -1;
    }

    @Override
    public int deleteBakingRecord(Map<String, String> queryOptions) {
        BakingRecord bakingRecord = parseToBakingRecord(queryOptions);
        return bakingMapper.deleteBakingRecord(bakingRecord);
    }

    /**
     * 解析 QueryOption 对象
     *
     * @param queryOptionMap
     * @return
     */
    private BakingWarning parseToWarning(Map<String, String> queryOptionMap) {
        queryOptionMap=CommonUtils.formatHumpName(queryOptionMap);
        BakingWarning warning = JSONObject.parseObject(JSONObject.toJSONString(queryOptionMap), BakingWarning.class);

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        BakingWarning warning = new BakingWarning();
//        try {
//            if (queryOptionMap.containsKey("start_time")) {
//                warning.setStartTime(simpleDateFormat.parse(
//                        queryOptionMap.get("start_time")));
//            }
//            if (queryOptionMap.containsKey("end_time")) {
//                warning.setEndTime(simpleDateFormat.parse(
//                        queryOptionMap.get("end_time")));
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (queryOptionMap.containsKey("device_id")) {
//            warning.setDeviceId(queryOptionMap.get("device_id"));
//
//        }
//
//        if (queryOptionMap.containsKey("station_id")) {
//            warning.setStationId(queryOptionMap.get("station_id"));
//
//        }
//        if (queryOptionMap.containsKey("location")) {
//            warning.setLocation(queryOptionMap.get("location"));
//
//        }
//        if (queryOptionMap.containsKey("parent_location")) {
//            warning.setParentLocation(queryOptionMap.get("parent_location"));
//        }

        return warning;
    }

    /**
     * 解析 QueryOption 对象
     *
     * @param queryOptionMap
     * @return
     */
    private BakingRecord parseToBakingRecord(Map<String, String> queryOptionMap) {
        queryOptionMap=CommonUtils.formatHumpName(queryOptionMap);
        BakingRecord bakingRecord = JSONObject.parseObject(JSONObject.toJSONString(queryOptionMap), BakingRecord.class);
        //        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        BakingRecord bakingRecord = new BakingRecord();
//        try {
//            if (queryOptionMap.containsKey("find_start_time")) {
//                bakingRecord.setFindStartTime(simpleDateFormat.parse(
//                        queryOptionMap.get("find_start_time")));
//            }
//            if (queryOptionMap.containsKey("find_end_time")) {
//                bakingRecord.setFindEndTime(simpleDateFormat.parse(
//                        queryOptionMap.get("find_end_time")));
//            }
//
//            if (queryOptionMap.containsKey("start_time")) {
//                bakingRecord.setStartTime(simpleDateFormat.parse(
//                        queryOptionMap.get("start_time")));
//            }
//            if (queryOptionMap.containsKey("end_time")) {
//                bakingRecord.setEndTime(simpleDateFormat.parse(
//                        queryOptionMap.get("end_time")));
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        if (queryOptionMap.containsKey("id")) {
//            bakingRecord.setId(Integer.valueOf(queryOptionMap.get("id")));
//        }
//        if (queryOptionMap.containsKey("device_id")) {
//            bakingRecord.setDeviceId(queryOptionMap.get("device_id"));
//        }
//
//        if (queryOptionMap.containsKey("station_id")) {
//            bakingRecord.setStationId(queryOptionMap.get("station_id"));
//
//        }
//        if (queryOptionMap.containsKey("location")) {
//            bakingRecord.setLocation(queryOptionMap.get("location"));
//
//        }
//        if (queryOptionMap.containsKey("parent_location")) {
//            bakingRecord.setParentLocation(queryOptionMap.get("parent_location"));
//        }
//
//        if (queryOptionMap.containsKey("farmer_id")) {
//            bakingRecord.setFarmerId(queryOptionMap.get("farmer_id"));
//
//        }
//        if (queryOptionMap.containsKey("technician_id")) {
//            bakingRecord.setTechnicianId(queryOptionMap.get("technician_id"));
//        }
//
//        if (queryOptionMap.containsKey("score_upper_bound")) {
//            bakingRecord.setScoreUpperBound(
//                    Double.valueOf(queryOptionMap.get("score_upper_bound")));
//        }
//
//        if (queryOptionMap.containsKey("score_lower_bound")) {
//            bakingRecord.setScoreLowerBound(
//                    Double.valueOf(queryOptionMap.get("score_lower_bound")));
//        }
//
//        if (queryOptionMap.containsKey("score")) {
//            bakingRecord.setScore(
//                    Double.valueOf(queryOptionMap.get("score")));
//        }
//        if (queryOptionMap.containsKey("baking_weight_before")) {
//            bakingRecord.setBakingWeightBefore(
//                    Double.valueOf(queryOptionMap.get("baking_weight_before")));
//        }
//
//        if (queryOptionMap.containsKey("baking_weight_after")) {
//            bakingRecord.setBakingWeightAfter(
//                    Double.valueOf(queryOptionMap.get("baking_weight_after")));
//        }
//        if (queryOptionMap.containsKey("tobacco_info")) {
//            bakingRecord.setTobaccoInfo("tobacco_info");
//        }

        return bakingRecord;
    }

    private BakingFigure parseToBakingFigure(Map<String, String> queryOptionMap) {
        queryOptionMap=CommonUtils.formatHumpName(queryOptionMap);
        BakingFigure bakingFigure = JSONObject.parseObject(JSONObject.toJSONString(queryOptionMap), BakingFigure.class);

//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        BakingFigure bakingFigure = new BakingFigure();
//        try {
//            if (queryOptionMap.containsKey("find_start_time")) {
//                bakingFigure.setFindStartTime(simpleDateFormat.parse(
//                        queryOptionMap.get("find_start_time")));
//            }
//            if (queryOptionMap.containsKey("find_end_time")) {
//                bakingFigure.setFindEndTime(simpleDateFormat.parse(
//                        queryOptionMap.get("find_end_time")));
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        if (queryOptionMap.containsKey("station_id")) {
//            bakingFigure.setStationId(queryOptionMap.get("station_id"));
//
//        }
//        if (queryOptionMap.containsKey("location")) {
//            bakingFigure.setLocation(queryOptionMap.get("location"));
//
//        }
//        if (queryOptionMap.containsKey("parent_location")) {
//            bakingFigure.setParentLocation(queryOptionMap.get("parent_location"));
//        }
//
//
//        if (queryOptionMap.containsKey("score_upper_bound")) {
//            bakingFigure.setScoreUpperBound(
//                    Double.valueOf(queryOptionMap.get("score_upper_bound")));
//        }
//
//        if (queryOptionMap.containsKey("score_lower_bound")) {
//            bakingFigure.setScoreLowerBound(
//                    Double.valueOf(queryOptionMap.get("score_lower_bound")));
//        }
//
//        if (queryOptionMap.containsKey("tobacco_info")) {
//            bakingFigure.setTobaccoInfo("tobacco_info");
//        }

        return bakingFigure;
    }


}
