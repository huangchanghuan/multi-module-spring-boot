package com.yimi.product.sos.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 黄昌焕
 * @Date 2018-02-23  14:16
 */
@Configuration
public class InterceptorConfigurerAdapter implements WebMvcConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(InterceptorConfigurerAdapter.class);
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 添加路径
        // excludePathPatterns 排除路径
        registry.addInterceptor(new AuthInteceptor()).addPathPatterns("/**");
    }
}
