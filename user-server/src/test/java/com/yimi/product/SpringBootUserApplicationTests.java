package com.yimi.product;

import com.yimi.product.entity.SysUser;
import com.yimi.product.mapper.UserMapper;
import com.yimi.product.web.UserControllerV001;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Servlet;
import java.util.Scanner;
import java.util.logging.Filter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUserApplicationTests {
    private final static Logger logger = LoggerFactory.getLogger(SpringBootUserApplicationTests.class);
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserMapper userMapper;

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
    @Test
    public void testLazyMybatis() {
        SysUser sysUser=userMapper.findByUsername("admin");
        System.out.println(sysUser.getRoleList().size());
        System.out.println(sysUser.getRoleList().get(0).getPermissions().size());
    }
    public static void main(String args[]) {

        try {
            int a = 1 / 0;
        } catch (Exception e) {
            logger.error("ERROR", e);

            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        while (true){
            String str = s.next();
            System.out.println(str);
        }
    }
}

interface  str extends Filter , Servlet{}
