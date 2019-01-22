package com.yimi.product;

import com.yimi.product.web.UserControllerV001;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.*;
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

    @BeforeClass
    public static void beforeAllTest(){

    }

    @AfterClass
    public static void afterAllTest(){

    }

    @Before
    public void beforeEveryTest() {
        RestAssuredMockMvc.webAppContextSetup(context);
    }

    @After
    public void afterEveryTest() {

    }


    @Test(timeout = 1000)
    @Ignore("not ready yet")
    public void contextLoads() {
        System.out.println("another test");
    }

}
