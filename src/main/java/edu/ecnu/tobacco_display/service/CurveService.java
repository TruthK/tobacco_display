package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.Curve;
import edu.ecnu.tobacco_display.model.entity.Curve;

import java.util.List;
import java.util.Map;

public interface CurveService {
    List<Curve> findCurveByOptions(Map<String, String> curveInfo);

    int saveCurveInfo(Map<String, String> curveInfo);

    int alterCurveInfo(Map<String, String> curveInfo);

    int deleteCurve(Map<String, String> curveInfo);
}
