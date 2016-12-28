package service;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by Administrator on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/resposity.xml","classpath:spring/spring-universial.xml"})
public class generalAutowired {
    @Autowired
    private UserService userService;
    @Autowired
    private MyUserService myUserService;
    @Test
    public void test(){

        System.out.println("BEFIN  ");
        myUserService.templteMethod(new User());
        System.out.println("sssss");

        System.out.println("userServie begin work.....,");
        User user1=new User();
        user1.setName("aaa");
        user1.setId(2l);
        userService.add(user1);
        System.out.println("userServie end work.....,");
    }
}
