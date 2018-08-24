package com.yimi.product.service.impl;


import com.yimi.product.entity.SysUser;
import com.yimi.product.mapper.UserMapper;
import com.yimi.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    public List<SysUser> getUsers() {
        List<SysUser> users = userMapper.getAll();
        return users;
    }

    public SysUser getUser(Long id) {
        SysUser user = userMapper.getOne(id);
        return user;
    }

    public boolean save(SysUser user) {
        return userMapper.insert(user);
    }

    public void update(SysUser user) {
        userMapper.update(user);
    }

    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

    /**
     * 测试乐观锁/悲观锁
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = true)
    public long updateState(SysUser user) throws Exception {
        long num = userMapper.updateState(user);
        System.out.println("A事务返回更新行数:" + num);

        long num1 = userService.updateState1(user);

        System.out.println("开始记录日志");
//        //抛出异常
//        if (true)
//        throw new Exception("");
        return num;
    }


    /**
     * 发送红包
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long updateState1(SysUser user) {
        user.setUid(2);
        long num = userMapper.updateState1(user);
        System.out.println("A事务返回更新行数:" + num);
        return num;
    }


    /**
     * 根据用户id查询
     *
     * @param userId
     * @return
     */
    @Override
    public SysUser findByUsername(long userId) {
        System.out.println("UserInfoServiceImpl.getOne()");
        return userMapper.getOne(userId);
    }


}