package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.DeviceMapper;
import edu.ecnu.tobacco_display.mapper.UserMapper;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.Device;
import edu.ecnu.tobacco_display.model.entity.User;
import edu.ecnu.tobacco_display.service.DeviceService;
import edu.ecnu.tobacco_display.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author TruthK
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public List<Device> findDeviceByOptions(Map<String, String> deviceInfo) {
        Device device = parseToDevice(deviceInfo);
        List<Device> deviceList = deviceMapper.findDeviceByOptions(device);
        return deviceList;
    }

    @Override
    public int alterDeviceInfo(Map<String, String> deviceInfo) {
        Device device = parseToDevice(deviceInfo);
        if (device != null) {
            return deviceMapper.alterDeviceInfo(device);
        } else {
            return -1;
        }

    }

    @Override
    public int saveDeviceInfo(Map<String, String> deviceInfo) {
        Device device = parseToDevice(deviceInfo);
        if (device != null) {
            if (device.getDeviceId() != null && device.getHead() != null && device.getHeadPhone() != null) {
                return deviceMapper.saveDeviceInfo(device);
            }
        }
        return -1;
    }

    @Override
    public int deleteDevice(Map<String, String> deviceInfo) {
        Device device = parseToDevice(deviceInfo);
        return deviceMapper.deleteDevice(device);
    }


    private Device parseToDevice(Map<String, String> deviceInfo) {
        deviceInfo=CommonUtils.formatHumpName(deviceInfo);
        Device device = JSONObject.parseObject(JSONObject.toJSONString(deviceInfo), Device.class);
        return device;
//        Device device = new Device();
//
//        if (deviceInfo.containsKey("device_id")) {
//            device.setDeviceId(deviceInfo.get("device_id"));
//        }
//
//        if (deviceInfo.containsKey("device_name")) {
//            device.setDeviceName(deviceInfo.get("device_name"));
//        }
//
//        if (deviceInfo.containsKey("head_phone")) {
//            device.setHeadPhone(deviceInfo.get("head_phone"));
//        }
//        if (deviceInfo.containsKey("head")) {
//            device.setHead(deviceInfo.get("head"));
//        }
//        if (deviceInfo.containsKey("kind")) {
//            device.setKind(Integer.valueOf(deviceInfo.get("kind")));
//        }
//
//        device.setCreateTime(new Date());
//        if (deviceInfo.containsKey("address")) {
//            device.setAddress(deviceInfo.get("address"));
//        }
//
//        if (deviceInfo.containsKey("location")) {
//            device.setLocation(deviceInfo.get("location"));
//        }
//
//        if (deviceInfo.containsKey("parent_location")) {
//            device.setParentLocation(deviceInfo.get("parent_location"));
//        }
//        if (deviceInfo.containsKey("station_id")) {
//            device.setStationId(deviceInfo.get("station_id"));
//        }
//
//        return device;
    }


}
