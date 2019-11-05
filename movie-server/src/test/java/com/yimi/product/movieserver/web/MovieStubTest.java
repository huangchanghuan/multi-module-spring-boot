package com.yimi.product.movieserver.web;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
//springboot的测试启动类，需要依赖spring-boot-test库
@SpringBootTest
//初使化测试测试配置，测试controller需要
@AutoConfigureMockMvc
//启动契约服务，模拟produer提供服务
@AutoConfigureStubRunner(ids = {"com.yimi.product:user-server:+:stubs:8999"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class MovieStubTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser //解决control层权限问题
    public void testMethod() throws Exception {
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get("/movie/classes").param("name", "zhangsan"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code", Is.is("000000")))
                .andReturn();// 返回执行请求的结果;
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
//    @WithMockUser
    public void testSearchAll() throws Exception {
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.get("/movie/searchAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();// 返回执行请求的结果;
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}