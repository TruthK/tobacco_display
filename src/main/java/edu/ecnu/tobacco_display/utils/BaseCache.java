package edu.ecnu.tobacco_display.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author TruthK
 */
@Component
public class BaseCache {


    private Cache<String, Object> minuteCache = CacheBuilder.newBuilder()

            //设置缓存初始大小，应该合理设置，后续会扩容
            .initialCapacity(10)
            //最大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)

            //缓存过期时间，写入后30分钟过期
            .expireAfterWrite(30, TimeUnit.MINUTES)

            //统计缓存命中率
            .recordStats()

            .build();


    private Cache<String, Object> hourCache = CacheBuilder.newBuilder()

            //设置缓存初始大小，应该合理设置，后续会扩容
            .initialCapacity(30)
            //最大值
            .maximumSize(100)
            //并发数设置
            .concurrencyLevel(5)

            //缓存过期时间，写入后3小时 过期
            .expireAfterWrite(3, TimeUnit.HOURS)

            //统计缓存命中率
            .recordStats()

            .build();


    public Cache<String, Object> getHourCache() {
        return hourCache;
    }

    public void setHourCache(Cache<String, Object> hourCache) {
        this.hourCache = hourCache;
    }

    public Cache<String, Object> getMinuteCache() {
        return minuteCache;
    }

    public void setMinuteCache(Cache<String, Object> minuteCache) {
        this.minuteCache = minuteCache;
    }
}
