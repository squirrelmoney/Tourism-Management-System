package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Employee;


public interface IemployeeDao 
{
	//查找所有的员工信息，返回一个list
	abstract List<Employee> findAllEmployee();
	
	//插入新员工信息
	abstract boolean insertInfoToEmployee(Employee e);
	
	//当员工升职了，修改用户登录表的权限,修改员工的基本工资
	abstract boolean updateEmployeeTitleByeId(String _eId,String _eTitle);
	
	//当员工修改电话号码
	abstract boolean updateEmployee(Employee e);
	
	//删除员工信息
	abstract boolean deleteEmployee(String _eId);
	
	//根据项目号查找有空的导游
	abstract List<String> findEmployeeByepId();
}
