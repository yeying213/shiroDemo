package org.shrio.util;

import org.springframework.util.DigestUtils;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Md5Utils {
    public  static String getMd5(String ll_id){
        String slat="&*yuwiyuw%%%3i4shefshejkefh?lsjkkshkshjsehfjdtjsafsjwjsdsffdg";
        String base=ll_id+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    public static void main(String [] args){
        System.out.println(Md5Utils.getMd5("123456"));
    }
}
