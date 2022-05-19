package edu.ecnu.tobacco_display.mapper;

import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.model.request.QueryOptionsRequest;

import java.util.List;

public interface DetailRoastedTobaccoMapper {

    /**
     * 查询视频列表
     *
     * @return
     */
    List<DetailRoastedTobacco> findDetailByOptions(DetailRoastedTobacco queryOptionsRequest);

    List<DetailRoastedTobacco> findNotContrast(DetailRoastedTobacco queryOptionsRequest);

}
