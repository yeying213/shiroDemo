package org.shrio.util;
import org.springframework.web.context.ServletContextAware;
import javax.servlet.ServletContext;
/**
 * Created by Administrator on 2016/12/11.
 *
 *   实现了ServletContextAware接口，因此Spring在初始化该bean的时候，会将
 *   ServletContext的引用注入进来
 */

public class ResourcePathExposer implements ServletContextAware {
    private ServletContext servletContext;
    private String resourceRoot;
    public void init(){
        String version="1.2.1";//实际应用中可以在外部属性配置文件里面或者数据库保存应用的
        //发布版本号，在此获取之，此处仅仅是提供一个模拟值，
        resourceRoot="/resources_"+version;//将资源的逻辑路径加上发布的版本号
        //将资源的逻辑路径暴漏在ServletContext的属性列表中

        getServletContext().setAttribute("resourceRoot",getServletContext().getContextPath()+resourceRoot);
        System.out.println(getResourceRoot()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
    public String getResourceRoot() {
        return resourceRoot;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }
}
