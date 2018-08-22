package com.yimi.product.mapper;


import com.yimi.product.entity.SysUser;
import com.yimi.product.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
	
	@Select("SELECT * FROM sys_user")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class)
	})
	List<SysUser> getAll();
	
	@Select("SELECT * FROM sys_user WHERE uid = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class)
	})
	SysUser getOne(Long id);


	@Insert("INSERT INTO sys_user(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(SysUser user);

	@Update("UPDATE sys_user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	long update(SysUser user);

	@Update("UPDATE sys_user SET state=state+1 WHERE uid =#{uid}")
	long updateState(SysUser user);

	@Update("UPDATE sys_user SET state=state+1 WHERE uid =#{uid}")
	long updateState1(SysUser user);

	@Delete("DELETE FROM sys_user WHERE id =#{id}")
	long delete(Long id);



}