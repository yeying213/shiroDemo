package org.shrio.vo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/8.
 */

/**
 * 用于 测试多视图处理的域对象
 */
@XmlRootElement
public class ShowDemo implements Serializable {
    private long userID;
    private String userName;
    private Date birth;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public long getUserID() {
        return userID;
    }
    public void setUserID(long userID) {
        this.userID = userID;
    }
}
