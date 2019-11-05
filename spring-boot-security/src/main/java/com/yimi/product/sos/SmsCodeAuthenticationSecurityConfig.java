package com.yimi.product.sos;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

//@Component todo 不生效奇怪
public class SmsCodeAuthenticationSecurityConfig  extends AbstractHttpConfigurer<SmsCodeAuthenticationSecurityConfig, HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("过滤器链添加新的filter");
    }
}
