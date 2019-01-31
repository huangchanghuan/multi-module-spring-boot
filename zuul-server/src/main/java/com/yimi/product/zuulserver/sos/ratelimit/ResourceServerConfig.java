package com.yimi.product.zuulserver.sos.ratelimit;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * resources server : user-server
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * 是否需要验证access token有效
     * ratelimit 需要权限的要经过这里,性能优化点,MysecurityRateLimitUtil 直接获取
     *
     * 作为网关,需要所有鉴权放网关的话,这里需要实现自动配置? 读取所有权限表数据 (url'requestmapping' : 权限)
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
                .authorizeRequests()
                    .antMatchers("/uaa/**","/greeting/simple")
                    .permitAll()
                .anyRequest().authenticated();
    }
}
