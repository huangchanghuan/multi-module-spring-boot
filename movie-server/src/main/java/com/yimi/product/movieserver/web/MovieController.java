package com.yimi.product.movieserver.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import com.yimi.product.movieserver.remote.UserRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/movie")//url:/项目/模块/资源/{id}/细分  seckill/list
@RefreshScope
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private UserRemote userRemote;
    @Autowired
    private ObjectMapper objectMapper;

//    @Value("${movie-server.config.hello}") 这里要不要进行实体封装
    private String hello;

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
    public String hello() {
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
}
