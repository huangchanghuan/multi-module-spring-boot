package com.yimi.product.movieserver.remote;

import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 远程调用服务
 */
@FeignClient(name= "user-server",fallback = UserRemoteHystrix.class)
public interface UserRemote {
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
    @RequestMapping(value = "/v001/user/searchAll")
    public ServiceResult<List<SysUser>> searchAll1();
}
