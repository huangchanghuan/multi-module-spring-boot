package com.yimi.product.movieserver.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import com.yimi.product.movieserver.remote.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")//url:/项目/模块/资源/{id}/细分  seckill/list
public class MovieController {
    @Autowired
    private UserRemote userRemote;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 序列化测试
     *
     * @return
     */
    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<List<SysUser>> searchAll() {
        String result= userRemote.searchAll();
        System.out.println("远程服务获取结果:"+result);
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
        return userRemote.searchAll1();
    }
}
