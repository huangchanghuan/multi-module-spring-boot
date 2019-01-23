package com.yimi.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringBootSecurityApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode("admin");
        System.out.println("加密后的密码:" + encode);
        System.out.println("bcrypt密码对比:" + passwordEncoder.matches("admin", encode));
        System.out.println("密码对比:" + passwordEncoder.matches("admin", "{bcrypt}$2a$10$vJNPB3Xw5CXgW..xc/rYaeZ9AUO.YWxUzerwIlOE.W478w5fu7huS"));

        String md5Password = "{MD5}88e2d8cd1e92fd5544c8621508cd706b";//MD5加密前的密码为:password
        System.out.println("MD5密码对比:" + passwordEncoder.matches("password", encode));
    }

}
