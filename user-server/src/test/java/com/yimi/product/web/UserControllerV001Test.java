package com.yimi.product.web;

import com.yimi.product.entity.SysUser;
import com.yimi.product.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerV001Test {

    @InjectMocks
    UserControllerV001 userControllerV001;//被测试类

    @Mock
    private UserService userService;

    @Before
    public  void beforeEveryTest() {

    }
    @Test
    public void searchByIdTest(){
        SysUser sysUser = mock(SysUser.class);
        Mockito.when(sysUser.getName()).thenReturn("peter");
        Mockito.when(userService.getUser(1L)).thenReturn(sysUser);
        Assert.assertNotNull(userControllerV001.searchById(1L).getData().getName());
    }

    @Test
    public void searchTest(){
        //要mock的实体类
        LinkedList mockedList = mock(LinkedList.class);
//模拟方法调用的返回值
        Mockito.when(mockedList.get(0)).thenReturn("first");
        Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());
//打印出"first"
        System.out.println(mockedList.get(0));
    }


}
