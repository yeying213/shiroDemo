package resposity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/28.
 */
public abstract class BaseRepository<M extends Serializable> {
    public void save(M m) {
        System.out.println("=====repository save:" + m);
    }
}
