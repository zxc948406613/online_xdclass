package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * @author suning
 */
public interface VideoService {

    /**
     * 查询全部video
     * @return 全量video列表
     */
    List<Video> queryVideoList();


    /**
     * 首页轮播图列表
     *
     * @return 首页轮播图列表
     */
    List<VideoBanner> listBanner();

    /**
     * 通过id查询视频
     * @return 对应视频
     * @param id
     */
    Video findDetailById(int id);
}
