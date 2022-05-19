package edu.ecnu.tobacco_display.scheduling;

import edu.ecnu.tobacco_display.mapper.BakingMapper;
import edu.ecnu.tobacco_display.mapper.CurveMapper;
import edu.ecnu.tobacco_display.mapper.DetailRoastedTobaccoMapper;
import edu.ecnu.tobacco_display.model.entity.BakingRecord;
import edu.ecnu.tobacco_display.model.entity.Curve;
import edu.ecnu.tobacco_display.model.entity.DetailRoastedTobacco;
import edu.ecnu.tobacco_display.service.BakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author TruthK
 */
@Component
public class CurveContrastScheduling {
    @Autowired
    private BakingMapper bakingMapper;
    @Autowired
    private DetailRoastedTobaccoMapper detailRoastedTobaccoMapper;
    @Autowired
    private CurveMapper curveMapper;

    private static List<Float> findTemp(String curve) throws Exception {
        ArrayList<Float> list = new ArrayList<>();
        String[] split = curve.split(",");
        for (String s : split) {
            String[] temp = s.split(":")[1].split("-");
            if (temp[0].equals(temp[1])) {
                list.add(Float.valueOf(temp[0]));
            }
        }
        return list;
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void execute() throws Exception {
        List<BakingRecord> bakingRecords = bakingMapper.SelectNotContrastRecords();
        for (BakingRecord br : bakingRecords) {
            DetailRoastedTobacco detailRoastedTobacco = new DetailRoastedTobacco();
            detailRoastedTobacco.setDeviceId(br.getDeviceId());
            detailRoastedTobacco.setStartTime(br.getStartTime());
            detailRoastedTobacco.setEndTime(br.getEndTime());

            List<DetailRoastedTobacco> tobaccoList =
                    detailRoastedTobaccoMapper.findNotContrast(detailRoastedTobacco);

            Curve curve = new Curve();
            curve.setKind(br.getCurveKind());
            curve.setDryOrWet("dry");
            List<Curve> curveDryList = curveMapper.findCurveByOptions(curve);
            if (curveDryList.size() != 1) {
                continue;
            }
            String curveDry = curveDryList.get(0).getCurve();

//            curve.setDryOrWet("wet");
//            List<Curve> curveWetList = curveMapper.findCurveByOptions(curve);
//            if (curveWetList.size() != 1) {
//                continue;
//            }
//            String curveWet = curveWetList.get(0).getCurve();

            List<Float> curveDryTempList = findTemp(curveDry);
//            List<Float> curveWetTempList = findTemp(curveWet);


            ArrayList<Float> dryList = new ArrayList<>();
            if (tobaccoList.size() > curveDryTempList.size() * 2) {
                System.out.println("sdsadasdsad");
                int num = (int) Math.floor(tobaccoList.size() / curveDryTempList.size());
                int count = 0;
                for (DetailRoastedTobacco s : tobaccoList) {
                    if (count % num == 1) {
                        dryList.add(Float.valueOf(String.valueOf(s.getDryBallTarget())));
                    }
                    count++;
                }
            } else {
                for (DetailRoastedTobacco s : tobaccoList) {
                    dryList.add(Float.valueOf(String.valueOf(s.getDryBallTarget())));
                }
            }

            System.out.println(dryList);
            float contrast = 0;
            int size = dryList.size() > curveDryTempList.size() ?
                    curveDryTempList.size() : dryList.size();
            for (int i = 0; i < size; i++) {
                float curveDryTemp = curveDryTempList.get(i);
                float DryTemp = dryList.get(i);
                System.out.println(curveDryTemp + "  " + DryTemp + "  " + contrast);
                float gap = Math.abs(DryTemp - curveDryTemp);
                if (gap > 10) {
                    gap = 10;
                }
                contrast += gap;

            }
            BakingRecord newbakingRecord = new BakingRecord();

            contrast = 100 - contrast;

            if (contrast < 0) {
                contrast = 0;
            }

            newbakingRecord.setId(br.getId());
            newbakingRecord.setCurveContrast(contrast);
            bakingMapper.alterBakingRecord(newbakingRecord);
        }

    }

}
