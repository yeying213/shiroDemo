package org.shrio.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.shrio.Exception.CustomException;
import org.shrio.Service.SysService;
import org.shrio.model.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/13.
 */
@Controller
public class LoginController {

    @Autowired
    private SysService sysService;

    //用户登陆提交方法
    /**
     *
     * <p>Title: login</p>
     * <p>Description: </p>
     * @param session
     * @param randomcode 输入的验证码
     * @param usercode 用户账号
     * @param password 用户密码
     * @return
     * @throws Exception
     */
    @RequestMapping("/login1")
    public String login1(HttpSession session, String randomcode,String usercode,String password)throws Exception{
        //校验验证码，防止恶性攻击
        //从session获取正确验证码
        String validateCode = (String) session.getAttribute("validateCode");

        //输入的验证和session中的验证进行对比
        if(!randomcode.equals(validateCode)){
            //抛出异常
            throw new CustomException("验证码输入错误");
        }
        //调用sysservice验证
        ActiveUser activeUser= sysService.authenticat(usercode,password);

        //调用service校验用户账号和密码的正确性
        // ActiveUser activeUser = sysService.authenticat(usercode, password);

        //如果service校验通过，将用户身份记录到session
        session.setAttribute("activeUser", activeUser);
        //重定向到商品查询页面
        return "redirect:/first";
    }

    /**
     * 登录提交地址和spring里面的loginUrl一致
     * @param request  登录失败 封装异常信息
     *
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request)throws Exception{
       //换成shiro进行认证  shiroLoginFailure就是shiro异常的限定名
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                throw new CustomException("用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
                throw new CustomException("验证码错误 ");
            }else {
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }

        //登录失败 返回login   ---这个方法不处理登录成功shiro认证成功
        //会自动跳转到上一个路径（刚才访问的页面）
        return "login";
    }
    //使用shiro 完成退出 配置退出url
//
//    //用户退出
//    @RequestMapping("/logout")
//    public String logout(HttpSession session)throws Exception{
//
//        //session失效
//        session.invalidate();
//        //重定向登录
//        return "redirect:/first";
//    }
}
