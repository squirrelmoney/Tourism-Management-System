package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.model.Book;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.service.IbookService;
import com.lnsf.service.IemployeeService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.impl.BookServiceImpl;
import com.lnsf.service.impl.EmployeeServiceImpl;
import com.lnsf.service.impl.InformationServiceImpl;
import com.lnsf.service.impl.ProjectServiceImpl;

public class leaderController 
{
	leaderController leaderControl=new leaderController();
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
	
	//当员工修改电话号码，修改用户登录表的电话号码
		public boolean UpdateEmployeeTelByeId(String old_eTel)
		{
			boolean flag=false;
			IemployeeService es=new EmployeeServiceImpl();
			flag=es.UpdateEmployeeTelByeId(old_eTel);
			return flag;
			
		}
		
		//根据导游ID号查找项目，返回所有相关的项目信息
		public void MfindProjectByleadId(String _leadId)
		{		
			ProjectServiceImpl projectService=new ProjectServiceImpl();
			List<Project> l=new ArrayList<Project>();
			l=projectService.ProjectByleadId(_leadId);
			leaderControl.printProject(l);
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
}
