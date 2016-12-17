package org.shrio.Service.Impl;

import org.shrio.Exception.CustomException;
import org.shrio.Service.SysService;
import org.shrio.mapper.SysPermissionMapperCustom;
import org.shrio.mapper.SysUserMapper;
import org.shrio.model.ActiveUser;
import org.shrio.model.SysPermission;
import org.shrio.model.SysUser;
import org.shrio.model.SysUserExample;
import org.shrio.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
@Service
public class SysServiceImpl implements SysService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysPermissionMapperCustom sysPermissionMapperCustom;

    /**
     * 认证身份
     * @param userCode
     * @param password
     * @return
     * @throws Exception
     */
    public ActiveUser authenticat(String userCode, String password) throws Exception {
        SysUser sysUser= findSysUserByUserCode(userCode);
        if(sysUser==null){
            throw new CustomException("用户不存在");
        }
        String pass_db=sysUser.getPassword();
        //对页面输入进行加密
        String input_pass_md5= Md5Utils.getMd5(password);
        //密码对比
        if(!input_pass_md5.equals(pass_db)){
            throw new CustomException("用户名或者密码错误");
        }
        //认证通过返回身份信息
        ActiveUser activeUser=new ActiveUser();
        activeUser.setUsername(sysUser.getUsername());
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        return activeUser;
    }
    public SysUser findSysUserByUserCode(String userCode) throws Exception {
        SysUserExample sysUserExample=new SysUserExample();
        //public static class Criterion
        SysUserExample.Criteria criteria=sysUserExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);
        List<SysUser> sysUsers=sysUserMapper.selectByExample(sysUserExample);
        if(sysUsers!=null&&sysUsers.size()==1){
            return sysUsers.get(0);
        }
        else {
            return null;
        }
    }

    public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
        return sysPermissionMapperCustom.findMenuListByUserId(userid);
    }
    public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
        return sysPermissionMapperCustom.findPermissionListByUserId(userid);
    }
}

