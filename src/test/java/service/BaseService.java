package service;

import org.springframework.beans.factory.annotation.Autowired;
import resposity.BaseRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/28.
 */
public abstract class BaseService<M extends Serializable> {
    @Autowired
    private BaseRepository<M> repository;

    public void setRepository(BaseRepository<M> repository) {
        this.repository = repository;
    }

    public void add(M m){
        System.out.println("我是一个父类模板抽象 我不做具体的工作 ，具体的工作交给子类去完成实现");
        //System.out.println(repository+"   ...*****");
        //repository.save(m);
    }
}
