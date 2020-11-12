package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suning
 */
@Repository
public interface VideoMapper {

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
    List<VideoBanner> queryBannerList();

    /**
     * 通过id查询视频
     * @return 对应视频
     * @param id
     */
    Video findDetailById(@Param("video_id") int id);

    /**
     * 简单查询视频详情
     * @param videoId 视频id
     * @return 视频实体
     */
    Video findById(@Param("video_id") int videoId);
}
