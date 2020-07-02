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
	DaoImpl的测试类
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
	//ServiceImpl的测试类
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
	
	//Controller的测试类	
	public static void main(String[] args) 
	{	
		ProjectHistoryController projectHistoryControl=new ProjectHistoryController();
		Scanner sc=new Scanner(System.in);
		int a=1;
		while(a!=0)
		{
			System.out.println("1.查找所有的历史记录信息");
			System.out.println("2.操作历史记录信息");	
			System.out.println("3.退出");
			System.out.print("请选择:");
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
						System.out.print("请输入项目号：");
						String hpId=sc.next();
						int flag=projectHistoryControl.MhandleProjectHistory(hpId);
						switch(flag)
						{						
							case 0:
								System.out.println("操作失败");
								break;
							case 1:
								System.out.println("操作成功");
								break;
							case 2:
								System.out.println("操作失败，项目表中没有该项目，则无法插入到历史记录表中");		
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
