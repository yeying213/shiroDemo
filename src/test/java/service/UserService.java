package service;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resposity.BaseRepository;
import resposity.UserRepository;
/**
 * Created by Administrator on 2016/12/28.
 */
@Service
public class UserService extends BaseService<User>{
    @Autowired
    private  UserRepository userRepository;

    @Override
    public void setRepository(BaseRepository repository) {
        setRepository(userRepository);
    }
   //复写通用的模板方法
    @Override
    public void add(User user) {
        userRepository.save(user);
        super.add(user);
    }
}
