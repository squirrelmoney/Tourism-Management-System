package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Project;

public interface IprojectService 
{
	//查找所有的项目信息，返回一个list
	abstract List<Project> AllProject();
	
	//根据类别号查找项目，返回所有相关的项目信息
	abstract List<Project> ProjectBypcId(String _pcId);	
	
	//根据目的地查找项目，返回所有相关的项目信息
	abstract List<Project> ProjectByDestination(String _destination);
	
	//根据项目号查找该项目的截止日期
	abstract String ProjectEndingBypId(String _pId);
	
	//根据项目号查找该项目的报团最少人数
	abstract int ProjectMinBypId(String _pId);
	
	//根据项目号查找该项目的报团最多人数
	abstract int ProjectMaxBypId(String _pId);
	
	//根据负责人ID号查找项目，返回所有相关的项目信息
	abstract List<Project> ProjectBychargeId(String _chargeId);
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	abstract List<Project> ProjectByleadId(String _leadId);	
				
	//插入新项目信息,要求项目类别号和负责人ID号事先存在(导游ID是NULL)  flag=0--插入失败  flag=1--插入成功  
	//flag=2--插入失败，项目类别号不存在  flag=3--插入失败，该ID号不是员工或者员工ID号的职称不是负责人
	abstract int InsertProject(Project p);
	
	//更新项目的负责人,要求项目和负责人ID号都事先存在   flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在  flag=3--更新失败，该ID号不是员工或者员工ID号的职称不是负责人
	abstract int UpdateProjectchargeIdBypId(String _pId,String _chargeId);
	
	
	//更新项目的导游，要求项目事先存在和用户信息表的状态不能为未过期(1)  flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在   flag=3--更新失败，该员工ID号无法做该项目的导游
	abstract int UpdateProjectleadIdBypId(String _pId,String _leadId);	
	
	
	//更新项目信息，要求项目类别号，项目号，员工的ID号是负责人和导游ID号(导游不能正在带领某个项目)都要事先存在
	//flag=0--更新失败  flag=1--更新成功  flag=2--更新失败，项目类别不存在 
	//flag=3--更新失败，项目不存在  flag=4--更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人 
	//flag=5--更新失败，ID号不是员工的ID号或者该员工的ID号不是导游   flag=6--更新失败，导游正在带领某个项目，不能更新该导游的 	
	abstract int updateProject(Project p);
	
	
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态	flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在
	abstract int UpdateProject(String _pId,int _pflag);
	
	
	//跟团的话负责人分配导游和修改项目的状态   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	//flag=3--更新失败，ID号不是员工的ID号或者该员工的ID号不是导游   flag=4--更新失败，导游正在带领某个项目，不能更新该导游的  
	abstract int UpdateProject(String _pId,String _leadId,int _pflag);
	
	//再次推出项目时，修改项目的状态，报名时间和截止时间   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	abstract int UpdateProjectBypId(String _pId,String _beginning,String _ending,int _pflag);	
	
	//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
	abstract boolean DeleteProject();
}
