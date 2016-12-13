package org.shrio.Quartz.job;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MyJob {

    public void work() {
        System.out.println("wo shi yi ge 任务 调度... hahha");
        System.out.println("date:" + new Date().toString());
    }
}