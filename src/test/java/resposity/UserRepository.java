package resposity;

import model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/28.
 */
@Repository
public class UserRepository extends BaseRepository<User> {
    @Override
    public void save(User user) {

        System.out.println("i am UserRepository ,i save user");

        super.save(user);
    }
}
