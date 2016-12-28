package service;

import org.springframework.beans.factory.annotation.Autowired;
import resposity.BaseRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/28.
 */
public abstract class MyBaseService<M extends Serializable> {
    @Autowired
    protected BaseRepository<M> baseRepository;
    public void templteMethod(M m){
        baseRepository.save(m);
    }
}
