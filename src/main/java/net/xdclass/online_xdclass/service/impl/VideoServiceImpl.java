package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.config.CacheKeyManager;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author suning
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> queryVideoList() {
        //缓存——>数据库——>存入缓存
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_KEY, ()->{
               List<Video> videoList = videoMapper.queryVideoList();
               return videoList;
            });
            if(cacheObj instanceof List) {
                List<Video> videoList = (List<Video>)cacheObj;
                return videoList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {
        //缓存——>数据库——>存入缓存
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                List<VideoBanner> videoBannerList = videoMapper.queryBannerList();
                return videoBannerList;
            });
            if(cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int id) {
        try {
            String cacheKey = String.format(CacheKeyManager.INDEX_VIDEO_DETAIL_KEY, id);
            Object cacheObj = baseCache.getOneHourCache().get(cacheKey, ()->{
                Video video = videoMapper.findDetailById(id);
                return video;
            });
            if(cacheObj instanceof Video) {
                Video video = (Video)cacheObj;
                return video;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

}
