package org.shrio.mapper;

import org.shrio.model.Items;
import org.shrio.vo.QueryItemsVo;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public interface ItemsMapperCustom {
    //商品列表
    public List<Items> findItemsList(QueryItemsVo queryItemsVo) throws Exception;

    //根据id查询商品信息
    public Items findItemById(int id) throws Exception;
}
