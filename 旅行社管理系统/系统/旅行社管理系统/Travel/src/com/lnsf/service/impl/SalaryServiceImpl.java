package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IsalaryDao;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.SalaryDaoImpl;
import com.lnsf.model.Employee;
import com.lnsf.model.Project;
import com.lnsf.model.Salary;
import com.lnsf.service.IsalaryService;

public class SalaryServiceImpl implements IsalaryService{
	   //查找所有工资信息，返回list
		public List<Salary> AllSalary(){
			IsalaryDao i=new SalaryDaoImpl();
			List<Salary>list=new ArrayList<Salary>();
			list=i.findAllSalary();
			return list;
			}
		

		//根据员工号查找工资，返回一个list
		public List<Salary> SalaryBycId(String _seId){
			IsalaryDao i=new SalaryDaoImpl();
			List<Salary>list=new ArrayList<Salary>();
			for(Salary a : i.findAllSalary()){			
	            if(a.getSeId().equals(_seId)){
	            	list.add(a);
				}			 
			}
			return list;
		}
		
		

		//插入新员工工资信息，要求员工工号事先存在在employee,通过员工工号找到所对应的职业，通过这个职业查找对应的第一个工号，则在工资表中找到这个工号的工资表信息
		public int insertSalary(String _seId){
		int flag=0;
		IsalaryDao i = new SalaryDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
	    list=edi.findAllEmployee();
		for(Employee e1:list){
			if(e1.geteId().equals(_seId)){
				Salary s=new Salary(_seId, 0, 0, 0);
//				System.out.println(_seId);
				flag=i.insertInfoToSalary(s);
				break;
			}
		}
		if(flag==1){
//	    	System.out.println("成功插入新的员工工资单");
	    }else{
	    	System.out.println("插入失败");
	    }
		return flag;
		}
		
		//更新员工工资信息,修改基本工资时，同一职位的员工都要同步更新，保险不修改
		public int updateSalary(Salary s){	
			int flag=0;
			String _title=null;
			int n=0;
			Salary s2=new Salary(null, 0, 0, 0);
			IsalaryDao i=new SalaryDaoImpl();
			List<Employee> list=new ArrayList<Employee>();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
		    list=edi.findAllEmployee();
			for(Employee e1:list){
				if(e1.geteId().equals(s.getSeId()))
				{
					_title=e1.geteTitle();
					break;
				}
			}
			for(Employee e2:list){
				if(e2.geteTitle().equals(_title))
				{
					for (Salary s1 : i.findAllSalary()) {
						if(e2.geteId().equals(s1.getSeId())){
							s2.setSeId(s1.getSeId());
							s2.setBaseSalary(s.getBaseSalary());
							s2.setInsurance(s.getInsurance());
							s2.setReward(s1.getReward());
							n=i.updateSalary(s2);
					}
					
					
				}
					flag=i.updateSalary(s);
			}
			
			}
			if(n==2){//职位或其他操作失败）
//				flag=2;
				return flag;
			}
			if(flag==1){
		    	//System.out.println("成功更新员工工资单");
		    }else{
		    	System.out.println("没有这个号更新失败");
		    }
			
			return flag;	
		}
		
		//更新奖金（因为带领队伍旅游）
		public int updateReward(Salary s){	
		int flag=0;
		Scanner in = new Scanner(System.in);
		IsalaryDao i=new SalaryDaoImpl();
		String _seId=s.getSeId();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();		
		l=projectService.ProjectBychargeId(_seId);
		li=projectService.ProjectByleadId(_seId);
		int num=0;
		if(li.size()!=0 && l.size()==0)
			num=li.size();
		else
			num=l.size();
	    Double _reward=s.getReward()+s.getBaseSalary()*0.05*num;	    
		List<Salary>list=new ArrayList<Salary>();
	    SalaryDaoImpl id=new SalaryDaoImpl();
		list=id.findAllSalary();
		for(Salary s1:list){
			if(s1.getSeId().equals(_seId)){		
				if(s.getReward()==_reward){
					System.out.println("修改奖金成功");
				}else{
					System.out.println("修改奖金失败");
				}
				s.setSeId(s1.getSeId());
				s.setBaseSalary(s1.getBaseSalary());
				s.setInsurance(s1.getInsurance());
				flag=i.updateSalary(s);
			}
		}
		return flag;
	}
		
		
		
		
		
		
		
				//2.删除员工工资信息
		public boolean deleteSalary(String _seId){
			boolean flag=false;
			int n=0;
			Salary s2=new Salary(null, 0, 0, 0);
			IsalaryDao i=new SalaryDaoImpl();
			List<Employee> list=new ArrayList<Employee>();
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
		    list=edi.findAllEmployee();
			for(Employee e1:list){
				if(e1.geteId().equals(_seId)){
					flag=i.deleteSalary(e1.geteId());
					
				}
		}
			if(flag=true){
		    	System.out.println("删除成功");
		    }else{
		    	System.out.println("删除失败");
		    }
			return flag;
			}
	}