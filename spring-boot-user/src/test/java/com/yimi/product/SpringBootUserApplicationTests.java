package com.yimi.product;

import com.yimi.product.web.UserControllerV001;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpringBootUserApplicationTests {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new UserControllerV001());
    }

    @Test
    public void contextLoads() {

    }

}
