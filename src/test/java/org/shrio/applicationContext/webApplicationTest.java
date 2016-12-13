package org.shrio.applicationContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shrio.util.ResourcePathExposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2016/12/11.
 */

public class webApplicationTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public static void main(String []args){
        WebApplicationContext applicationContext=
                (WebApplicationContext) new ClassPathXmlApplicationContext("Spring-web.xml");
//        ResourcePathExposer resourcePathResolver= (ResourcePathExposer) applicationContext.getBean("rpe");
//        System.out.println(resourcePathResolver.getResourceRoot());
    }

}
