package com.itheima.bos.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailJob {
    public void run(){
        System.out.println("定时任务执行了。。。");
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
