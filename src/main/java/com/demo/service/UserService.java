package com.demo.service;

import com.demo.model.User;

/**
 * 服务接口
 */
public interface UserService {

	/**
	 * 查询手机号码是否可以注册
	 * @param phone
	 * @return
	 */
	public boolean checkPhoneUnique(String phone);
	
	/**
	 * 注册新用户
	 * @param phone
	 * @param pwd
	 * @param ip
	 * @return 主键id
	 */
	public Integer register(String phone, String pwd, String ip);
	
	/**
	 * 登陆
	 * @param phone
	 * @param pwd
	 * @param from
	 * @return token / null
	 */
	public String login(String phone, String pwd, String from);

	public User getUserById(int id);
	
}
