package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JwtUtils;
import net.xdclass.online_xdclass.utils.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOOGER = LoggerFactory.getLogger("UserServiceImpl");

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPhone(String phone) {
        User user = userMapper.findByPhone(phone);
        return user;
    }

    @Override
    public int save(Map<String, String> userInfo) {
        LOOGER.info("进入用户注册服务");
        User user = parseToUser(userInfo);

        if (user != null) {
            userMapper.save(user);
        } else {
            LOOGER.info("用户注册失败，入参字段有空值");
            return -1;
        }
        LOOGER.info("用户注册成功");

        return 1;
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, Md5Utils.Md5(pwd));
        if(user == null) {
            return null;
        }else {
            String token = JwtUtils.geneJwt(user);
            return token;
        }
    }

    /**
     * 根据id查找用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.findByUserId(userId);
        return user;
    }

    /**
     * 解析user对象
     * @param userInfo 入参的user map信息
     * @return  User实体
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            //密码额外需要md5加密
            String pwd = userInfo.get("pwd");
            user.setPwd(Md5Utils.Md5(pwd));
            return user;
        } else {
            return null;
        }
    }

    /**
     * 放到CND上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * 获取随机头像
     * @return 随机头像的URL
     */
    private static String getRandomImg() {
        int size = headImg.length;
        Random random = new Random();
        return headImg[ random.nextInt(size)];
    }

}
