package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.Malfunction;

import java.util.List;
import java.util.Map;

public interface MalfunctionService {
    /**
     * 返回多个设备信息
     * @param malfunction
     * @return
     */
    List<Malfunction> findMalfunctionByOptions(Map<String, String> malfunction);

    int alterMalfunctionInfo(Map<String, String> malfunction);

    int saveMalfunctionInfo(Map<String, String> malfunction);

    int deleteMalfunction(Map<String, String> malfunction);

}
