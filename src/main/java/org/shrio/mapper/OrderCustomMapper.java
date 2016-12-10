package org.shrio.mapper;

import org.shrio.model.Orders;
import org.shrio.model.User;
import org.shrio.vo.OrderCustom;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public interface OrderCustomMapper {
    public List<OrderCustom> quryOrdersCustomList();
    //使用resultMap完成订单关联用户信息的一对一映射查询
    public List<Orders> quryOrdersCustomListResultMap();
    public List<Orders> OdersAndOrderDetails();
    public List<User>  userAndOrdrsAndOrdetailsAndItems();
    //一对一查询 延迟加载
    public List<Orders>  queryUserAndOderDetailsLazyLoading();
}
