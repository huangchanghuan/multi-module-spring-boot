package com.yimi.product.movieserver.remote;

import com.yimi.product.movieserver.dto.Result;
import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 远程调用服务
 */
//@FeignClient(name= "user-server",fallback = UserRemoteHystrix.class)
@FeignClient(name= "user-server")
public interface UserRemote {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    Result users(@RequestParam("name") String name);

    /**
     *
     * @return
     */
    @RequestMapping(value = "/v001/user/searchAll")
    public String searchAll();

    /**
     *
     * @return
     */
    @RequestMapping(value = "/v001/user/search", method = RequestMethod.GET,consumes = {"text/plain"})
    public String search();

    /**
     *
     * @return
     */
    @RequestMapping(value = "/v001/user/searchAll",method = RequestMethod.GET)
    public ServiceResult<List<SysUser>> searchAll1();
}
