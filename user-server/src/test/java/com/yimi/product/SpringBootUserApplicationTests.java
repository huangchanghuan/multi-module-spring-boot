package com.yimi.product;

import com.yimi.product.web.UserControllerV001;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUserApplicationTests {
    @Autowired
    private WebApplicationContext context;
    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(context);
//        RestAssuredMockMvc.standaloneSetup(new UserControllerV001());
    }
    @Test
    public void contextLoads() {
        System.out.println("another test");
    }

}
