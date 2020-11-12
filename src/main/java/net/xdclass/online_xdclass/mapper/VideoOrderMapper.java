package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suning
 */
@Repository
public interface VideoOrderMapper {
    /**
     * 查找用户是否购买过视频
     * @param userId 用户id
     * @param videoId 视频id
     * @param state 状态
     * @return 返回video
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 下单
     * @param videoOrder 订单实体
     * @return 返回
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 根据用户id查询订单列表
     * @param userId 用户id
     * @return 订单列表
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") int userId);
}
