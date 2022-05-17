package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.DeviceGroupMapper;
import edu.ecnu.tobacco_display.model.entity.DeviceGroup;
import edu.ecnu.tobacco_display.service.DeviceGroupService;
import edu.ecnu.tobacco_display.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceGroupServiceImpl implements DeviceGroupService {
    @Autowired
    private DeviceGroupMapper deviceGroupMapper;

    @Override
    public List<DeviceGroup> findDeviceGroupByOptions(Map<String, String> deviceGroupInfo) {
        DeviceGroup deviceGroup = parseToDeviceGroup(deviceGroupInfo);
        return deviceGroupMapper.findDeviceGroupByOptions(deviceGroup);
    }

    @Override
    public int saveDeviceGroupInfo(Map<String, String> deviceGroupInfo) {
        DeviceGroup deviceGroup = parseToDeviceGroup(deviceGroupInfo);
        return deviceGroupMapper.saveDeviceGroupInfo(deviceGroup);

    }

    @Override
    public int alterDeviceGroupInfo(Map<String, String> deviceGroupInfo) {
        DeviceGroup deviceGroup = parseToDeviceGroup(deviceGroupInfo);
        return deviceGroupMapper.alterDeviceGroupInfo(deviceGroup);

    }

    @Override
    public int deleteDeviceGroup(Map<String, String> deviceGroupInfo) {
        DeviceGroup deviceGroup = parseToDeviceGroup(deviceGroupInfo);
        return deviceGroupMapper.deleteDeviceGroup(deviceGroup);
    }

    private DeviceGroup parseToDeviceGroup(Map<String, String> deviceGroupInfo) {
        deviceGroupInfo = CommonUtils.formatHumpName(deviceGroupInfo);
        DeviceGroup deviceGroup = JSONObject.parseObject(
                JSONObject.toJSONString(deviceGroupInfo), DeviceGroup.class);
        return deviceGroup;

    }

}
