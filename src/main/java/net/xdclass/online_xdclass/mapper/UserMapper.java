package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author suning
 */

@Repository
public interface UserMapper {

    /**
     * 根据手机号查询用户信息
     * @param phone 电话号
     * @return 用户信息
     */
    User findByPhone(@Param("phone") String phone);

    /**
     * 保存用户信息
     * @param user 用户实体
     * @return 保存成功
     */
    int save(User user);


    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findByUserId(@Param("userId")Integer userId);
}
