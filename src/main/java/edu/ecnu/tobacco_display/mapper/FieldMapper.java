package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.Field;

import java.util.List;


public interface FieldMapper {
    List<Field> findFieldByOptions(Field field);

    int saveFieldInfo(Field field);

    int alterFieldInfo(Field field);

    int deleteField(Field field);
}
