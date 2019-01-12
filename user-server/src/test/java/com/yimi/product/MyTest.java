package com.yimi.product;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.LinkedList;



@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    public ArrayService arrayService;
    private int SIZE=10;

    private static LinkedList<Integer> populatedQueue(int n) {
        //创建一个链表
        LinkedList<Integer> q = new LinkedList<>();
        Assert.assertTrue(q.isEmpty());
        for (int i = 0; i < n; ++i)
            Assert.assertTrue(q.offer(new Integer(i)));
        Assert.assertFalse(q.isEmpty());
        Assert.assertEquals(n, q.size());
        Assert.assertEquals((Integer) 0, q.peekFirst());
        Assert.assertEquals((Integer) (n - 1), q.peekLast());
        return q;
    }

    @Test
    public void testConstructor3(){
        try {
            new LinkedList((Collection)null);
        } catch (NullPointerException success) {
            success.printStackTrace();
            System.out.println(success.getMessage());
        }
    }

}
