package com.yimi.product.sos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

/**
 * @Author 黄昌焕
 * @Date 2018-04-12  14:28
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService customUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // 关闭csrf保护功能（跨域访问）
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/oauth/**").permitAll()
//                    .antMatchers("/**/*.js", "/**/*.css", "/**/*.png",
//                            "/**/*.gif", "/**/*.jpg", "/**/*.jpeg", "/**/*.map",
//                            "/**/*.ico").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .defaultSuccessUrl("/success.html")
//                .failureUrl("/login-error.html").permitAll();
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html");
//    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

