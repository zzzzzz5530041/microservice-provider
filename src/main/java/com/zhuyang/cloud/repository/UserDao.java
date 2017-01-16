package com.zhuyang.cloud.repository; 

import com.zhuyang.cloud.entity.User; 

public interface UserDao { 
public User findById(long id); 
} 