package edu.ecnu.tobacco_display.service;

import edu.ecnu.tobacco_display.model.entity.Field;

import java.util.List;
import java.util.Map;

public interface TobaccoFieldService {
    List<Field> findFieldByOptions(Map<String, String> fieldInfo);

    int saveFieldInfo(Map<String, String> fieldInfo);

    int alterFieldInfo(Map<String, String> fieldInfo);

    int deleteField(Map<String, String> fieldInfo);
}
