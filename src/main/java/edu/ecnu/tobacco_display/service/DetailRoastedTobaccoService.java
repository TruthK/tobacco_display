package edu.ecnu.tobacco_display.service;


import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;

import java.util.List;
import java.util.Map;

public interface DetailRoastedTobaccoService {

//    List<DetailRoastedTobacco> listRoastedTobacco();

    List<DetailRoastedTobacco> findDetailByOptions(Map<String, String> queryOptions);


}
