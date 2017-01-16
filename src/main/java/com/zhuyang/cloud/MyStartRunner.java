package com.zhuyang.cloud; 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication; 
import org.springframework.core.annotation.Order; 
import org.springframework.stereotype.Component; 

@Component 
@Order(value=1) //if we have mutiple command runner, set execution order 
public class MyStartRunner implements CommandLineRunner { 

/** 
* arg0 is coming from spring main method eg: 
* SpringApplication.run(ProviderApp.class, new String[]{"hello","zhuyang"}); 
*/ 
public void run(String... arg0) throws Exception { 
System.out.println("spring boot run....params="+arg0[0]+","+arg0[1]); 
} 

} 