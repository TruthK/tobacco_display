package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.Station;
import edu.ecnu.tobacco_display.model.entity.Station;

import java.util.List;
import java.util.Map;

public interface StationService {
    /**
     * 返回多个设备信息
     * @param stationInfo
     * @return
     */
    List<Station> findStationByOptions(Map<String, String> stationInfo);

    int alterStationInfo(Map<String, String> stationInfo);

    int saveStationInfo(Map<String, String> stationInfo);

    int deleteStation(Map<String, String> stationInfo);

}
