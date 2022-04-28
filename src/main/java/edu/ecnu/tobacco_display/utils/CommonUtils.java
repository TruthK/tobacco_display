package edu.ecnu.tobacco_display.utils;

import java.security.MessageDigest;
import java.util.*;

/**
 * 工具类
 * @author TruthK
 */
public class CommonUtils {


    /**
     * MD5加密工具类
     *
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;

    }

    /**
     * 驼峰式命名法
     */
    public static Map<String, String> formatHumpName(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String newKey = underlineToCamel(key);
            newMap.put(newKey, entry.getValue());
        }
        return newMap;
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(Character.toLowerCase(param.charAt(i)));
            }
        }
        return sb.toString();
    }
    /**
     * 将List中map的key值命名方式格式化为驼峰
     *
     * @param
     * @return
     */
    public static List<Map<String, String>> formatHumpNameForList(List<Map<String, String>> list) {
        List<Map<String, String>> newList = new ArrayList<Map<String, String>>();
        for (Map<String, String> o : list) {
            newList.add(formatHumpName(o));
        }
        return newList;
    }





}
