package net.xdclass.online_xdclass.config;

import net.xdclass.online_xdclass.intercepter.CorsInterceptor;
import net.xdclass.online_xdclass.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * <p>
 * 不用权限的访问url /api/v1/pub
 * 用登录的访问url  /api/v1/pri
 *
 * @author suning
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*")
                .excludePathPatterns("/api/v1/pri/user/login", "/api/v1/pri/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);
    }


}
