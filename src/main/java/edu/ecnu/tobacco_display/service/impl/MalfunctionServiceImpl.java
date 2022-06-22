package edu.ecnu.tobacco_display.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.ecnu.tobacco_display.mapper.MalfunctionMapper;
import edu.ecnu.tobacco_display.model.entity.Malfunction;
import edu.ecnu.tobacco_display.service.MalfunctionService;
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
public class MalfunctionServiceImpl implements MalfunctionService {
    @Autowired
    private MalfunctionMapper malfunctionMapper;

    @Override
    public List<Malfunction> findMalfunctionByOptions(Map<String, String> malfunctionInfo) {
        Malfunction malfunction = parseToMalfunction(malfunctionInfo);
        List<Malfunction> malfunctionList = malfunctionMapper.findMalfunctionByOptions(malfunction);
        return malfunctionList;
    }

    @Override
    public int alterMalfunctionInfo(Map<String, String> malfunctionInfo) {
        Malfunction malfunction = parseToMalfunction(malfunctionInfo);
        if (malfunction != null) {
            return malfunctionMapper.alterMalfunctionInfo(malfunction);
        } else {
            return -1;
        }

    }

    @Override
    public int saveMalfunctionInfo(Map<String, String> malfunctionInfo) {
        Malfunction malfunction = parseToMalfunction(malfunctionInfo);
        if (malfunction != null) {
            if (malfunction.getDeviceId() != null) {
                return malfunctionMapper.saveMalfunctionInfo(malfunction);
            }
        }
        return -1;
    }

    @Override
    public int deleteMalfunction(Map<String, String> malfunctionInfo) {
        Malfunction malfunction = parseToMalfunction(malfunctionInfo);
        return malfunctionMapper.deleteMalfunction(malfunction);
    }


    private Malfunction parseToMalfunction(Map<String, String> malfunctionInfo) {
        malfunctionInfo=CommonUtils.formatHumpName(malfunctionInfo);
        Malfunction malfunction = JSONObject.parseObject(JSONObject.toJSONString(malfunctionInfo), Malfunction.class);
        if(malfunction.getCreateTime()==null){
            malfunction.setCreateTime(new Date());
        }
        return malfunction;

    }


}
