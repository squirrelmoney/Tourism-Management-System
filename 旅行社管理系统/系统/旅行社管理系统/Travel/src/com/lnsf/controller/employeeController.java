package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.model.Category;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.service.impl.CategoryServiceImpl;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;
import com.lnsf.service.impl.ProjectServiceImpl;

public class employeeController
{
	Scanner sc=new Scanner(System.in);
	public static employeeController employeeControl=new employeeController();
	
	/*--------------------------------�鿴��Ϣ-------------------------------*/
	
	//���list�е�������Ŀ��Ϣ	
	public void printProject(List<Project> l)
	{
		for(Project p:l)
		{
			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
					+p.getMin()+"  �����������:"+p.getMax());					
			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
					+p.getPcId());
			System.out.println();			
		}			
	}
	
	//�������е���Ŀ��Ϣ������һ��list
	public void MfindAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		employeeControl.printProject(l);
	}
	
	//�������Ų�����Ŀ������������ص���Ŀ��Ϣ
	public void MfindProjectBypcId()
	{
		System.out.print("����������:");
		String pcId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.ProjectBypcId(pcId);
		employeeControl.printProject(l);		
	}	
	
	//����Ŀ�ĵز�����Ŀ������������ص���Ŀ��Ϣ
	public void MfindProjectByDestination()
	{
		System.out.print("������Ŀ�ĵ�:");
		String destination=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectByDestination(destination);	
		employeeControl.printProject(l);			
	}	
	
	//������Ŀ�Ų��Ҹ���Ŀ�Ľ�ֹ����
	public void MfindProjectEndingBypId()
	{	
		System.out.print("��������Ŀ��:");
		String pId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		System.out.println(projectService.ProjectEndingBypId(pId));
	}	
	
	//���ݸ�����ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public void MfindProjectBychargeId()
	{
		System.out.print("�����븺����ID��:");
		String chargeId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectBychargeId(chargeId);	
		employeeControl.printProject(l);			
	}
	
	//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public void MfindProjectByleadId()
	{		
		System.out.print("�����뵼��ID��:");
		String leadId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectByleadId(leadId);
		employeeControl.printProject(l);			
	}	
	
	//�������е������Ϣ
	public void UfindAllCategory()
	{
		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		for(Category c:l)
		{
			System.out.println(c);
		}
		System.out.println();
	}
	
	//�������е���ʷ��¼��Ϣ������һ��list
	public void MfindAllProjectHistory()
	{
		ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		for(ProjectHistory ph:l)
		{
			System.out.println(ph);
		}
		System.out.println();
	}		

}
