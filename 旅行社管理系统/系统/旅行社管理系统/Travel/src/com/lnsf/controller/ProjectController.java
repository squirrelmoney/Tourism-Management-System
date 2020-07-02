package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.InformationDaoImpl;
import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.model.Employee;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.service.impl.ProjectServiceImpl;



public class ProjectController
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	/*
	 * 用户的权限
	 */

	
	/*
	 * 导游的权限
	 */	
	//查找所有的历史记录信息，返回一个list


	
	/*
	 * 负责人的权限
	 */
	//查找所有的历史记录信息，返回一个list

	
	/*
	 * 经理的权限
	 */	
	
	//查找所有的项目信息，返回一个list
	public List<Project> MfindAllProject()
	{
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		return l;
	}

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
	
	//根据类别号查找项目，返回所有相关的项目信息
	public List<Project> MfindProjectBypcId(String _pcId)
	{
		return projectService.ProjectBypcId(_pcId);
	}	
	
	//根据目的地查找项目，返回所有相关的项目信息
	public List<Project> MfindProjectByDestination(String _destination)
	{
		return projectService.ProjectByDestination(_destination);		
	}	
	
	//根据项目号查找该项目的截止日期
	public String MfindProjectEndingBypId(String _pId)
	{		
		return projectService.ProjectEndingBypId(_pId);
	}	
	
	//根据负责人ID号查找项目，返回所有相关的项目信息
	public List<Project> MfindProjectBychargeId(String _chargeId)
	{
		return projectService.ProjectBychargeId(_chargeId);		
	}
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	public List<Project> MfindProjectByleadId(String _leadId)
	{		
		return projectService.ProjectByleadId(_leadId);
	}
	
	//插入新项目信息,要求项目类别号和负责人ID号事先存在(导游ID是NULL)  flag=0--插入失败  flag=1--插入成功  
	//flag=2--插入失败，项目类别号不存在  flag=3--插入失败，该ID号不是员工或者员工ID号的职称不是负责人
	public int MinsertProject()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("项目名:");	
		String pName=sc.next();
		System.out.print("目的地:");	
		String destination=sc.next();
		System.out.print("旅游持续时间:");
		int last=sc.nextInt();
		System.out.print("报名时间:");	
		String beginning=sc.next();
		System.out.print("截止时间:");	
		String ending=sc.next();
		System.out.print("详细信息:");
		String describing=sc.next();
		System.out.print("报团最少人数:");	
		int min=sc.nextInt();
		System.out.print("报团最多人数:");	
		int max=sc.nextInt();
		System.out.print("状态:");
		int pflag=sc.nextInt();
		System.out.print("负责人ID号:");	
		String chargeId=sc.next();	
		String leadId=null;		
		System.out.print("项目类别号:");	
		String pcId =sc.next();	
		Project p=new Project
		(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);
		return projectService.InsertProject(p);
	}	
	
	//更新项目的负责人,要求项目和负责人ID号都事先存在   flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在  flag=3--更新失败，该ID号不是员工或者员工ID号的职称不是负责人
	public int MupdateProjectchargeIdBypId()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("负责人ID号:");	
		String chargeId=sc.next();	
		return projectService.UpdateProjectchargeIdBypId(pId, chargeId);	
	}	
	
	//更新项目的导游，要求项目事先存在和用户信息表的状态不能为未过期(1)  flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在   flag=3--更新失败，该员工ID号无法做该项目的导游
	public int MupdateProjectleadIdBypId()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("导游ID号:");	
		String leadId=sc.next();	
		return projectService.UpdateProjectleadIdBypId(pId, leadId);		
	}	
	
	//更新项目信息，要求项目类别号，项目号，员工的ID号是负责人和导游ID号(导游不能正在带领某个项目)都要事先存在
	//flag=0--更新失败  flag=1--更新成功  flag=2--更新失败，项目类别不存在 
	//flag=3--更新失败，项目不存在  flag=4--更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人 
	//flag=5--更新失败，该员工ID号无法做该项目的导游	
	public int MupdateProjectinfo()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("项目名:");	
		String pName=sc.next();
		System.out.print("目的地:");	
		String destination=sc.next();
		System.out.print("旅游持续时间:");
		int last=sc.nextInt();
		System.out.print("报名时间:");	
		String beginning=sc.next();
		System.out.print("截止时间:");	
		String ending=sc.next();
		System.out.print("详细信息:");
		String describing=sc.next();
		System.out.print("报团最少人数:");	
		int min=sc.nextInt();
		System.out.print("报团最多人数:");	
		int max=sc.nextInt();
		System.out.print("状态:");
		int pflag=sc.nextInt();
		System.out.print("负责人ID号:");	
		String chargeId=sc.next();	
		System.out.print("导游ID号:");			
		String leadId=sc.next();
		System.out.print("项目类别号:");	
		String pcId =sc.next();		
		Project p=new Project
		(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);	
		return projectService.updateProject(p);
	}	
	
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态	flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在
	public int MupdateProjectflag(String _pId,int _pflag)
	{
		return projectService.UpdateProject(_pId, _pflag);		
	}
	
	//跟团的话负责人分配导游和修改项目的状态   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	//flag=3--更新失败，ID号不是员工的ID号或者该员工的ID号不是导游   flag=4--更新失败，导游正在带领某个项目，不能更新该导游的  
	public int MupdateProject(String _pId)
	{
		System.out.print("状态:");
		int pflag=sc.nextInt();
		System.out.print("导游ID号:");			
		String leadId=sc.next();		
		return projectService.UpdateProject(_pId, leadId, pflag);		
	}
	
	//再次推出项目时，修改项目的状态，报名时间和截止时间   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	public int MupdateProjectBypId(String _pId)
	{
		System.out.print("报名时间:");	
		String beginning=sc.next();
		System.out.print("截止时间:");	
		String ending=sc.next();
		System.out.print("状态:");
		int pflag=sc.nextInt();		
		return projectService.UpdateProjectBypId(_pId, beginning, ending, pflag);		
	}	
	
	//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
	public boolean DeleteProject()
	{
		return projectService.DeleteProject();	
	}	
}
