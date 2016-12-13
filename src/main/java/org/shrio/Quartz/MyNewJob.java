package org.shrio.Quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MyNewJob implements StatefulJob {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Map dataMap=jobExecutionContext.getTrigger().getJobDataMap();
        String count= (String) dataMap.get("count");
        dataMap.put("count","30");//Trigger自身关联的DataMap,无论是有状态还是无状态任务， 更改了dataMap都
        // 不会被持久化，不会影响下次执行
    }
}
