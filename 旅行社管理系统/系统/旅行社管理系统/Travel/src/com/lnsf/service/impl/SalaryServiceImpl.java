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
	   //�������й�����Ϣ������list
		public List<Salary> AllSalary(){
			IsalaryDao i=new SalaryDaoImpl();
			List<Salary>list=new ArrayList<Salary>();
			list=i.findAllSalary();
			return list;
			}
		

		//����Ա���Ų��ҹ��ʣ�����һ��list
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
		
		

		//������Ա��������Ϣ��Ҫ��Ա���������ȴ�����employee,ͨ��Ա�������ҵ�����Ӧ��ְҵ��ͨ�����ְҵ���Ҷ�Ӧ�ĵ�һ�����ţ����ڹ��ʱ����ҵ�������ŵĹ��ʱ���Ϣ
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
//	    	System.out.println("�ɹ������µ�Ա�����ʵ�");
	    }else{
	    	System.out.println("����ʧ��");
	    }
		return flag;
		}
		
		//����Ա��������Ϣ,�޸Ļ�������ʱ��ͬһְλ��Ա����Ҫͬ�����£����ղ��޸�
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
			if(n==2){//ְλ����������ʧ�ܣ�
//				flag=2;
				return flag;
			}
			if(flag==1){
		    	//System.out.println("�ɹ�����Ա�����ʵ�");
		    }else{
		    	System.out.println("û������Ÿ���ʧ��");
		    }
			
			return flag;	
		}
		
		//���½�����Ϊ����������Σ�
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
					System.out.println("�޸Ľ���ɹ�");
				}else{
					System.out.println("�޸Ľ���ʧ��");
				}
				s.setSeId(s1.getSeId());
				s.setBaseSalary(s1.getBaseSalary());
				s.setInsurance(s1.getInsurance());
				flag=i.updateSalary(s);
			}
		}
		return flag;
	}
		
		
		
		
		
		
		
				//2.ɾ��Ա��������Ϣ
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
		    	System.out.println("ɾ���ɹ�");
		    }else{
		    	System.out.println("ɾ��ʧ��");
		    }
			return flag;
			}
	}