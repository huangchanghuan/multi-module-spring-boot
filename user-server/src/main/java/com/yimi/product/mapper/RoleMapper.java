package com.yimi.product.mapper;

import com.yimi.product.entity.SysRole;
import com.yimi.product.entity.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * FROM sys_role WHERE id in (select role_id from sys_user_role where uid=#{id})")
    @Results({
            @Result(column="id",property="permissions",
                    many=@Many(
                            select="com.yimi.product.mapper.PermissionMapper.getAllPermissionsByRoleId",
                            fetchType= FetchType.LAZY
                    )
            )
    })
    List<SysRole> getAllRolesByUid(Long id);

}
