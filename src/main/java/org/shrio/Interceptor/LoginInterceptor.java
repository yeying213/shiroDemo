package org.shrio.Interceptor;

import org.shrio.model.ActiveUser;
import org.shrio.util.ResourcesUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在进入controller方法之前执行
     // 使用场景：比如身份认证校验拦截，用户权限拦截，如果拦截不放行，controller方法不再执行
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        // 校验用户访问是否是公开资源地址(无需认证即可访问)
        List<String> open_urls = ResourcesUtil.gekeyList("i18n.anonymousURL");
        // 用户访问的url
        String url = request.getRequestURI();
        for (String open_url : open_urls) {
            if (url.indexOf(open_url) >= 0) {
                // 如果访问的是公开 地址则放行
                return true;
            }
        }

        // 校验用户身份是否认证通过
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        if (activeUser != null) {
            // 用户已经登陆认证，放行
            return true;
        }
        // 跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
                response);
        return false;
    }

    /**
     * // 进入controller方法返回视图之前
     // 使用场景：可以向ModelAndView中填充一些公用数据,比如：页面导航
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    /**
     * controller方法执行完成后
     // 使用场景：统一记录系统日志 ，完成执行性能监控。。
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

