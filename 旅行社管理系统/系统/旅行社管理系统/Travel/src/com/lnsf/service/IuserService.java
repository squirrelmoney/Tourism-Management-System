package com.lnsf.service;

import java.util.List;

import com.lnsf.model.User;

public interface IuserService 
{
	//���������û���¼ѶϢ������list
	abstract  List<User> AllUser();
	
	//���ݵ绰������������Ȩ�ޣ�����һ��list
	abstract List<User> Login(String _uTel,String _uPassWord);
	
	//�������û���¼��Ϣ
	abstract int InsertUser(String _uTel,String _uPassWord);
	
	//�����û���¼��Ϣ
	abstract int updateUser(User u,int n);
	
	//�û��޸ĵ绰��
	abstract int updateUser1(User u);
	
	//����ȷ��
	abstract boolean password(String _uPassword,String _uTel);
	
	//ɾ��
	abstract int deleteUser(String _uTel);
}
