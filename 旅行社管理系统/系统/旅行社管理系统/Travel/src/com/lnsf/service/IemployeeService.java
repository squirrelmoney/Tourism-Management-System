package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Employee;

public interface IemployeeService
{
	//�������е�Ա����Ϣ������һ��list
	abstract List<Employee> AllEmployee();
		
	//����Ա���Ų���Ա��������Ա����Ϣ
	abstract List<Employee> EmployeeByeId(String _eId);
	
	//������Ա����Ϣ
	abstract boolean InsertEmployee();
	
	//��Ա����ְ�ˣ��޸��û���¼���Ȩ��,�޸�Ա���Ļ�������
	abstract boolean UpdateEmployeeTitleByeId(String _eId);
	
	//����ְ��ɾ��ԭ������Ϣ�������µ�Ա����
	abstract boolean  reNewEmployeeTitleByeId(String _eId);
		
	//��Ա���޸ĵ绰���룬�޸��û���¼��ĵ绰����
	abstract boolean UpdateEmployeeTelByeId(String old_eTel);
	
	//ɾ��Ա����Ϣ
	abstract boolean DeleteEmployee(String _eId);
	
	//������Ŀ�Ų����пյĵ���
	abstract List<String> findEmployeeByepId();
}
