package com.yimi.product.movieserver.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.yimi.product.movieserver.dto.Result;
import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import com.yimi.product.movieserver.remote.UserRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/movie")//url:/项目/模块/资源/{id}/细分  seckill/list
@RefreshScope
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private UserRemote userRemote;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${server.config.hello}") //这里要不要进行实体封装
    private String hello;

    @GetMapping("/classes")
    public Result hello(@RequestParam String name) {
        return userRemote.users(name);
    }
    /**
     * 序列化测试
     *
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public SysUser search() {
//        System.out.println("远程服务获取结果:");
        logger.info("search mock");
        String result=userRemote.search();
        logger.info(result);
//        try{
//            Thread.sleep(1000000);
//        }catch ( Exception e){
//            logger.error(" hello two error",e);
//        }
        return new SysUser();
    }

    /**
     * 序列化测试
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() throws ExecutionException, InterruptedException {
//        System.out.println("远程服务获取结果:");
        logger.info("request two name is 2");
//        try{
//            Thread.sleep(1000000);
//        }catch ( Exception e){
//            logger.error(" hello two error",e);
//        }
        return hello;
    }
    /**
     * 序列化测试
     *
     * @return
     */
    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<List<SysUser>> searchAll() {
        System.out.println(hello);
        String result= userRemote.searchAll();
//        System.out.println("远程服务获取结果:"+result);
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ServiceResult<List<SysUser>> jsonObject = null;
        try {
            jsonObject = objectMapper.readValue(result,  new TypeReference<ServiceResult<List<SysUser>>>() {});
        } catch (IOException e) {
        }
        return jsonObject;
    }



    /**
     * 序列化测试
     *
     * @return
     */
    @RequestMapping(value = "/searchAll1", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<List<SysUser>> searchAll1() {
//        System.out.println("远程服务获取结果:");
        return userRemote.searchAll1();
    }

    @RequestMapping(value = "/testHystrixCommand", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(groupKey="UserGroup", commandKey = "testHystrixCommand",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "2"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            })
    public String testHystrix(){
        System.out.println("线程名: "+Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }


    @RequestMapping(value = "/testHystrix1Command", method = RequestMethod.GET)
    @ResponseBody
    @HystrixCommand(groupKey="UserGroup1", commandKey = "testHystrix1Command",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
//                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "2"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            })
    public Future<String> testHystrixFuture(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                System.out.println("hystrix线程名: "+Thread.currentThread().getName());
                return Thread.currentThread().getName();
            }
            // 重写了 get 方法
            @Override
            public String get() {
                return invoke();
            }
        };

    }
}
