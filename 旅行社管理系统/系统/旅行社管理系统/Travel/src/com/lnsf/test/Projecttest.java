package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Project;
import com.lnsf.service.impl.ProjectServiceImpl;

public class Projecttest
{
/*
	DaoImpl的测试类
	public static void main(String[] args) 
	{
		List<Project> l=new ArrayList<Project>();
		ProjectDaoImpl pdi=new ProjectDaoImpl();
		l=pdi.findAllProject();
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
		System.out.println();
		
		List<Project> li=new ArrayList<Project>();
		li=pdi.findProjectByDestination("三亚");
		for(Project p:li)
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
		System.out.println();
		
		System.out.println(pdi.findProjectEndingBypId("p006"));
		System.out.println();
		
		List<Project> lis=new ArrayList<Project>();
		lis=pdi.findProjectBychargeId("f001");
		for(Project p:lis)
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
		System.out.println();
		
		List<Project> list=new ArrayList<Project>();
		list=pdi.findProjectByleadId("d001");
		for(Project p:list)
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
		System.out.println();		
		
		Project p=new Project("p007","新加坡3日游", "新加坡", 1, "2019-05-01", "2019-05-10", 
				"9月25日早上7:00白云机场登机,9月28晚上7:00新加坡机场登机回程", 7, 15, 1, "f001",null,"c002");
		System.out.println(pdi.insertInfoToProject(p));
		System.out.println();
				
		System.out.println(pdi.updateProjectchargeIdBypId("p007", "f001"));
		System.out.println();
		
		System.out.println(pdi.updateProjectleadIdBypId("p001"));
		System.out.println();
		
		System.out.println(pdi.updateProject("p006", "f001", 1));
		System.out.println();		
		
		System.out.println(pdi.updateProject("p006", "f001", "d001", 1));
		System.out.println();
		
		System.out.println(pdi.updateProjectBypId("p006", "2010-01-02", "2010-01-28", 1));
		System.out.println();
		
		System.out.println(pdi.deleteProject());
		System.out.println();
	}
*/
	
	//ServiceImpl的测试类
	public static void main(String[] args) 
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
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
		System.out.println();
		
		System.out.println(projectService.ProjectMinBypId("p001"));
		System.out.println(projectService.ProjectMaxBypId("p001"));
		
//		List<Project> ll=new ArrayList<Project>();
//		ll=projectService.ProjectBypcId("c002");
//		for(Project p:ll)
//		{
//			System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
//					+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
//					+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
//			System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
//					+p.getMin()+"  报团最多人数:"+p.getMax());					
//			System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
//					p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
//					+p.getPcId());
//			System.out.println();
//		}	
//		System.out.println();		
		
//		List<Project> li=new ArrayList<Project>();
//		li=projectService.ProjectByDestination("三亚");
//		for(Project p:li)
//		{
//			System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
//					+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
//					+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
//			System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
//					+p.getMin()+"  报团最多人数:"+p.getMax());					
//			System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
//					p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
//					+p.getPcId());
//			System.out.println();			
//		}
//		System.out.println();
//		
//		System.out.println(projectService.ProjectEndingBypId("p001"));
//		System.out.println();
//		
//		List<Project> lis=new ArrayList<Project>();
//		lis=projectService.ProjectBychargeId("f001");
//		for(Project p:lis)
//		{
//			System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
//					+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
//					+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
//			System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
//					+p.getMin()+"  报团最多人数:"+p.getMax());					
//			System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
//					p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
//					+p.getPcId());
//			System.out.println();			
//		}			
//		System.out.println();
//		
//		List<Project> list=new ArrayList<Project>();
//		list=projectService.ProjectByleadId("d001");	
//		for(Project p:list)
//		{
//			System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
//					+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
//					+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
//			System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
//					+p.getMin()+"  报团最多人数:"+p.getMax());					
//			System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
//					p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
//					+p.getPcId());
//			System.out.println();			
//		}			
//		System.out.println();	

//		Project p=new Project("p007","新加坡3日游", "新加坡", 1, "2019-05-01", "2019-05-10", 
//				"6月25日早上7:00白云机场登机,6月28晚上7:00新加坡机场登机回程", 7, 15, 1, "f001",null,"c002");		
//		int flag=projectService.InsertProject(p);
//		switch(flag)
//		{
//			case 0:
//				System.out.println("插入失败");
//				break;
//			case 1:
//				System.out.println("插入成功");	
//				break;
//			case 2:
//				System.out.println("插入失败，项目类别号不存在");
//				break;
//			case 3:
//				System.out.println("插入失败，该ID号不是员工或者员工ID号的职称不是负责人");		
//				break;
//		}
//		System.out.println();
		
//		int flag1=projectService.UpdateProjectchargeIdBypId("p007", "f002");
//		switch(flag1)
//		{
//			case 0:
//				System.out.println("更新失败");
//				break;
//			case 1:
//				System.out.println("更新成功");	
//				break;
//			case 2:
//				System.out.println("更新失败，项目不存在");
//				break;
//			case 3:
//				System.out.println("更新失败，该ID号不是员工或者员工ID号的职称不是负责人");		
//				break;
//		}
//		System.out.println();
		
//		int flag2=projectService.UpdateProjectleadIdBypId("p006", "d001");
//		switch(flag2)
//		{
//			case 0:
//				System.out.println("更新失败");
//				break;
//			case 1:
//				System.out.println("更新成功");	
//				break;
//			case 2:
//				System.out.println("更新失败，项目不存在");
//				break;
//			case 3:
//				System.out.println("更新失败，该员工ID号无法做该项目的导游");		
//				break;			
//		}
//		System.out.println();		
		
		
//		Project p1=new Project("p001","新加坡3日游", "新加坡", 1, "2019-05-01", "2019-05-10", 
//				"6月25日早上7:00白云机场登机,6月28晚上7:00新加坡机场登机回程", 7, 15, 1, "f003","d003","c002");	
//		int flag3=projectService.updateProject(p1);
//		switch(flag3)
//		{
//			case 0:
//				System.out.println("更新失败");
//				break;
//			case 1:
//				System.out.println("更新成功");	
//				break;
//			case 2:
//				System.out.println("更新失败，项目类别不存在");
//				break;
//			case 3:
//				System.out.println("更新失败，项目不存在");		
//				break;
//			case 4:
//				System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人");
//				break;
//			case 5:
//				System.out.println("更新失败，该员工ID号无法做该项目的导游");					
//		}
//		System.out.println();		
		
//		int flag4=projectService.UpdateProject("p001", 1);
//		switch(flag4)
//		{
//			case 0:
//				System.out.println("更新失败");
//				break;
//			case 1:
//				System.out.println("更新成功");	
//				break;
//			case 2:
//				System.out.println("更新失败,项目不存在");
//				break;
//		}
//		System.out.println();		
		
//		int flag5=projectService.UpdateProject("p002", "d003", 2);
//		switch(flag5)
//		{
//			case 0:
//				System.out.println("更新失败");
//				break;
//			case 1:
//				System.out.println("更新成功");	
//				break;
//			case 2:
//				System.out.println("更新失败,项目不存在");
//				break;
//			case 3:
//				System.out.println("更新失败，该员工ID号无法做该项目的导游");	
//				break;			
//		}
//		System.out.println();		
		
//		System.out.println(projectService.DeleteProject());				
	}
}
