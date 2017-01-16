package com.zhuyang.cloud; 

import org.springframework.context.annotation.Configuration; 
import org.springframework.scheduling.annotation.EnableScheduling; 
import org.springframework.scheduling.annotation.Scheduled; 

@Configuration 
@EnableScheduling 
public class SchedulConfig { 
@Scheduled(cron = "0/20 * * * * ?") 
public void scheduler() { 
System.out.println("SchedulConfig........"); 
} 
} 