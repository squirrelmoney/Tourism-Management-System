package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Salary;

public interface IsalaryService 
{

	   //查找所有工资信息
	  abstract List<Salary>  AllSalary();
      
  //根据员工号查找工资
    abstract List<Salary> SalaryBycId(String _seId);
    
    //插入新工资
    abstract int insertSalary(String _seId);
    
    //更新
    abstract int updateSalary(Salary s);
    
     //更新奖金（因为带领队伍旅游）
	   public int updateReward(Salary s);
    
    //删除
    abstract boolean deleteSalary(String _seId);
}
