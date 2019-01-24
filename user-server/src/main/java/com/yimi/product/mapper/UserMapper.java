package com.yimi.product.mapper;


import com.yimi.product.entity.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<SysUser> getAll();

    @Select("SELECT username,password FROM sys_user WHERE uid = #{id}")
    SysUser getOne(Long id);

    @Select("SELECT * FROM sys_user WHERE username = #{username}")
    @Results({
            @Result(column="uid",property="roleList",
                    many=@Many(
                            select="com.yimi.product.mapper.RoleMapper.getAllRolesByUid",
                            fetchType= FetchType.LAZY
                    )
            )
    })
    SysUser findByUsername(String username);

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