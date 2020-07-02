package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.model.Book;
import com.lnsf.model.Category;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.service.IbookService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.impl.BookServiceImpl;
import com.lnsf.service.impl.CategoryServiceImpl;
import com.lnsf.service.impl.InformationServiceImpl;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;
import com.lnsf.service.impl.ProjectServiceImpl;

public class chargerController
{
	Scanner sc=new Scanner(System.in);
	public static chargerController chargerControl=new chargerController();
	
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
	public void findAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		chargerControl.printProject(l);
	}	
	
	//根据负责人ID号查找项目，返回所有相关的项目信息
	public void findProjectBychargeId()
	{
		System.out.print("请输入负责人ID号:");
		String chargeId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectBychargeId(chargeId);	
		chargerControl.printProject(l);			
	}
	
	//查找所有的类别信息
	public void findAllCategory()
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
	public void findAllProjectHistory()
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

	
	
	/*--------------------------------项目管理 --------------------------------*/	
	
	//更新项目的导游，要求项目事先存在和用户信息表的状态不能为未过期(1)  flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在   flag=3--更新失败，该员工ID号无法做该项目的导游
	public void updateProjectleadIdBypId()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("导游ID号:");	
		String leadId=sc.next();		
		switch(projectService.UpdateProjectleadIdBypId(pId, leadId))
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
			System.out.println("更新失败，该员工ID号无法做该项目的导游");		
			break;			
		}
	}
	
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态	flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在
	public int updateProjectflag(String pId)
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		return projectService.UpdateProject(pId, 2);
	}
	
	//跟团的话负责人分配导游和修改项目的状态   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	//flag=3--更新失败，该员工ID号无法做该项目的导游
	public int updateProjectleadIDandflag(String pId,int pflag,String leadId)
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		return projectService.UpdateProject(pId, leadId, pflag);
	}
	
	public void MupdateProjectflag()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("状态:");
		int pflag=sc.nextInt();
		ProjectServiceImpl projectService=new ProjectServiceImpl();		
		switch(projectService.UpdateProject(pId, pflag))
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
	}

	public void MupdateProject()
	{
		System.out.print("项目号:");
		String pId=sc.next();
		System.out.print("状态:");
		int pflag=sc.nextInt();
		System.out.print("导游ID号:");			
		String leadId=sc.next();	
		ProjectServiceImpl projectService=new ProjectServiceImpl();	
		switch(projectService.UpdateProject(pId, leadId, pflag))
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
				System.out.println("更新失败，该员工ID号无法做该项目的导游");	
				break;		
		}				
	}	
	
	//插入新历史记录信息或者更新更新历史记录信息的次数，要求项目事先存在  
	//flag=0--操作失败    flag=1--操作成功   
	//flag=2--操作失败，项目表中没有该项目，则无法插入到历史记录表中
	public int handleProjectHistory(String _hpId)
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
	
	
	//---------------------------雯丽-----------------------------
	/*
	 * 根据项目的截止时间修改自由行项目的状态
	 */
	public void selfending()
	{
		System.out.print("请输入日期:");
		String date=sc.next();		
		List<Project> l=new ArrayList<Project>();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		InformationServiceImpl informationService=new InformationServiceImpl();
		l=projectService.AllProject();
		for(Project p:l)
		{
			if(projectService.ProjectEndingBypId(p.getpId()).equals(date) && p.getPcId().equals("c002"))
			{
				 if(informationService.InsertInformationFromBook(p.getpId()))
				 		chargerControl.updateProjectflag(p.getpId());			
			}
		}
	}
		
		
		/*
		 * 根据项目的截止时间修改跟团游项目的状态
		 */
		public void group()
		{
			System.out.print("请输入日期:");
			String date=sc.next();		
			List<Project> l=new ArrayList<Project>();
			ProjectServiceImpl projectService=new ProjectServiceImpl();
			InformationServiceImpl informationService=new InformationServiceImpl();
			ProjectHistoryServiceImpl projectHistoryService=new ProjectHistoryServiceImpl();
			l=projectService.AllProject();
			for(Project p:l)
			{
				if(projectService.ProjectEndingBypId(p.getpId()).equals(date) && p.getPcId().equals("c001"))
				{
					int num=chargerControl.eCountNumBypId(p.getpId());
					int min=projectService.ProjectMinBypId(p.getpId());
					int max=projectService.ProjectMaxBypId(p.getpId());
					if(num>=min && num <=max)
					{
						System.out.print("请输入导游ID号:");
						String leadId=sc.next();
						if(informationService.InsertInformationFromBook(p.getpId()))
						{
							if(chargerControl.updateProjectleadIDandflag(p.getpId(), 2, leadId)==1)
								System.out.println("项目顺利开展");
						}
							
					}
					if(num>0 && num<min)
					{				
						if(chargerControl.updateProjectflag(p.getpId())==1);
							System.out.println("不够人参加项目");
					}
					if(num==0)
					{
						if(chargerControl.handleProjectHistory(p.getpId())==1)
								System.out.println("没人参加项目");								
					}
				}				
			}
		}		
	

	
	
	

	
	
	
	/* -----------------------------------查找信息---------------------------------------*/
		//根据项目号查找所有的预约信息
		public boolean eBookBypId(String _pId){
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			if(bs.BookBypId(_pId).size()>0){
			for (Book a : bs.BookBypId(_pId)) {
				System.out.println(a);
				flag=true;
			}
			}else{
				System.out.println("预约表暂无数据");
			}
			return flag;
		}
		//负责人或者导游根据项目号查找用户信息，返回参加这个项目的所有用户信息
		public boolean InformationByipId(String _ipId) {
			boolean flag=false;
			IinformationService fs=new InformationServiceImpl();
			if(fs.InformationByipId(_ipId).size()>0){
				for (Information f : fs.InformationByipId(_ipId)) {
					System.out.println(f);
					flag=true;
				}
			}
			return flag;
		}
		
		
		
		
		
		
		
		
	/* -----------------------------------查找信息---------------------------------------*/
		//数出一个项目参加的人数
		public int eCountNumBypId(String _bpId){
			int n=0;
			IbookService bs=new BookServiceImpl();
			n=bs.CountNumBypId(_bpId);
			return n;
		}
		//从预约表插入新用户信息
		public boolean InsertInformationFromBook(String _ipId) {
			boolean flag=false;
			IinformationService fs=new InformationServiceImpl();
			flag=fs.InsertInformationFromBook(_ipId);
			return flag;
		}
		//更新预约信息的状态
		public boolean eupdateBookbflagBybpId(String _bpId) {
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			Scanner in=new Scanner(System.in);
			int _bflag=0;
			_bflag=in.nextInt();
			flag=bs.updateBookbflagBybpId(_bpId, _bflag);
			if(flag==false){
				System.out.println("更新预约信息失败，请检查");
			}
			in.close();
			return flag;
		}	
		//定时删除预约信息
		public boolean eDeleteBook(String _bpId) {
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			flag=bs.DeleteBook(_bpId);
			if(flag==false){
				System.out.println("删除预约信息失败，请检查");
			}
			return flag;
		}	
	
}
