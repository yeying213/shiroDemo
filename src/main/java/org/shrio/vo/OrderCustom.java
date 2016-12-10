package org.shrio.vo;

import org.shrio.model.Items;
import org.shrio.model.Orders;

/**
 * Created by Administrator on 2016/12/7.
 *  订单信息 关联用户信息   订单--用户：1对1
 *  订单扩展对象用于完成订单和用户的关联查询
 *  另外，注意在扩展时候把握住，谁信息量大就继承谁
 */
public class OrderCustom extends Orders {
   //补充用户相关的信息 使用restType完成映射
    private String username;
    private String sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
