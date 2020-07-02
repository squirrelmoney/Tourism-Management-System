package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.dao.impl.ProjectHistoryDaoImpl;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.service.IprojectHistoryService;

public class ProjectHistoryServiceImpl implements IprojectHistoryService
{
	//查找所有的历史记录信息，返回一个list
	public List<ProjectHistory> AllProjectHistory()
	{
		ProjectHistoryDaoImpl projectHistoryDao=new ProjectHistoryDaoImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryDao.findAllProjectHistory();
		return l;
	}
		
	//插入新历史记录信息，要求项目事先存在  flag=0--插入失败    flag=1--插入成功   
	//flag=2--插入失败，项目表中没有该项目，则无法插入到历史记录表中
	public int InsertProjectHistory(ProjectHistory ph)
	{
		int flag=0;
		ProjectHistoryDaoImpl projectHistoryDao=new ProjectHistoryDaoImpl();
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(ph.getHpId()))
			{
				if(projectHistoryDao.insertInfoToProjectHistory(ph))
				{
					flag=1;
					return flag;
				}
				else
				{
					flag=0;
					return flag;					
				}
			}
		}	
		flag=2;
		return flag;
	}
	
	//更新历史记录信息的次数，要求项目事先存在
	public int UpdateProjectHistory(ProjectHistory ph)
	{
		int flag=0;
		ProjectHistoryDaoImpl projectHistoryDao=new ProjectHistoryDaoImpl();
		if(projectHistoryDao.updateProjectHistory(ph))
			flag=1;
		return flag;
	}
}
