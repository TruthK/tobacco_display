package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.DeviceGroup;

import java.util.List;

/**
 * @author TruthK
 */
public interface DeviceGroupMapper {
    List<DeviceGroup> findDeviceGroupByOptions(DeviceGroup group);

    int alterDeviceGroupInfo(DeviceGroup group);

    int saveDeviceGroupInfo(DeviceGroup group);

    int deleteDeviceGroup(DeviceGroup group);
}
