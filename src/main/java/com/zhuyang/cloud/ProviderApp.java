package com.zhuyang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.zhuyang.cloud.config.SelfDefinedYML;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan // servlet filter listener 可以通过 @webservlet @webfilter
						// @weblistener自动注册
@ComponentScan(basePackages = { "com.zhuyang.cloud", "com.zhuyang.cloud" }) // self-define pkg scan
																			 
@EnableConfigurationProperties({SelfDefinedYML.class})																 
public class ProviderApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, new String[] { "hello", "zhuyang" });
	}
}