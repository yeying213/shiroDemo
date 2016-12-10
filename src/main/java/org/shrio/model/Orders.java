package org.shrio.model;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    private Integer userId;

    private String number;

    private Date createtime;

    private String note;
    private User user;//实现订单到用户的关联查询  一对一  如果碰到一对多 使用List
    private List<Orderdetail> oderdetails;//使用collection完成对resultMap的
    //一对多映射查询


    public List<Orderdetail> getOderdetails() {
        return oderdetails;
    }

    public void setOderdetails(List<Orderdetail> oderdetails) {
        this.oderdetails = oderdetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}