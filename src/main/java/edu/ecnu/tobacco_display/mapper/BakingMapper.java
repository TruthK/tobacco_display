package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.BakingWarning;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;

import java.util.List;

/**
 * @author TruthK
 */
public interface BakingMapper {
    /**
     * 返回多个信息
     *
     * @param bakingWarning
     * @return
     */
    List<BakingWarning> findWarningsByOptions(BakingWarning bakingWarning);

    List<BakingRecord> findBakingRecordsByOptions(BakingRecord bakingRecord);

    int alterBakingRecord(BakingRecord bakingRecord);

    int saveBakingRecord(BakingRecord bakingRecord);

    int deleteBakingRecord(BakingRecord bakingRecord);

}
