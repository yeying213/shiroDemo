package service;

import model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/28.
 */
@Service
public class MyUserService extends MyBaseService<User> {
    @Override
    public void templteMethod(User user) {
        user.setId(3l);
        user.setName("ssssswoshi  ...");
        //add(user);
        System.out.println(user);
    }
}
