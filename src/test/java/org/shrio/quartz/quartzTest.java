package org.shrio.quartz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/13.
 */
public class quartzTest {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Quartz/newQuartz.xml");
        System.out.println("test  start");
        System.out.println("test   end");

    }
}
