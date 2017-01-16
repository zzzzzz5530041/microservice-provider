package com.zhuyang.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhuyang.cloud.entity.User;
import com.zhuyang.cloud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return this.userService.findById(id);
	}

	@RequestMapping(value = "/service/all", method = RequestMethod.GET)
	public List<User> findAll() {
		return this.userService.getAllUsers();
	}

	@RequestMapping(value = "/instance-info", method = RequestMethod.GET)
	public ServiceInstance serviceUrl() {
		return discoveryClient.getLocalServiceInstance();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "200";
	}

}