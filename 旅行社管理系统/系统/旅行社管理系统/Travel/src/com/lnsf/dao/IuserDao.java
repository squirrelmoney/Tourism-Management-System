package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.User;

public interface IuserDao
{
	//查找所有的用户登录信息，返回一个list
	abstract List<User> findAllUser();
	
	//根据用户手机号和密码查找用户的权限
	abstract int login(String _uTel,String _uPassWord);
			
	//插入新用户登录信息
	public int insertInfoToUser(User u);
	
	//更新用户登录信息
	public int updateUser(User u,String _uTel);
	
	//更新用户登录权限
	public int updateUser1(User u);
	
	//删除用户登录信息同时删除用户信息表和预约表
	public int deleteUser(String _uTel);
}
