package com.lnsf.service;

import java.util.List;

import com.lnsf.model.User;

public interface IuserService 
{
	//查找所有用户登录讯息，返回list
	abstract  List<User> AllUser();
	
	//根据电话号码和密码查找权限，返回一个list
	abstract List<User> Login(String _uTel,String _uPassWord);
	
	//插入新用户登录信息
	abstract int InsertUser(String _uTel,String _uPassWord);
	
	//更新用户登录信息
	abstract int updateUser(User u,int n);
	
	//用户修改电话号
	abstract int updateUser1(User u);
	
	//密码确认
	abstract boolean password(String _uPassword,String _uTel);
	
	//删除
	abstract int deleteUser(String _uTel);
}
