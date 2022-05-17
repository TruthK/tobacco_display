package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.DeviceGroup;

import java.util.List;
import java.util.Map;

public interface DeviceGroupService {
    List<DeviceGroup> findDeviceGroupByOptions(Map<String, String> Info);

    int saveDeviceGroupInfo(Map<String, String> Info);

    int alterDeviceGroupInfo(Map<String, String> Info);

    int deleteDeviceGroup(Map<String, String> Info);
}
