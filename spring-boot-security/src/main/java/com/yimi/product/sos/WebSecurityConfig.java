package com.yimi.product.sos;

import com.yimi.product.sevice.impl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author 黄昌焕
 * @Date 2018-04-12  14:28
 */
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserService customUserService;
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler MySavedRequestAwareAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  允许所有用户访问"/"和"/index.html"
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()   // 其他地址的访问均需验证权限
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/success.html")
//                .successForwardUrl("/success.html")
//                .successHandler(MySavedRequestAwareAuthenticationSuccessHandler)//  登录页
                .failureUrl("/login-error.html").permitAll();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        //会创建一个securityFilterChain
        web.ignoring().antMatchers("/css/**");
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}

