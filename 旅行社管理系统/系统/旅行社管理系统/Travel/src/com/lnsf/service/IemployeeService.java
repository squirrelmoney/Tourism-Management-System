package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Employee;

public interface IemployeeService
{
	//查找所有的员工信息，返回一个list
	abstract List<Employee> AllEmployee();
		
	//根据员工号查找员工，返回员工信息
	abstract List<Employee> EmployeeByeId(String _eId);
	
	//插入新员工信息
	abstract boolean InsertEmployee();
	
	//当员工升职了，修改用户登录表的权限,修改员工的基本工资
	abstract boolean UpdateEmployeeTitleByeId(String _eId);
	
	//当升职后，删除原本的信息，更新新的员工号
	abstract boolean  reNewEmployeeTitleByeId(String _eId);
		
	//当员工修改电话号码，修改用户登录表的电话号码
	abstract boolean UpdateEmployeeTelByeId(String old_eTel);
	
	//删除员工信息
	abstract boolean DeleteEmployee(String _eId);
	
	//根据项目号查找有空的导游
	abstract List<String> findEmployeeByepId();
}
