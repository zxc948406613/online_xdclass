package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.Episode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author suning
 */
@Repository
public interface EpisodeMapper {

    /**
     * 通过视频id获取第一集
     * @param videoId 视频id
     * @return 第一集实体
     */
    Episode findFirstEpisodeById(@Param("video_id") int videoId);
}
