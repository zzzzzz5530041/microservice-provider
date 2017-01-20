package com.zhuyang.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuyang.cloud.config.SelfDefinedYML;
import com.zhuyang.cloud.entity.User;
import com.zhuyang.cloud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private SelfDefinedYML selfDefinedYML;   //test sefl-defined yml
	
	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return this.userService.findById(id);
	}

	@RequestMapping(value = "/service/all", method = RequestMethod.GET)
	public List<User> findAll() {
		try {
			ObjectMapper mapper =new ObjectMapper();
			System.out.println("Self Defined YML,  SimpleProp="+mapper.writeValueAsString(selfDefinedYML.getSimpleProp())  );
			System.out.println("Self Defined YML,  ArrayProps="+mapper.writeValueAsString(selfDefinedYML.getArrayProps()));
			System.out.println("Self Defined YML,  ListProp1="+mapper.writeValueAsString(selfDefinedYML.getListProp1()));
			System.out.println("Self Defined YML,  MapProps="+mapper.writeValueAsString(selfDefinedYML.getMapProps()));
			return this.userService.getAllUsers();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/instance-info", method = RequestMethod.GET)
	public ServiceInstance serviceUrl() {
		return discoveryClient.getLocalServiceInstance();
	}
	/**
	 * 
	 * 
	 *  request data:
	 *  {
			"name":"xijinping",
			"username":"HJT",
			"balance":250,
			"age":60
		 }
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/service/add",method=RequestMethod.POST)
	public User addUser(@RequestBody User user){
		return this.userService.addUser(user);
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "200";
	}

}