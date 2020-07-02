package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Project;


public interface IprojectDao 
{
	//查找所有的项目信息，返回一个list
	abstract List<Project> findAllProject();
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	abstract List<Project> findProjectByleadId(String _leadId);	
				
	//插入新项目信息
	abstract boolean insertInfoToProject(Project p);
	
	//更新项目的负责人
	abstract boolean updateProjectchargeIdBypId(String _pId,String _chargeId);
	
	//更新项目的导游
	abstract boolean updateProjectleadIdBypId(String _pId,String _leadId);	
	
	//更新项目信息
	abstract boolean updateProject(Project p);
	
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态
	abstract boolean updateProject(String _pId,int _pflag);
	
	//跟团的话负责人分配导游和修改项目的状态
	abstract boolean updateProject(String _pId,String _leadId,int _pflag);
	
	//再次推出项目时，修改项目的状态，报名时间和截止时间
	abstract boolean updateProjectBypId(String _pId,String _beginning,String _ending,int _pflag);	
	
	//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
	abstract boolean deleteProject();	
}
