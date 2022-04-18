package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author TruthK
 */
public interface DeviceMapper {
    /**
     * 返回多个设备信息
     *
     * @param device
     * @return
     */
    List<Device> findDeviceByOptions(Device device);

    int alterDeviceInfo(Device device);

    int saveDeviceInfo(Device device);

    int deleteDevice(Device device);
}
