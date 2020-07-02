package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.User;

public interface IuserDao
{
	//�������е��û���¼��Ϣ������һ��list
	abstract List<User> findAllUser();
	
	//�����û��ֻ��ź���������û���Ȩ��
	abstract int login(String _uTel,String _uPassWord);
			
	//�������û���¼��Ϣ
	public int insertInfoToUser(User u);
	
	//�����û���¼��Ϣ
	public int updateUser(User u,String _uTel);
	
	//�����û���¼Ȩ��
	public int updateUser1(User u);
	
	//ɾ���û���¼��Ϣͬʱɾ���û���Ϣ���ԤԼ��
	public int deleteUser(String _uTel);
}
