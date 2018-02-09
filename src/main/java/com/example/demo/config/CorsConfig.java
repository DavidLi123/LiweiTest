package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 设置允许跨域
 * Created by liw on 2018/02/09.
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig(){
        /**
         * 允许任何域名使用
         * 允许任何头
         * 允许任何方法
         */
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //这里要设置为基本地址不然与AllowCredentials冲突
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    /**
     * CORS Filter实现标准的Javax.servlet.Filter接口，拦截进入的HTTP请求，如果识别出该请求为跨域的，
     * 则向请求中加入适用的CORS策略和header信息，然后再将该HTTP请求传递给真正的请求目标（包括servlets、JSP、静态XML/HTML文档等。）
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
