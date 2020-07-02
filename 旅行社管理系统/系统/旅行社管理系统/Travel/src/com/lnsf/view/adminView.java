package com.lnsf.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.adminController;
import com.lnsf.controller.adminControllermoney;
import com.lnsf.dao.impl.SalaryDaoImpl;
import com.lnsf.model.Salary;

public class adminView
{
	public void admin()
	{
		
	adminController a=new  adminController();
	Scanner input=new Scanner(System.in);
	adminControllermoney mon=new adminControllermoney();
	int n = 0;
	while(true){
	System.out.println("---------0.返回-----------");
	System.out.println("---------1.查看旅行社信息-----------");
	System.out.println("---------2.员工管理-----------");
	System.out.println("---------3.项目管理----------");
	System.out.println("---------4.财务管理----------");
	System.out.print("请选择:");
	int num1=input.nextInt();
	switch(num1){
	case 1:
		while(true){
		//查看旅行社信息
		System.out.println("---------0.返回-----------");
		System.out.println("---------1.查看预约信息----------");
		System.out.println("---------2.查看用户信息----------");
		System.out.println("请选择:");
		 n=input.nextInt();
		switch(n){
		case 1:a.adminAllBook(); break;
		case 2:a.AllInformation(); break;
		default:break;
		}
		if(n==0){
			break;
		}
		}
		 
			break;
		
	case 2:
		//员工管理
		while(true){
			System.out.println("---------0.返回-----------");
			System.out.println("---------1.查看员工信息----------");
			System.out.println("---------2.修改权限----------");
			System.out.println("---------3.员工工资管理----------");
			System.out.println("---------4.员工升职----------");
			System.out.println("---------5.员工辞退----------");
			System.out.println("---------6.招收新员工----------");
			System.out.println("请选择:");
			 n=input.nextInt();
			switch(n){
			case 1:a.AllEmployee();break;
			case 2:
				if(a.AllUser()){
					System.out.println("需要修改权限的账号：");
		            String _uTel=input.next();
		            System.out.println("修改新的权限为：");
		            System.out.println("提示：输入1代表身份是经理，2代表身份为负责人，3代表身份为导游，4代表身份为普通用户");
		            int _uSuper=input.nextInt();
					a.updateUser1(_uTel, _uSuper);
					  break;
					   }
			case 3:
				while(true)
				{
				System.out.println("---------0.返回-----------");
				System.out.println("---------1.修改员工工资----------");
				System.out.println("---------2.计算员工提成----------");
				System.out.println("---------3.查看所有员工工资----------");
			
				int choose=input.nextInt();
		       switch(choose)
		       {
		       case 1:
					System.out.println("需要修改工作的账号：");
		            String _seId=input.next();
		            System.out.println("修改新的工资为：");
		            
		            Double _baseSalary=input.nextDouble();
		        	List<Salary>list=new ArrayList<Salary>();
		            SalaryDaoImpl id=new SalaryDaoImpl();
		        	list=id.findAllSalary();				        	
		        	for(Salary s1:list)
		        	{
		        		if(s1.getSeId().equals(_seId))
		        		{
		 a.updateSalary(_seId, _baseSalary, 1200d,s1.getReward());
		        		}
		        	}
		    	   break;
		       case 2:System.out.println("输入要加提成的员工编号");
               String _seId1=input.next();
               a.updateReward(_seId1);
                break;//提成
		    	 
		       case 3:
		    	   //查看所有员工工资
		    	   System.out.println(a.AllSalary());
		    	   break;
		       default:break;
				}
				
				break;
				}
				break;
			case 4:
					System.out.println("请输入你要升职的员工号:");
					String _eId=null;
					_eId=input.next();
					System.out.println(_eId);
				   System.out.println(a.UpdateEmployeeTitleByeId(_eId));
			       break;
			case 5: 
				a.AllEmployee();
				System.out.println("请输入你要删除的员工号:");
				 _eId=null;
				_eId=input.next();
				System.out.println(mon.DeleteEmployee(_eId)); 
				break;
			     
			case 6:
              //插入新的员工工资
				System.out.println("输入新的员工工资信息");
				String _seId =input.next();
				a.insertSalary(_seId);
				
			default:break;
			}
			if(n==0){
				break;
			}
			}
		
			break;
		
	  case 3:
		//项目管理
		while(true)
		{
			System.out.println("---------0.返回-----------");
			System.out.println("---------1.查看项目信息-----------");
			System.out.println("---------2.添加项目----------");
			System.out.println("---------3.更新项目的负责人-----------");
			System.out.println("---------4.更新项目信息-----------");
			System.out.println("---------5.再次推出项目时，修改项目的状态，报名时间和截止时间----------");		
			System.out.println("---------6.当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置----------");	
			System.out.print("请选择:");
			n=input.nextInt();
			switch(n)
			{
				case 1: 
						a.MfindAllProject();
						break;
				case 2:
						a.MinsertProject();
						break;
				case 3: 
						a.MupdateProjectchargeIdBypId();
						break;
				case 4:
						a.MupdateProjectinfo();
						break;
				case 5: 
						a.MupdateProjectBypId();
						break;							
				case 6: 
						a.DeleteProject();
						break;								
				default:break;
			}
			if(n==0)
			{
				break;
			}
		}
		break;
				
		case 4:
			//财务管理
					while(true){
						System.out.println("---------0.返回-----------");
						System.out.println("---------1.查看财务信息-----------");
						System.out.println("---------2.查看利润-----------");
						System.out.println("---------3.更新项目成本----------");
						System.out.println("---------4.添加项目财务----------");
						System.out.println("请选择:");
						 n=input.nextInt();
						switch(n){
						case 1:a.AllFinancing();break;
						case 2:a.UpdateProfit();
						       a.AllFinancing(); 
						       break;
						case 3:
							a.AllFinancing();
							System.out.println("请输入你要修改的项目编号:");
							String pid=null;
							pid=input.next();
							System.out.println(a.UpdateFinancing(pid));
						        break;
						        
						case 4:
							System.out.println("请输入你要添加财务的项目编号:");
							pid=null;
							pid=input.next();
							System.out.println(a.InsertProjectAndFinancing(pid));
							break;
						default:break;
						}
						if(n==0){
							break;
						}
						}
						break;
					
		default:
			break;
	}
	if(num1==0){
		break;
	}
			}

	}
		

}

