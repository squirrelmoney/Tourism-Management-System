package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.dao.impl.ProjectHistoryDaoImpl;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;


public class ProjectHistoryController
{
	ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	/*
	 * 用户的权限
	 */

	
	/*
	 * 导游的权限
	 */	
	//查找所有的历史记录信息，返回一个list
	public List<ProjectHistory> DfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}	

	
	/*
	 * 负责人的权限
	 */
	//查找所有的历史记录信息，返回一个list
	public List<ProjectHistory> FfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}	
	
	//插入新历史记录信息或者更新更新历史记录信息的次数，要求项目事先存在  
	//flag=0--操作失败    flag=1--操作成功   
	//flag=2--操作失败，项目表中没有该项目，则无法插入到历史记录表中
	public int FhandleProjectHistory()
	{
		System.out.print("请输入项目号：");
		String hpId=sc.next();
		ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		for(ProjectHistory ph:l)
		{
			if(ph.getHpId().equals(hpId))
			{
				int phNumber=ph.getPhNumber()+1;
				ProjectHistory ph1=new ProjectHistory(hpId, phNumber);
				int flag=projectHistoryService.UpdateProjectHistory(ph1);
				return flag;
			}
		}
		int phNumber=1;
		ProjectHistory ph2=new ProjectHistory(hpId, phNumber);
		int flag=projectHistoryService.InsertProjectHistory(ph2);
		return flag;				
	}	
	
	/*
	 * 经理的权限
	 */	
	
	//查找所有的历史记录信息，返回一个list
	public List<ProjectHistory> MfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}
	
	//插入新历史记录信息或者更新更新历史记录信息的次数，要求项目事先存在  
	//flag=0--操作失败    flag=1--操作成功   
	//flag=2--操作失败，项目表中没有该项目，则无法插入到历史记录表中
	public int MhandleProjectHistory(String _hpId)
	{
		ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		for(ProjectHistory ph:l)
		{
			if(ph.getHpId().equals(_hpId))
			{
				int phNumber=ph.getPhNumber()+1;
				ProjectHistory ph1=new ProjectHistory(_hpId, phNumber);
				int flag=projectHistoryService.UpdateProjectHistory(ph1);
				return flag;
			}
		}
		int phNumber=1;
		ProjectHistory ph2=new ProjectHistory(_hpId, phNumber);
		int flag=projectHistoryService.InsertProjectHistory(ph2);
		return flag;				
	}	
}
