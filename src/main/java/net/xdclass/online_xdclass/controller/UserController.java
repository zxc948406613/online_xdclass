package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.model.entity.User;
import net.xdclass.online_xdclass.model.request.LoginRequest;
import net.xdclass.online_xdclass.service.UserService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo 用户信息
     * @return 是否成功
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请重试");
    }

    /**
     * 登录接口
     * @param loginRequest 登录信息
     * @return 登录是否成功
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }

    /**
     * 根据id查找用户信息
     * @param request 请求
     * @return 返回
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request) {
        Integer id = (Integer)request.getAttribute("user_id");
        if(id == null) {
            return JsonData.buildError("用户信息查询失败");
        }
        User user = userService.findByUserId(id);
        return JsonData.buildSuccess(user);
    }
}
