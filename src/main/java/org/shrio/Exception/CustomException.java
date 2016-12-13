package org.shrio.Exception;

import org.shrio.dto.Feedback;

/**
 * Created by Administrator on 2016/12/10.
 * 系统自定义的异常类型，实际开发中可能要定义多种异常类型<
 */
public class CustomException extends Exception {
  private String data;

   public CustomException(String data){
       super();
       this.data=data;

   }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
