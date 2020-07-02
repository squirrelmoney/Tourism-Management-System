package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Employee;


public interface IemployeeDao 
{
	//�������е�Ա����Ϣ������һ��list
	abstract List<Employee> findAllEmployee();
	
	//������Ա����Ϣ
	abstract boolean insertInfoToEmployee(Employee e);
	
	//��Ա����ְ�ˣ��޸��û���¼���Ȩ��,�޸�Ա���Ļ�������
	abstract boolean updateEmployeeTitleByeId(String _eId,String _eTitle);
	
	//��Ա���޸ĵ绰����
	abstract boolean updateEmployee(Employee e);
	
	//ɾ��Ա����Ϣ
	abstract boolean deleteEmployee(String _eId);
	
	//������Ŀ�Ų����пյĵ���
	abstract List<String> findEmployeeByepId();
}
