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

    @Test
    public void selectByExample() throws Exception {

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