package org.shrio.Quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/13.
 *
 *
 */
public class MySecondJob extends QuartzJobBean {
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Map dataMap=jobExecutionContext.getMergedJobDataMap();
        System.out.println("data: map" +dataMap.values());
        for(Object o:dataMap.entrySet()){
            System.out.print(o.toString()+",");
        }
        //dataMap.put("cc","45");//改变dataMap
        System.out.println("wo shi  huai ren aaa  ni lai aaa");
    }
}
