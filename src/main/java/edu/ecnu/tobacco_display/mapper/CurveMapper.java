package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.Curve;

import java.util.List;

/**
 * @author TruthK
 */
public interface CurveMapper {
    List<Curve> findCurveByOptions(Curve curve);

    int alterCurveInfo(Curve curve);

    int saveCurveInfo(Curve curve);

    int deleteCurve(Curve curve);
}
