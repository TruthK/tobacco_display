package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.BakingFigure;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.model.entity.Device;

import java.util.List;
import java.util.Map;

/**
 * 烤房异常警报
 *
 * @author TruthK
 */
public interface BakingService {
    /**
     * 返回多个设备信息
     *
     * @param queryOptions
     * @return
     */
    List<BakingWarning> findWarningsByOptions(Map<String, String> queryOptions);

    List<BakingFigure> findBakingFiguresByOptions(Map<String, String> queryOptions);

    List<BakingRecord> findBakingRecordsByOptions(Map<String, String> queryOptions);

    int alterBakingRecord(Map<String, String> queryOptions);

    int saveBakingRecord(Map<String, String> queryOptions);

    int deleteBakingRecord(Map<String, String> queryOptions);


}
