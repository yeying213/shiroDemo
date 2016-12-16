package org.shrio.Service.Impl;
import org.shrio.Service.ItemService;
import org.shrio.mapper.ItemsMapper;
import org.shrio.mapper.ItemsMapperCustom;
import org.shrio.model.Items;
import org.shrio.vo.QueryItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapperCustom itemsMapperCustom;
    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> findItemsList(QueryItemsVo queryVo) throws Exception {
        //查询商品信息
        return itemsMapperCustom.findItemsList(queryVo);
    }

    public Items findItemById(int id) throws Exception {
        return itemsMapperCustom.findItemById(id);
    }

    public void saveItem(Items items) throws Exception {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
