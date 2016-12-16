package org.shrio.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
/**
 * Created by Administrator on 2016/12/9.
 */
@ContextConfiguration(locations = "classpath:Spring-web.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MutiViewTestControllerTest {
    @Test
    public void handle41() throws Exception {
        RestTemplate restTemplate=new RestTemplate();
        MultiValueMap<String,String> form=new LinkedMultiValueMap<String, String>();
        form.add("userName","tom");
        form.add("password","123456");
        form.add("age","45");
        restTemplate.postForLocation("http://localhost:8081/shiroDemo/handle41",form);
    }
    @Test
    public void handle42() throws Exception {

    }
}