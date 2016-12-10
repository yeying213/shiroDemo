package org.shrio.controller;

import org.shrio.model.User;
import org.shrio.vo.ShowDemo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */
@Controller
public class MutiViewTestController {
    @RequestMapping(value="/demo/{userid}")
    public String queryUser(@PathVariable("userid") long userID,ModelMap model)
    {
        ShowDemo u = new ShowDemo();
        u.setUserID(userID);
        u.setUserName("zhaoyang");
        model.addAttribute("User", u);

        return "demo";
    }

    /**
     * 将请求报文转换成字符串，保存到requstBoby里面
     *  分析：该方法标注了一个@RequestBody注解
     *  SpringMVC将根据RequestBody的类型查找匹配的消息转换器，由于
     *  StringHttpMessageConveter的泛型信息是String,
     *  所以StringHttpMessageConveter会被选中，它将请求信息进行转换并
     *  将结果绑定到RequestBody
     *
     * @param requstBoby
     * @return
     */
    @RequestMapping("/handle41")
    public String handle41(@RequestBody String requstBoby){
        System.out.println(requstBoby);
        return "success";
    }
    /**
     *  读取一张图片返回给客户端显示
     * @param imageID
     * @return
     * handle42（）方法拥有一个 @ResponseBody注解
     * ，由于方法返回值类型为byte[].SpringMVC将根据类型查找匹配
     * ByteHttpMessageConvente对返回值进行处理，将图片数据输出到客户端。
     */
    @ResponseBody
    @RequestMapping("/handle42/{imageID}")
    public void handle42(@PathVariable("imageID") String imageID,HttpServletResponse httpServletResponse ) throws IOException {
        System.out.println("load iamge of"+imageID);
        Resource resource=new ClassPathResource("/images/wo.jpg");
        byte [] fileData= FileCopyUtils.copyToByteArray(resource.getInputStream());
        httpServletResponse.getOutputStream().write(fileData);
//        return fileData;
    }
    /**
     *  和@ResponseBody和RequstBoby类似
     *  HttpEnity<?>不但可以访问请求和响应里面的报文数据，
     *  还可以访问请求和响应报文头的数据，SpringMVC根据HttpEnity<?>
     *      的泛型类型查找对应的HttpMessageConventer
     *  </?>
     *  下面会调用StringHttpMessageConverntor完成转换
     */
    @RequestMapping("/handle43")
    public String handle3(HttpEntity<String> httpEntity){
        long contentLen=httpEntity.getHeaders().getContentLength();
        System.out.println(httpEntity.getBody());
        return "success";
    }

    /**
     * ResponseEntity是HttpEnity的子类，
     * 在方法里面创建HttpEnity<byte[]>对象并且返回
     * ，ByteArrayHttpMessageConbenter将会负责将其写入到响应流
     * </>
     *
     * @param imageId
     * @return
     */
    @RequestMapping("/handle44/{imageId}")
    public ResponseEntity<byte[]> handle4(@PathVariable("imageId") String imageId) throws IOException {
        Resource resource=new ClassPathResource("/images/wo.jpg");
        byte [] fileData= FileCopyUtils.copyToByteArray(resource.getInputStream());
        ResponseEntity<byte []> responseEntity=new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
        return responseEntity;
    }
    /**
     *  总结：当处理器处理@RequestBoby/ResponseBody 或者HttpEnity<T>
     *      ResponseEntity<T>时候，SpringMVC才使用注册的HttpMessageConventer对请求响应
     *      进行处理</>
     *      1.先根据请求头或者响应头的accept属性选择好对应的匹配的消息转化器HttpMessaeConventer
     *      2.然后根据参数类型或者泛型类型过滤得到匹配的HttpMessaeConventer
     *      3.如果找不到会报错
     *
     *
     *      另外对于XML和Json格式的数据，SpringMVC也提供了相应的处理器
     *      因此只要在Spring Web容器中为AnnationMethodHandlerAdapter装配好
     *      响应的处理XML、JSON的HttpMessageConventer，并在交互中指出MIMEl类型，
     *      SpringMVC就可以使得服务器端的处理方法和客户端透明的通过XML或者Json来进行通信
     *
     *      根据请求头的ContenType和accept来约定
     *      ContenType：约定客户端的报文内容
     *      accept：指定MIME类型
     *      </>
     *
     */
    @RequestMapping(value = "handle51",headers = {"Accept:application/xml;charset=utf-8;" +
            "Conten-Type:application/xml"})
    public ResponseEntity<User> handle51(HttpEntity<User> requestEnity){
        User user=requestEnity.getBody();
        user.setUsername("hhaha");
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
    @RequestMapping(value="/test/json",
            produces={"application/json;charset=utf-8","application/xml"})
    @ResponseBody
    public   ShowDemo testJson(){
        ShowDemo showDemo=new ShowDemo();
        showDemo.setBirth(new Date());
        showDemo.setUserName("aaaa");
        showDemo.setUserID(100l);
        return showDemo;
    }
    @RequestMapping("/validatiorTest")
    public String validatiorTest(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/user/register3";
        }
        else {
            return "/user/showUsers";
        }
    }
    @RequestMapping(value = "/showUserListByFtl")
    public String showUserByFreeMaker(ModelMap modelMap){
        List<ShowDemo> showDemos=new ArrayList<ShowDemo>();
        ShowDemo d1=new ShowDemo();
        d1.setUserName("aaa");
        d1.setBirth(new Date());
        ShowDemo d2=new ShowDemo();
        d2.setUserName("bbb");
        d2.setBirth(new Date());
        ShowDemo d3=new ShowDemo();
        d3.setUserName("ccc");
        d3.setBirth(new Date());
        showDemos.add(d1);
        showDemos.add(d2);
        showDemos.add(d3);
        modelMap.addAttribute(showDemos);
        return "userListftl";
    }
}
