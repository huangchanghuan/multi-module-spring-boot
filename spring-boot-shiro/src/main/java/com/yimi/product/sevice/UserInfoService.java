package com.yimi.product.sevice;


import com.yimi.product.entity.SysUser;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public SysUser findByUsername(String username);
}