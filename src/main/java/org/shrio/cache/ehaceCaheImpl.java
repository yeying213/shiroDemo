package org.shrio.cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by Administrator on 2016/12/17.
 *
 * 实际上 mybaits-echcahe整合包里面 提供了对mybaits的cache的默认实现
 */
public class ehaceCaheImpl implements Cache {
    public String getId() {
        return null;
    }

    public void putObject(Object o, Object o1) {

    }

    public Object getObject(Object o) {
        return null;
    }

    public Object removeObject(Object o) {
        return null;
    }

    public void clear() {

    }

    public int getSize() {
        return 0;
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
