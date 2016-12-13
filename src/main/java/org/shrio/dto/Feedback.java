package org.shrio.dto;

/**
 * Created by Administrator on 2016/12/10.
 */
public class Feedback<T> {
    private T data;

    private boolean flag;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Feedback(T data, boolean flag) {
        this.data = data;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
