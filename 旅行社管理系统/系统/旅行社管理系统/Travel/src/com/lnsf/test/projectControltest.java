package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.ProjectController;
import com.lnsf.model.Project;

public class projectControltest
{
	public static void main(String[] args)
	{
		ProjectController projectControl=new ProjectController();
		Scanner sc=new Scanner(System.in);
		int a=1;
		while(a!=0)
		{
			System.out.println("1.查找所有的项目信息");
			System.out.println("2.根据类别号查找项目");
			System.out.println("3.根据目的地查找项目");	
			System.out.println("4.根据项目号查找该项目的截止日期");
			System.out.println("5.根据负责人ID号查找项目");			
			System.out.println("6.根据导游ID号查找项目");		
			System.out.println("7.插入新项目信息");
			System.out.println("8.更新项目的负责人");
			System.out.println("9.更新项目的导游");		
			System.out.println("10.更新项目信息");		
			System.out.println("11.自由行的话负责人修改项目的状态");	
			System.out.println("12.跟团的话负责人分配导游和修改项目的状态");	
			System.out.println("13.再次推出项目时，修改项目的状态，报名时间和截止时间");	
			System.out.println("14.删除项目信息");
			System.out.println("15.退出");
			System.out.print("请选择:");
			int b=sc.nextInt();
			switch(b)
			{
				case 1:
						List<Project> l=new ArrayList<Project>();
						l=projectControl.MfindAllProject();
						projectControl.printProject(l);
						System.out.println();
						break;
						
				case 2:
						System.out.print("请输入类别号:");
						String pcId=sc.next();
						List<Project> li=new ArrayList<Project>();
						li=projectControl.MfindProjectBypcId(pcId);
						projectControl.printProject(li);
						System.out.println();
						break;
						
				case 3:
						System.out.print("请输入目的地:");
						String destination=sc.next();
						List<Project> lis=new ArrayList<Project>();
						lis=projectControl.MfindProjectByDestination(destination);
						projectControl.printProject(lis);
						System.out.println();
						break;		
						
				case 4:
						System.out.print("请输入项目号:");
						String pId=sc.next();	
						System.out.println(projectControl.MfindProjectEndingBypId(pId));
						System.out.println();
						break;
						
				case 5:
						System.out.print("请输入负责人ID号:");
						String chargeId=sc.next();	
						List<Project> list=new ArrayList<Project>();
						list=projectControl.MfindProjectBychargeId(chargeId);
						projectControl.printProject(list);
						System.out.println();
						break;			
						
				case 6:
						System.out.print("请输入导游ID号:");
						String leadId=sc.next();
						List<Project> list1=new ArrayList<Project>();
						list1=projectControl.MfindProjectByleadId(leadId);
						projectControl.printProject(list1);
						System.out.println();
						break;		
						
				case 7:
						switch(projectControl.MinsertProject())
						{
							case 0:
								System.out.println("插入失败");
								break;
							case 1:
								System.out.println("插入成功");	
								break;
							case 2:
								System.out.println("插入失败，项目类别号不存在");
								break;
							case 3:
								System.out.println("插入失败，该ID号不是员工或者员工ID号的职称不是负责人");		
								break;
						}
						System.out.println();
						break;						
							
				case 8:
						switch(projectControl.MupdateProjectchargeIdBypId())
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败，项目不存在");
								break;
							case 3:
								System.out.println("更新失败，该ID号不是员工或者员工ID号的职称不是负责人");		
								break;
						}		
						System.out.println();
						break;
						
				case 9:
						switch(projectControl.MupdateProjectleadIdBypId())
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败，项目不存在");
								break;
							case 3:
								System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是导游");		
								break;
							case 4:
								System.out.println("更新失败，该导游正在负责该旅游项目，不能更换导游");		
								break;				
						}		
						System.out.println();
						break;

				case 10:
						switch(projectControl.MupdateProjectinfo())
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败，项目类别不存在");
								break;
							case 3:
								System.out.println("更新失败，项目不存在");		
								break;
							case 4:
								System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人");
								break;
							case 5:
								System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是导游");		
								break;				
							case 6:
								System.out.println("更新失败，导游正在带领某个项目，不能更新该导游的ID号 ");		
								break;			
						}		
						System.out.println();
						break;						
				
				case 11:
						System.out.print("项目号:");
						String _pId=sc.next();
						System.out.print("状态:");
						int pflag=sc.nextInt();
						switch(projectControl.MupdateProjectflag(_pId,pflag))
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败,项目不存在");
								break;		
						}		
						System.out.println();
						break;							

				case 12:
						System.out.print("项目号:");
						String pId2=sc.next();
						switch(projectControl.MupdateProject(pId2))
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败,项目不存在");
								break;
							case 3:
								System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是导游");	
								break;
							case 4:
								System.out.println("更新失败，导游正在带领某个项目，不能更新该导游的");
								break;		
						}		
						System.out.println();
						break;	
					
				case 13:
						System.out.print("项目号:");
						String pId1=sc.next();
						switch(projectControl.MupdateProjectBypId(pId1))
						{
							case 0:
								System.out.println("更新失败");
								break;
							case 1:
								System.out.println("更新成功");	
								break;
							case 2:
								System.out.println("更新失败,项目不存在");
								break;		
						}		
						System.out.println();
						break;		
		
				case 14:
						if(projectControl.DeleteProject())
							System.out.println("删除成功");
						else
							System.out.println("删除失败");
						break;
						
				case 15:
						break;
			}
		}				
	}
}
