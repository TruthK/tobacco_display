package edu.ecnu.tobacco_display.config;

import edu.ecnu.tobacco_display.interceptor.CorsInterceptor;
import edu.ecnu.tobacco_display.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * <p>
 * 不用权限可以访问url    /pub/
 * 要登录可以访问url    //
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


        /**
         * 拦截全部路径，这个跨域需要放在最上面
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

//        registry.addInterceptor(loginInterceptor()).addPathPatterns("/*/*/**")
//                //不拦截哪些路径   斜杠一定要加
//                .excludePathPatterns("/user");
//

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
