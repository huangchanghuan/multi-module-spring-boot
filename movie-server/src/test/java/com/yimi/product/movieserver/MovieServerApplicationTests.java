package com.yimi.product.movieserver;

import com.yimi.product.movieserver.web.MovieController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServerApplicationTests {
    @Autowired
    public MovieController movieController;

    @Test
    public void contextLoads() throws ExecutionException, InterruptedException {
        System.out.println(movieController.testHystrixFuture().get());
        System.out.println(movieController.testHystrixFuture().get());
        System.out.println(movieController.testHystrixFuture().get());
        System.out.println(movieController.testHystrixFuture().get());
        System.out.println(movieController.testHystrixFuture().get());
        System.out.println(movieController.hello());
    }

}
