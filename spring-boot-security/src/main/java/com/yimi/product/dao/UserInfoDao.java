package com.yimi.product.dao;


import com.yimi.product.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<SysUser, Long> {
    /**
     * 通过username查找用户信息;
     */
    public SysUser findByUsername(String username);
}