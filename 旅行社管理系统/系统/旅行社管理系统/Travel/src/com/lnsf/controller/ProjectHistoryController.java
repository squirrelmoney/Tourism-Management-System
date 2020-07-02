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
	 * �û���Ȩ��
	 */

	
	/*
	 * ���ε�Ȩ��
	 */	
	//�������е���ʷ��¼��Ϣ������һ��list
	public List<ProjectHistory> DfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}	

	
	/*
	 * �����˵�Ȩ��
	 */
	//�������е���ʷ��¼��Ϣ������һ��list
	public List<ProjectHistory> FfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}	
	
	//��������ʷ��¼��Ϣ���߸��¸�����ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���  
	//flag=0--����ʧ��    flag=1--�����ɹ�   
	//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
	public int FhandleProjectHistory()
	{
		System.out.print("��������Ŀ�ţ�");
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
	 * �����Ȩ��
	 */	
	
	//�������е���ʷ��¼��Ϣ������һ��list
	public List<ProjectHistory> MfindAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		return l;
	}
	
	//��������ʷ��¼��Ϣ���߸��¸�����ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���  
	//flag=0--����ʧ��    flag=1--�����ɹ�   
	//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
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
