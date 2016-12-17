package org.shrio.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shrio.model.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring/spring-dao.xml")
public class ItemsMapperTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemsMapper itemsMapper;
    @Test
    public void deleteByPrimaryKey() throws Exception {

    }
    @Test
    public void insert() throws Exception {
        Items items=new Items();
        items.setName("wowoowce");
        items.setPrice(12.05f);
        items.setCreatetime(new Date());
        itemsMapper.insert(items);
    }

    /**
     *
     * 整合ehcahe后的测试
     * 第一次查询org.shrio.model.Items@11b8846
     DEBUG [main] - Creating a new SqlSession
     DEBUG [main] - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@8fc8f4] was not registered for synchronization because synchronization is not active
     DEBUG [main] - Cache Hit Ratio [org.shrio.mapper.ItemsMapper]: 0.5
     DEBUG [main] - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@8fc8f4]
     第二次查询org.shrio.model.Items@11b8846
     DEBUG [main] - Creating a new SqlSession
     DEBUG [main] - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@380c5a] was not registered for synchronization because synchronization is not active
     DEBUG [main] - Cache Hit Ratio [org.shrio.mapper.ItemsMapper]: 0.6666666666666666
     DEBUG [main] - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@380c5a]
     第三次查询org.shrio.model.Items@11b8846
     * @throws Exception
     */
    @Test
    public void selectByExample() throws Exception {
        Items items=   itemsMapper.selectByPrimaryKey(1);
        System.out.println("第一次查询"+items);
        Items items1=   itemsMapper.selectByPrimaryKey(1);
        System.out.println("第二次查询"+items1);
        Items items2=   itemsMapper.selectByPrimaryKey(1);
        System.out.println("第三次查询"+items2);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void updateByExampleSelective() throws Exception {

    }

    @Test
    public void updateByExample() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}