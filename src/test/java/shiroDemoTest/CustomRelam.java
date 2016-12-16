package shiroDemoTest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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
        String userCode= (String) principalCollection.getPrimaryPrincipal();
        //根据身份信息 获取权限信息
        //模拟从数据库 获取到的数据
        List<String> persissionDatas=new ArrayList<String>();
        persissionDatas.add("user:create");//用户创建
        persissionDatas.add("user:update");//用户更新
        persissionDatas.add("user:add");
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
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode,password,this.getName());
        return simpleAuthenticationInfo;
    }
}
