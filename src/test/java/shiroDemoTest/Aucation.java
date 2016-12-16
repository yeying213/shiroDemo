package shiroDemoTest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import java.util.Arrays;
/**
 * Created by Administrator on 2016/12/15.
 *  授权测试
 */
public class Aucation
{
    //角色授权
    @Test
    public void testAutrotion()
    {
        //创建securityManager工厂
        Factory<SecurityManager> securityManagerFactory=new IniSecurityManagerFactory("classpath:config/shrio-permission.ini");
        //创建securityManager
        SecurityManager securityManager=securityManagerFactory.getInstance();
        //将securityManager设置到系统运行环境，和spring整合之后，配置到spring的容器里面---一般单例
        SecurityUtils.setSecurityManager(securityManager);
        //创建subject
        Subject subject=SecurityUtils.getSubject();
        System.out.println( subject.getPrincipal());;
        //执行认证
        AuthenticationToken authenticationToken=new UsernamePasswordToken("zhangsan","123");
        try {
            subject.login(authenticationToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println("认证结果："+subject.isAuthenticated());
        //执行授权  ---基于角色的授权  或者基于资源的授权
        //基于角色的授权
        boolean isHasRole=  subject.hasRole("role12");
        boolean ishasAllRoles= subject.hasAllRoles(Arrays.asList("role1","role2"));
        System.out.println("是否有角色"+isHasRole);
        System.out.println("是否多个角色"+ishasAllRoles);//是否多个角色true
        //如果使用check方法进行授权，如果没有这个角色难么抛出异常
        //subject.checkRole("role13");//org.apache.shiro.authz.UnauthorizedException: Subject does not have role [role13]
        //基于资源的授权  --权限字符
        boolean isPermited=  subject.isPermitted("user:create");
        boolean isMorePermissions= subject.isPermittedAll("user:update","user:delete","user:create");
        System.out.println("是否具有资源权限："+isPermited);
        System.out.println("是否具有多个资源权限："+isMorePermissions);//是否具有多个资源权限：true
        subject.checkPermission("user:dd");//org.apache.shiro.authz.UnauthorizedException: Subject does not have permission [user:dd]
    }
}
