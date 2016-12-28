package DemoTesr;
import Demo.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by Administrator on 2016/12/28.
 */

public class test {

    public static void  main(String [] args) {
        /**
         *
         */
        ApplicationContext actx=new ClassPathXmlApplicationContext("classpath:Bean-genericity-di.xml");
        UserService userService=(UserService) actx.getBean("userService");
        userService.add();
    }
}
