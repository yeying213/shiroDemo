package org.shrio.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.shrio.Service.SysService;
import org.shrio.model.ActiveUser;
import org.shrio.model.SysPermission;
import org.shrio.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 *   动态的从数据库里面 取得信息 进行校验
 */
public class CustomRelamDb extends AuthorizingRealm {
    @Autowired
    private SysService sysService;
    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRelam");
    }

    /**
     * 用于授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从principalCollection里面获取认证的主身份,
        // 有目标的转化成真实的身份---doGetAuthenticationInfo()方法里面的SimpleAuthenticationInfo（）里面填充
        //的身份认证信息的类型
        // String userCode= (String) principalCollection.getPrimaryPrincipal();
        //上面认证 设置的是activeUser类型的身份信息 ，下面 授权 就需要进行 设置 类似的信息  --
        //切记 认证的身份类型信息 要和 这里授权 需要的身份信息 进行 关联 对应
        ActiveUser activeUser= (ActiveUser) principalCollection.getPrimaryPrincipal();
        //根据身份信息 获取权限信息
        //从数据库 获取到权限数据
        List<SysPermission> sysPermissionList=null;
        try {
            sysPermissionList=  sysService.findPermissionListByUserId(activeUser.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> persissionDatas=new ArrayList<String>();
        if (persissionDatas!=null) {
            for(SysPermission sysPermission:sysPermissionList){
                 //将数据库里面的权限标识符号 放入集合
                  persissionDatas.add(sysPermission.getPercode());//授权字符码
            }
        }
        //....
        //将查询到的权限信息 返回给Authoizer
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(persissionDatas);
        return simpleAuthorizationInfo;
    }

    /**
     * 用于认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从tocken里面获取用户信息，tocken是用户输入的


        String userCode= (String) authenticationToken.getPrincipal();
        SysUser sysUser=null;
        try {
           sysUser= sysService.findSysUserByUserCode(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sysUser==null){
            return  null;
        }

        //模拟从数据库得到密码
        String password=sysUser.getPassword();
        //获取盐
       String salt= sysUser.getSalt();
        //返回查询到的认证信息
        ActiveUser activeUser=new ActiveUser();
        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());
        //....
        List<SysPermission> menuList=null;
        //根据用户id  取出菜单
        try {
            menuList= sysService.findMenuListByUserId(sysUser.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
        //将用户菜单 设置到 activeUser
        activeUser.setMenus(menuList);
        //将activitiser设置到simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(activeUser,password, ByteSource.Util.bytes(salt),this.getName());
        return simpleAuthenticationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}

