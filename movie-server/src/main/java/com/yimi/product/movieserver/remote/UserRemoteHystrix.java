package com.yimi.product.movieserver.remote;

import com.yimi.product.movieserver.dto.ServiceResult;
import com.yimi.product.movieserver.entity.SysUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 熔断fallback
 */
@Component
public class UserRemoteHystrix implements UserRemote{
    @Override
    public String searchAll() {
        return "查询失败";
    }

    @Override
    public String search() {
        return "查询失败";
    }

    @Override
    public ServiceResult<List<SysUser>> searchAll1() {
        return new ServiceResult<List<SysUser>>(false,new ArrayList<>());
    }
}
