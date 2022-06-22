package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.Malfunction;

import java.util.List;

/**
 * @author TruthK
 */
public interface MalfunctionMapper {
    /**
     * 返回多个故障信息
     *
     * @param malfunction
     * @return
     */
    List<Malfunction> findMalfunctionByOptions(Malfunction malfunction);

    int alterMalfunctionInfo(Malfunction malfunction);

    int saveMalfunctionInfo(Malfunction malfunction);

    int deleteMalfunction(Malfunction malfunction);
}
