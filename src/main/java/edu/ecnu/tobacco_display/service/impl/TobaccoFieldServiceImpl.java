package edu.ecnu.tobacco_display.service.impl;

import edu.ecnu.tobacco_display.mapper.FieldMapper;
import edu.ecnu.tobacco_display.mapper.UserMapper;
import edu.ecnu.tobacco_display.model.entity.Device;
import edu.ecnu.tobacco_display.model.entity.Field;
import edu.ecnu.tobacco_display.service.TobaccoFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TobaccoFieldServiceImpl implements TobaccoFieldService {
    @Autowired
    private FieldMapper fieldMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Field> findFieldByOptions(Map<String, String> fieldInfo) {
        Field field = parseToField(fieldInfo);
        return fieldMapper.findFieldByOptions(field);
    }

    @Override
    public int saveFieldInfo(Map<String, String> fieldInfo) {
        Field field = parseToField(fieldInfo);
        if (field.getFieldId() != null && field.getLocation() != null && field.getOwner() != null) {
            if(userMapper.findByUserIdOrPhone(field.getOwner())!=null) {
                return fieldMapper.saveFieldInfo(field);
            }else{
                return -1;
            }
        }
        return -1;
    }

    @Override
    public int alterFieldInfo(Map<String, String> fieldInfo) {
        try {
            Field field = parseToField(fieldInfo);
            return fieldMapper.alterFieldInfo(field);
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public int deleteField(Map<String, String> fieldInfo) {
        Field field = parseToField(fieldInfo);
        return fieldMapper.deleteField(field);
    }

    private Field parseToField(Map<String, String> fieldInfo) {
        Field field = new Field();
        if (fieldInfo.containsKey("field_id")) field.setFieldId(fieldInfo.get("field_id"));
        if (fieldInfo.containsKey("fieldId")) field.setFieldId(fieldInfo.get("fieldId"));
        if (fieldInfo.containsKey("location")) field.setLocation(fieldInfo.get("location"));
        if (fieldInfo.containsKey("info")) field.setInfo(fieldInfo.get("info"));
        if (fieldInfo.containsKey("owner")) field.setOwner(fieldInfo.get("owner"));
        return field;
    }

}
