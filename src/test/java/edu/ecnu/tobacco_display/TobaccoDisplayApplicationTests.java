package edu.ecnu.tobacco_display;

import com.alibaba.fastjson.JSON;
import edu.ecnu.tobacco_display.model.entity.CityMap;
import edu.ecnu.tobacco_display.utils.ReadFromFile;
import edu.ecnu.tobacco_display.utils.SerializeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.UnsupportedEncodingException;

@SpringBootTest
class TobaccoDisplayApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String jsonString = ReadFromFile.readFileByLines("D:\\code\\tobacco_display\\src\\main\\resources\\city.json");

//        jsonString = jsonString.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        byte[] utf8Bytes = jsonString.getBytes("UTF-8");
        jsonString = new String(utf8Bytes, "UTF-8");
        //        System.out.println(jsonString);
//        RedisUtils redisUtils = new RedisUtils();
//        redisUtils.set("zyj", "redis后端三郎");
        CityMap object = JSON.parseObject(jsonString, CityMap.class);
//        System.out.println(object);
        byte[] serialize = SerializeUtil.serialize(object);

        redisTemplate.opsForValue().set("city_map", JSON.toJSONString(object));

        String bytes = (String) redisTemplate.opsForValue().get("city_map");
//        CityMap obj = (CityMap) SerializeUtil.unserialize(bytes);

//        redisTemplate.opsForValue().set("test_1","1111");
        System.out.println(JSON.parseObject(bytes, CityMap.class).toString());
    }

}
