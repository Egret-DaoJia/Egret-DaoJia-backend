package com.edj.cache.constants;

/**
 * 缓存相关常量
 *
 * @author A.E.
 * @date 2024/10/22
 */
public class CacheConstants {

    public static final class CacheName {
        /**
         * 缓存前缀
         */
        public static final String EDJ_CACHE = "EDJ_CACHE";

        /**
         * 城市相关缓存
         */
        public static final String CITY_CACHE = EDJ_CACHE + ":CITY";

        /**
         * 区域相关缓存
         */
        public static final String REGION_CACHE = EDJ_CACHE + ":REGION";

        /**
         * 首页服务列表缓存
         */
        public static final String HOME_CATEGORY_CACHE = EDJ_CACHE + ":HOME:CATEGORY";
    }

    public static final class CacheManager {
        /**
         * 缓存时间永久
         */
        public static final String FOREVER = "cacheManagerForever";

        /**
         * 缓存时间永久
         */
        public static final String THIRTY_MINUTES = "cacheManager30Minutes";

        /**
         * 缓存时间1天
         */
        public static final String ONE_DAY = "cacheManagerOneDay";
    }

    public static final class Ttl {
        /**
         * 缓存时间30分钟
         */
        public static final int THIRTY = 30;
    }
}
