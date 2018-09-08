package com.yimi.product.service;


import com.yimi.product.entity.SysUser;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    /**
     * 通过username查找用户信息;
     */
    public SysUser findByUsername(long userId);

    public List<SysUser> getUsers();

    public SysUser getUser(Long id);

    public boolean save(SysUser user);

    public void update(SysUser user);

    public void delete(@PathVariable("id") Long id);

    public long updateState(SysUser user) throws Exception;

    public long updateState1(SysUser user);
}