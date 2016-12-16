package org.shrio.Exception;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by Administrator on 2016/12/10.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object handler, Exception ex) {
        ModelAndView modelAndView=null;
        ModelMap modelMap=new ModelMap();
        String message=null;
        CustomException customException = null;
        //如果ex是系统 自定义的异常，直接取出异常信息
        if(ex instanceof CustomException){
            customException = (CustomException)ex;
        }else{
            //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
            customException = new CustomException("未知错误");
        }
        //错误 信息
        message=customException.getData();
        modelMap.addAttribute("message",message);
        return new ModelAndView("exception",modelMap);
    }
}
