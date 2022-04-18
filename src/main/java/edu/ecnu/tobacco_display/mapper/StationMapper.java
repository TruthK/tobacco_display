package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.Station;

import java.util.List;

/**
 * @author TruthK
 */
public interface StationMapper {
    /**
     * 返回多个烟站信息
     *
     * @param station
     * @return
     */
    List<Station> findStationByOptions(Station station);

    int alterStationInfo(Station station);

    int saveStationInfo(Station station);

    int deleteStation(Station station);
}
