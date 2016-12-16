package org.shrio.conventer;

import org.shrio.model.User;
import org.shrio.vo.ShowDemo;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2016/12/13.
 *
 *  将字符串转换成为user对象
 *  类似：
 *  <useranme>:<address>:<sex>
 */
public class StringToUserConventer implements Converter<String,User> {
    public User convert(String s) {
        User user=new User();
        if(s!=null){
            String [] items=s.split(":");
            user.setUsername(items[0]);
            user.setAddress(items[1]);
            user.setSex(items[2]);
        }
        return user;
    }
}
