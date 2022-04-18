package edu.ecnu.tobacco_display.service.impl;

import edu.ecnu.tobacco_display.mapper.StationMapper;
import edu.ecnu.tobacco_display.model.entity.Station;
import edu.ecnu.tobacco_display.service.StationService;
import edu.ecnu.tobacco_display.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author TruthK
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper stationMapper;

    @Override
    public List<Station> findStationByOptions(Map<String, String> stationInfo) {
        Station station = parseToStation(stationInfo);
        List<Station> stationList = stationMapper.findStationByOptions(station);
        return stationList;
    }

    @Override
    public int alterStationInfo(Map<String, String> stationInfo) {
        Station station = parseToStation(stationInfo);
        if (station != null) {
            return stationMapper.alterStationInfo(station);
        } else {
            return -1;
        }

    }

    @Override
    public int saveStationInfo(Map<String, String> stationInfo) {
        Station station = parseToStation(stationInfo);
        if (station != null) {
            if (station.getStationId() != null && station.getStationName() != null) {
                return stationMapper.saveStationInfo(station);
            }
        }
        return -1;
    }

    @Override
    public int deleteStation(Map<String, String> stationInfo) {
        Station station = parseToStation(stationInfo);
        return stationMapper.deleteStation(station);
    }


    private Station parseToStation(Map<String, String> stationInfo) {

        Station station = new Station();

        if (stationInfo.containsKey("station_id")) {
            station.setStationId(stationInfo.get("station_id"));
        }

        if (stationInfo.containsKey("station_name")) {
            station.setStationName(stationInfo.get("station_name"));
        }

        if (stationInfo.containsKey("address")) {
            station.setAddress(stationInfo.get("address"));
        }

        if (stationInfo.containsKey("location")) {
            station.setLocation(stationInfo.get("location"));
        }

        if (stationInfo.containsKey("parent_location")) {
            station.setParentLocation(stationInfo.get("parent_location"));
        }

        return station;
    }


}
