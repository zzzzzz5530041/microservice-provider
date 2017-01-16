package com.zhuyang.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhuyang.cloud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}