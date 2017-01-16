package com.zhuyang.cloud.repository; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.jdbc.core.BeanPropertyRowMapper; 
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.jdbc.core.RowMapper; 
import org.springframework.stereotype.Repository; 

import com.zhuyang.cloud.entity.User; 

@Repository 
public class UserDaoImpl implements UserDao { 
@Autowired 
private JdbcTemplate jdbcTemplate; 

@Override 
public User findById(long id) { 
String sql = "select * from user where id=?"; 
RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class); 
return jdbcTemplate.queryForObject(sql, rowMapper, id); 
} 

} 