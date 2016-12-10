package org.shrio.mapper;

import org.junit.Test;
import org.shrio.model.Orders;
import org.shrio.model.User;
import org.shrio.vo.OrderCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/7.
 */

public class OrderCustomMapperTest extends BaseMapperTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderCustomMapper orderCustomMapper;
    @Test
    public void quryOrdersCustomList() throws Exception {
    List<OrderCustom> orderCustoms=orderCustomMapper.quryOrdersCustomList();
        System.out.println("cccc");
    }
    @Test
    public void quryOrdersCustomListResultMap(){
        List<Orders> orderCustoms=orderCustomMapper.quryOrdersCustomListResultMap();
        System.out.println("ssss");
    }
    //OdersAndOrderDetails
    @Test
    public void quryOrdersDetailsListResultMap(){
        List<Orders> orderCustoms=orderCustomMapper.OdersAndOrderDetails();
        System.out.println("ssss");
    }
    //userAndOrdrsAndOrdetailsAndItems
    @Test
    public void quryuserAndOrdrsAndOrdetailsAndItems(){
        List<User> orderCustoms=orderCustomMapper.userAndOrdrsAndOrdetailsAndItems();
        System.out.println("ssss");
    }
    //queryUserAndOderDetailsLazyLoading
    @Test
    public void queryUserAndOderDetailsLazyLoading(){
        List<Orders> orderCustoms=orderCustomMapper.queryUserAndOderDetailsLazyLoading();
        //这里需要获取用户信息 进行延迟加载
        User user=orderCustoms.get(0).getUser();//要 发出sql
        System.out.println("ssss");
    }
}