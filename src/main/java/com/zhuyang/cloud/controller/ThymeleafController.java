package com.zhuyang.cloud.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	@RequestMapping(value = "/hello")
	public String hello(Map map) {
		map.put("hello", "hello world");
		return "/hello";
	}
}