package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author suning
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     *
     * @return 首页轮播图列表
     */
    @GetMapping("/list_banner")
    public JsonData indexBanner() {
        List<VideoBanner> bannerList = videoService.listBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     *
     * @return 全量video列表
     */
    @RequestMapping("/list_video")
    public JsonData queryVideoList() {
        return JsonData.buildSuccess(videoService.queryVideoList());
    }

    /**
     * 通过id查询视频
     * @return 对应视频
     */
    @GetMapping("/find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true)int id) {
        Video video = videoService.findDetailById(id);
        return JsonData.buildSuccess(video);
    }

}
