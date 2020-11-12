package net.xdclass.online_xdclass.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import net.xdclass.online_xdclass.utils.JsonData;
import net.xdclass.online_xdclass.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * @author suning
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进到controller前的拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String accessToken = request.getHeader("token");
            if (StringUtils.isEmpty(accessToken)) {
                accessToken = request.getParameter("token");
            }
            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JwtUtils.checkJwt(accessToken);
                if (claims == null) {
                    sendJsonMessage(response, JsonData.buildError("登录失败，重新登录"));
                    return false;
                    //登录失败，重新登录（解密失败，可能是过期）
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");

                request.setAttribute("user_id", id);
                request.setAttribute("name", name);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            //登录失败
            sendJsonMessage(response, JsonData.buildError("登录失败，重新登录"));
        }
        sendJsonMessage(response, JsonData.buildError("登录失败，重新登录"));
        return false;

    }

    /**
     * 相应JSON数据给前端
     *
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
