package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.exception.XdException;
import net.xdclass.online_xdclass.mapper.EpisodeMapper;
import net.xdclass.online_xdclass.mapper.PlayRecordMapper;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.mapper.VideoOrderMapper;
import net.xdclass.online_xdclass.model.entity.Episode;
import net.xdclass.online_xdclass.model.entity.PlayRecord;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author suning
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    /**
     * 下单操作
     *
     * @param userId  用户id
     * @param videoId 视频id
     * @return
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int save(int userId, int videoId) {
        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (videoOrder != null) {
            return 0;
        }
        Video video = videoMapper.findById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());
        //插入订单表
        int rows = videoOrderMapper.saveOrder(newVideoOrder);

        //插入播放记录
        if(rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeById(videoId);
            if(episode == null) {
                throw new XdException(-1, "该视频没有集信息，请联系运营人员");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCreateTime(new Date());
            playRecordMapper.save(playRecord);
        }

        return rows;
    }

    @Override
    public List<VideoOrder> listOrderByUserId(int userId) {
        List<VideoOrder> videoOrderList = videoOrderMapper.listOrderByUserId(userId);
        return videoOrderList;
    }
}
