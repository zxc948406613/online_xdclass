package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 根据手机号查询用户信息
     * @param phone 电话号
     * @return 用户信息
     */
    User findByPhone(String phone);

    /**
     * 保存用户信息
     * @param userInfo 用户实体
     * @return 用户实体
     */
    int save(Map<String, String> userInfo);

    String findByPhoneAndPwd(String phone, String pwd);

    User findByUserId(Integer id);
}
