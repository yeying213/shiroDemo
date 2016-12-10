package org.shrio.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;
public class User {
    private Integer id;

    private String username;
    //可将形如yyyy-MM-dd类型的字符串映射到Date类型的birthday属性里面
    /**
     *  客户端请求的时候 可以birthday=“1993-04-10”类似传值完成绑定
     */
    @Pattern(regexp = "w{4,30}") //匹配4-30个字符，当数据校验出问题的时候，返回信息
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String sex;

    private String address;
    List<Orders> orders;//完成对订单的关联查询

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}