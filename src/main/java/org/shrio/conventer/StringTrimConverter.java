package org.shrio.conventer;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2016/12/13.
 */
public class StringTrimConverter implements Converter<String,String> {
    public String convert(String source) {
        try {
            //去掉字符串两边空格，如果去除后为空设置为null
            if(source!=null){
                source = source.trim();
                if(source.equals("")){
                    return null;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return source;
    }
}
