package org.shrio.Service;

import org.shrio.model.Items;
import org.shrio.vo.QueryItemsVo;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public interface ItemService {
    //商品查询列表
    public List<Items> findItemsList(QueryItemsVo queryVo)throws Exception;

    //根据id查询商品信息
    public Items findItemById(int id) throws Exception;

    //修改商品信息
    public void saveItem(Items items)throws Exception;
}
