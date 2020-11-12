package net.xdclass.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 视频轮播图实体
 */
public class VideoBanner {
    private Integer id;

    private String url;

    private String img;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createTime;

    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", createTime='" + createTime + '\'' +
                ", weight=" + weight +
                '}';
    }
}
