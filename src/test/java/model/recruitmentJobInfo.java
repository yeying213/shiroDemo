package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/23.
 */
public class recruitmentJobInfo implements Serializable {
    private String address;
    private String date;
    private String time;
    private String company;
    private String notes;
    private String detailInfo;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getDetailInfo() {
        return detailInfo;
    }
    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }
    @Override
    public String toString() {
        return "recruitmentJobInfo{" +
                "address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", company='" + company + '\'' +
                ", notes='" + notes + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                '}';
    }
}
