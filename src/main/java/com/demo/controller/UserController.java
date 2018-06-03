package com.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

/**
 * 用户登陆后相关业务controller
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public String xxx(){
		return JSON.toJSONString(userService.getUserById(1));
	}
}
