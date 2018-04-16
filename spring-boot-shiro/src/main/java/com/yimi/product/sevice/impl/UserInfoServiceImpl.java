package com.yimi.product.sevice.impl;


import com.yimi.product.dao.UserInfoDao;
import com.yimi.product.entity.SysUser;
import com.yimi.product.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public SysUser findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }



}