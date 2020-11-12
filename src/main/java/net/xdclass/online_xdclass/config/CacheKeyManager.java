package net.xdclass.online_xdclass.config;

/**
 * 缓存key管理
 *
 * @author suning
 */
public class CacheKeyManager {
    /**
     * 首页轮播图缓存key
     */
    public static final String INDEX_BANNER_KEY = "index:banner";

    /**
     * 视频列表缓存key
     */
    public static final String INDEX_VIDEO_KEY = "index:video";

    /**
     * 视频详情缓存key %s是视频id
     */
    public static final String INDEX_VIDEO_DETAIL_KEY = "index:videoDetail:%s";
}

