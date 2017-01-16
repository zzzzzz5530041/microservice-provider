package com.zhuyang.cloud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
//		System.out.println(
//				"afterCompletion()... request=" + req.getRequestURI() + ", this method will be call after render page");

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
//		System.out.println("postHandle()... request=" + req.getRequestURI()
//				+ ", this method will be call before render page ,after controller");

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2) throws Exception {
//		System.out.println("preHandle()... request=" + req.getRequestURI());
		return true;
	}

}