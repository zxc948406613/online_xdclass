package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.VideoOrder;

import java.util.List;

/**
 * @author suning
 */
public interface VideoOrderService {

    /**
     * 提交订单
     *
     * @param userId  用户id
     * @param videoId 视频id
     * @return 返回
     */
    int save(int userId, int videoId);

    /**
     * 根据用户id查询其下订单列表
     * @param userId 用户id
     * @return 订单列表
     */
    List<VideoOrder> listOrderByUserId(int userId);
}
