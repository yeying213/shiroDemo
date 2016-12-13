package org.shrio.Quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MyJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Map dataMap=jobExecutionContext.getMergedJobDataMap();//获取JobDetail关联的JobDataMap
        String size= (String) dataMap.get("size");
        //ApplicationContext context= (ApplicationContext) dataMap.get("applicationContext");
        System.out.println("size: "+size);
        dataMap.put("size",size+"0");//对Jobdetial所做的更改是否会持久，取决于任务类型
        //do otherthing


    }
}
