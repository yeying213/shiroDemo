package org.shrio.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.shrio.Service.SysService;
import org.shrio.model.ActiveUser;
import org.shrio.model.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 *
 *   1.上面的程序通过shiro-perssion.ini配置文件对权限信息
 *   进行静态的配置，实际的开发里面，一般从数据库里面
 *   来获取权限数据，就需要自定义realm,通过realm从数据库查询权限数据
 *   ream通过用户身份查询数据库权限数据，将权限数据返回给authoizer(授权器)
 *   2.自定义realm完成之后，需要将realm设置到securityMananger里面
 *   通过shiro-ream.ini文件来描述完成
 *   [main]
 #自定义realm
 customRelam=shiroDemoTest.CustomRelam
 #将realm设置到securityManager,相当于Spring的注入
 securityManager.realms=$customRelam
 *
 */
public class CustomRelam extends AuthorizingRealm {
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
        //从principalCollection里面获取主身份,
        // 有目标的转化成真实的身份---doGetAuthenticationInfo()方法里面的SimpleAuthenticationInfo（）里面填充
        //的身份认证信息的类型
        // String userCode= (String) principalCollection.getPrimaryPrincipal();
        //上面认证 设置的是activeUser类型的身份信息 ，下面 授权 就需要进行 设置 类似的信息  --
        //切记 认证的身份类型信息 要和 这里授权 需要的身份信息 进行 关联 对应
        ActiveUser activeUser= (ActiveUser) principalCollection.getPrimaryPrincipal();
        //根据身份信息 获取权限信息
        //模拟从数据库 获取到的数据
        List<String> persissionDatas=new ArrayList<String>();
        persissionDatas.add("user:create");//用户创建
        persissionDatas.add("user:update");//用户更新
        persissionDatas.add("user:add");
        persissionDatas.add("item:query");
        persissionDatas.add("item:edit");
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
        //模拟从数据库得到密码
        String password="111111";
        //返回查询到的认证信息
        ActiveUser activeUser=new ActiveUser();
        activeUser.setUserid("zhangsan");
        activeUser.setUsercode("zhangsan");
        activeUser.setUsername("张三");
        //....
        List<SysPermission> menuList=null;
        //根据用户id  取出菜单
        try {
            menuList= sysService.findMenuListByUserId("zhangsan");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //将用户菜单 设置到 activeUser
        activeUser.setMenus(menuList);
        //将activitiser设置到simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(activeUser,password,this.getName());
        return simpleAuthenticationInfo;
    }
}
