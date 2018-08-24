package com.yimi.product.mapper;


import com.yimi.product.entity.SysUser;
import com.yimi.product.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<SysUser> getAll();

    @Select("SELECT username,password FROM sys_user WHERE uid = #{id}")
    SysUser getOne(Long id);

    @Insert("INSERT INTO sys_user(name,password,username,state) VALUES(#{name}, #{password}, #{username},1)")
    boolean insert(SysUser user);

    @Update("UPDATE sys_user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    long update(SysUser user);

    @Update("UPDATE sys_user SET state=state+1 WHERE uid =#{uid}")
    long updateState(SysUser user);

    @Update("UPDATE sys_user SET state=state+1 WHERE uid =#{uid}")
    long updateState1(SysUser user);

    @Delete("DELETE FROM sys_user WHERE uid =#{id}")
    long delete(Long id);


}