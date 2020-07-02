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
	//�������е���ʷ��¼��Ϣ������һ��list
	public List<ProjectHistory> AllProjectHistory()
	{
		ProjectHistoryDaoImpl projectHistoryDao=new ProjectHistoryDaoImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryDao.findAllProjectHistory();
		return l;
	}
		
	//��������ʷ��¼��Ϣ��Ҫ����Ŀ���ȴ���  flag=0--����ʧ��    flag=1--����ɹ�   
	//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
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
	
	//������ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���
	public int UpdateProjectHistory(ProjectHistory ph)
	{
		int flag=0;
		ProjectHistoryDaoImpl projectHistoryDao=new ProjectHistoryDaoImpl();
		if(projectHistoryDao.updateProjectHistory(ph))
			flag=1;
		return flag;
	}
}
