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
	
	/*--------------------------------查看信息-------------------------------*/
	
	//输出list中的所有项目信息	
	public void printProject(List<Project> l)
	{
		for(Project p:l)
		{
			System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
					+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
					+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
			System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
					+p.getMin()+"  报团最多人数:"+p.getMax());					
			System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
					p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
					+p.getPcId());
			System.out.println();			
		}			
	}
	
	//查找所有的项目信息，返回一个list
	public void MfindAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		employeeControl.printProject(l);
	}
	
	//根据类别号查找项目，返回所有相关的项目信息
	public void MfindProjectBypcId()
	{
		System.out.print("请输入类别号:");
		String pcId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.ProjectBypcId(pcId);
		employeeControl.printProject(l);		
	}	
	
	//根据目的地查找项目，返回所有相关的项目信息
	public void MfindProjectByDestination()
	{
		System.out.print("请输入目的地:");
		String destination=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectByDestination(destination);	
		employeeControl.printProject(l);			
	}	
	
	//根据项目号查找该项目的截止日期
	public void MfindProjectEndingBypId()
	{	
		System.out.print("请输入项目号:");
		String pId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		System.out.println(projectService.ProjectEndingBypId(pId));
	}	
	
	//根据负责人ID号查找项目，返回所有相关的项目信息
	public void MfindProjectBychargeId()
	{
		System.out.print("请输入负责人ID号:");
		String chargeId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectBychargeId(chargeId);	
		employeeControl.printProject(l);			
	}
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	public void MfindProjectByleadId()
	{		
		System.out.print("请输入导游ID号:");
		String leadId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectByleadId(leadId);
		employeeControl.printProject(l);			
	}	
	
	//查找所有的类别信息
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
	
	//查找所有的历史记录信息，返回一个list
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
