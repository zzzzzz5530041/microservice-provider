package com.zhuyang.cloud.service; 

import java.util.List; 

import com.zhuyang.cloud.entity.User; 

public interface UserService { 
public List<User> getAllUsers(); 

public User findById(long id); 

public User addUser(User user); 
} 