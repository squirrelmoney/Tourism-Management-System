package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Salary;

public interface IsalaryService 
{

	   //�������й�����Ϣ
	  abstract List<Salary>  AllSalary();
      
  //����Ա���Ų��ҹ���
    abstract List<Salary> SalaryBycId(String _seId);
    
    //�����¹���
    abstract int insertSalary(String _seId);
    
    //����
    abstract int updateSalary(Salary s);
    
     //���½�����Ϊ����������Σ�
	   public int updateReward(Salary s);
    
    //ɾ��
    abstract boolean deleteSalary(String _seId);
}
