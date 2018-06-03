package com.demo.dao;

import com.demo.model.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * dao层接口
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {


}
