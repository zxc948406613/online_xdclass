package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.PlayRecord;
import org.springframework.stereotype.Repository;

/**
 * @author suning
 */
@Repository
public interface PlayRecordMapper {
    /**
     * 保存播放记录信息
     *
     * @param playRecord 播放记录
     * @return 保存是否成功
     */
    int save(PlayRecord playRecord);

}
