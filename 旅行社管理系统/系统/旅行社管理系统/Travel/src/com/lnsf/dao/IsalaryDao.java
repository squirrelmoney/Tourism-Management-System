package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Salary;


public interface IsalaryDao 
{
	//查找所有的员工工资信息，返回一个list
	abstract List<Salary> findAllSalary();
	
	//根据员工号查找工资，返回员工工资信息
	abstract List<Salary> findSalaryBycId(String _seId);
		
	//插入新员工工资信息，要求员工工号事先存在
	abstract int insertInfoToSalary(Salary s);
	
	//更新员工工资信息
	abstract int updateSalary(Salary s);
	
	//删除员工工资信息
	abstract boolean deleteSalary(String _seId);
}
