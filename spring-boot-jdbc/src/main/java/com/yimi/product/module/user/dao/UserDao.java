package com.yimi.product.module.user.dao;

/**
 * 用户dao接口
 */
public interface UserDao {
    /**
     * 新增一个用户
     *
     * @param name
     * @param state
     */
    void addUser(String name, int state);

    /**
     * 获取用户总数
     *
     * @return
     */
    Integer getAllUsers();

}
