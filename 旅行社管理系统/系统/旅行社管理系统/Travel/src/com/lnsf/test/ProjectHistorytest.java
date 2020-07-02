package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.CategoryController;
import com.lnsf.controller.ProjectHistoryController;
import com.lnsf.dao.impl.ProjectHistoryDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.model.ProjectHistory;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;

public class ProjectHistorytest
{
/*	
	DaoImpl�Ĳ�����
	public static void main(String[] args) 
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		ProjectHistoryDaoImpl phdi=new ProjectHistoryDaoImpl();
		l=phdi.findAllProjectHistory();
		for(ProjectHistory ph:l)
			System.out.println(ph);
		System.out.println();
		ProjectHistory ph=new ProjectHistory("p001", 1);
		System.out.println(phdi.insertInfoToProjectHistory(ph));
		System.out.println();
		ProjectHistory ph1=new ProjectHistory("p006", 1);
		System.out.println(phdi.updateProjectHistory(ph1));
	}
*/

/*
	//ServiceImpl�Ĳ�����
	public static void main(String[] args) 
	{
		ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		l=projectHistoryService.AllProjectHistory();
		for(ProjectHistory ph:l)
			System.out.println(ph);		
		System.out.println();
		
		ProjectHistory ph=new ProjectHistory("p001", 1);
		System.out.println(projectHistoryService.InsertProjectHistory(ph));
		System.out.println();
		
		ProjectHistory ph=new ProjectHistory("p001", 2);
		System.out.println(projectHistoryService.UpdateProjectHistory(ph));
		System.out.println();
						
	}
*/
	
	//Controller�Ĳ�����	
	public static void main(String[] args) 
	{	
		ProjectHistoryController projectHistoryControl=new ProjectHistoryController();
		Scanner sc=new Scanner(System.in);
		int a=1;
		while(a!=0)
		{
			System.out.println("1.�������е���ʷ��¼��Ϣ");
			System.out.println("2.������ʷ��¼��Ϣ");	
			System.out.println("3.�˳�");
			System.out.print("��ѡ��:");
			int b=sc.nextInt();
			switch(b)
			{
				case 1:
						List<ProjectHistory> l=new ArrayList<ProjectHistory>();
						l=projectHistoryControl.MfindAllProjectHistory();
						for(ProjectHistory ph:l)
							System.out.println(ph);
						System.out.println();
						break;
						
				case 2:
						System.out.print("��������Ŀ�ţ�");
						String hpId=sc.next();
						int flag=projectHistoryControl.MhandleProjectHistory(hpId);
						switch(flag)
						{						
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("�����ɹ�");
								break;
							case 2:
								System.out.println("����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����");		
								break;
						}
						System.out.println();
						break;
									
				case 3:
						break;
			}
		}		
	}
}
