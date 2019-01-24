package com.yimi.product.mapper;

import com.yimi.product.entity.SysPermission;
import com.yimi.product.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("SELECT * FROM sys_permission WHERE id in (select permission_id from sys_role_permission where role_id=#{id})")
    List<SysPermission> getAllPermissionsByRoleId(Long id);

}
