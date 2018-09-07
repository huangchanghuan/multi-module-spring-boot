package com.yimi.product;

import com.yimi.product.web.UserControllerV001;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * @Author 黄昌焕
 * @Date 2018-09-07  13:10
 */
public class MvcMockTest {
    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new UserControllerV001());
    }
}
