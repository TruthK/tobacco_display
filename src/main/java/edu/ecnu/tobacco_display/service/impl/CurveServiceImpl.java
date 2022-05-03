package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.CurveMapper;
import edu.ecnu.tobacco_display.mapper.UserMapper;
import edu.ecnu.tobacco_display.model.entity.Curve;
import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.service.CurveService;
import edu.ecnu.tobacco_display.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CurveServiceImpl implements CurveService {
    @Autowired
    private CurveMapper curveMapper;

    @Override
    public List<Curve> findCurveByOptions(Map<String, String> curveInfo) {
        Curve curve = parseToCurve(curveInfo);
        return curveMapper.findCurveByOptions(curve);
    }

    @Override
    public int saveCurveInfo(Map<String, String> curveInfo) {
        Curve curve = parseToCurve(curveInfo);
        if (curve.getKind() != null && curve.getCurve() != null
                && curve.getDryOrWet() != null) {

            return curveMapper.saveCurveInfo(curve);
        }
        return -1;

    }

    @Override
    public int alterCurveInfo(Map<String, String> curveInfo) {
        Curve curve = parseToCurve(curveInfo);
        return curveMapper.alterCurveInfo(curve);

    }

    @Override
    public int deleteCurve(Map<String, String> curveInfo) {
        Curve curve = parseToCurve(curveInfo);
        return curveMapper.deleteCurve(curve);
    }

    private Curve parseToCurve(Map<String, String> curveInfo) {
        curveInfo = CommonUtils.formatHumpName(curveInfo);
        Curve curve = JSONObject.parseObject(
                JSONObject.toJSONString(curveInfo), Curve.class);
        return curve;

    }

}
