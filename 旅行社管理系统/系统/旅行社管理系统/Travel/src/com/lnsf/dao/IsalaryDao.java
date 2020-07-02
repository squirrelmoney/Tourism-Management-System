package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Salary;


public interface IsalaryDao 
{
	//�������е�Ա��������Ϣ������һ��list
	abstract List<Salary> findAllSalary();
	
	//����Ա���Ų��ҹ��ʣ�����Ա��������Ϣ
	abstract List<Salary> findSalaryBycId(String _seId);
		
	//������Ա��������Ϣ��Ҫ��Ա���������ȴ���
	abstract int insertInfoToSalary(Salary s);
	
	//����Ա��������Ϣ
	abstract int updateSalary(Salary s);
	
	//ɾ��Ա��������Ϣ
	abstract boolean deleteSalary(String _seId);
}
