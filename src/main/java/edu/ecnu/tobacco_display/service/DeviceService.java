package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    /**
     * 返回多个设备信息
     * @param deviceInfo
     * @return
     */
    List<Device> findDeviceByOptions(Map<String, String> deviceInfo);

    int alterDeviceInfo(Map<String, String> deviceInfo);

    int saveDeviceInfo(Map<String, String> deviceInfo);

    int deleteDevice(Map<String, String> deviceInfo);

}
