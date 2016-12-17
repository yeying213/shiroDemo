package org.shrio.mapper;

import org.shrio.model.SysPermission;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
public interface SysPermissionMapperCustom {

    //根据用户id查询菜单
    public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
    //根据用户id查询权限url
    public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;
}
