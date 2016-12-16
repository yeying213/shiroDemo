package org.shrio.conventer;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/13.
 */
public class CustomDateConverter implements Converter<String, Date> {
    public Date convert(String source) {
        try {
            //进行日期转换
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
