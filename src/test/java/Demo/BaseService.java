package Demo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/12/28.
 */
public class BaseService<T> {

    @Autowired     //    -----//这里告诉IOC容器自动装配有依赖关系的Bean
    protected BaseRepository baseRepository;//--------//这里是子类继承依赖关系
    public void add(){
        System.out.println("add..............");
        System.out.println(baseRepository);
    }
}
