package com.lnsf.view;

import java.util.Scanner;

import com.lnsf.controller.chargerController;

public class chargerView
{
	public void charger()
	{
		chargerController c=new chargerController();
		Scanner input=new Scanner(System.in);
		int n;
		
		while(true){
		System.out.println("---------0.返回-----------");	
		System.out.println("---------1.查看旅行社信息-----------");
		System.out.println("---------2.项目管理-----------");		
		System.out.print("请选择:");
		int num1=input.nextInt();
		
		switch(num1)
		{
		case 1:
			while(true)
			{
				//查看旅行社信息
				System.out.println("---------0.返回-----------");
				System.out.println("---------1.查看项目信息-----------");
				System.out.println("---------2.查看类别信息----------");
				System.out.println("---------3.查看历史记录信息----------");
				System.out.print("请选择:");
				 n=input.nextInt();
				switch(n)
				{
					case 1:
							c.findAllProject();
							break;
					case 2:
							c.findAllCategory(); 
							break;
					case 3:
							c.findAllProjectHistory(); 
							break;
					default:break;
				}
				if(n==0)
				{
					break;
				}
			}
			break;
		case 2:
			//项目管理
			while(true)
			{
				System.out.println("---------0.返回-----------");
				System.out.println("---------1.根据负责人ID号查找项目----------");
				System.out.println("---------2.更新项目的导游----------");
				System.out.println("---------3.自由行的话负责人修改项目的状态----------");
				System.out.println("---------4.跟团的话负责人分配导游和修改项目的状态----------");
				System.out.println("---------5.根据项目的截止时间修改自由行项目的状态----------");
				System.out.println("---------6.跟团的话负责人分配导游和修改项目的状态----------");				
				System.out.println("请选择:");
				 n=input.nextInt();
				switch(n)
				{
					case 1: 
							c.findProjectBychargeId();
							break;
					case 2:
							c.updateProjectleadIdBypId();
							break;
					case 3:
							c.MupdateProjectflag();
							break;
					case 4: 
							c.MupdateProject();
							break;
					case 5:
							c.selfending();
							break;
					case 6: 
							c.group();
							break;							
							
					default:break;
				}
				if(n==0)
				{
					break;
				}
			}
			break;
			
		default:
				break;
	}
		break;
		}
	}
}
