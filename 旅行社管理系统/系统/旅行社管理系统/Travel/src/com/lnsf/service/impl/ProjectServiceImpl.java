package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.InformationDaoImpl;
import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.model.Employee;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.service.IprojectService;

public class ProjectServiceImpl implements IprojectService
{
	//查找所有的项目信息，返回一个list
	public List<Project> AllProject()
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		return l;
	}
	
	//根据类别号查找项目，返回所有相关的项目信息
	public List<Project> ProjectBypcId(String _pcId)
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();
		l=projectDao.findAllProject();		
		for(Project p:l)
		{
			if(p.getPcId().equals(_pcId))
				li.add(p);
		}
		return li;
	}
	
	//根据目的地查找项目，返回所有相关的项目信息
	public List<Project> ProjectByDestination(String _destination)
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getDestination().equals(_destination))
				li.add(p);
		}
		return li;
	}
	
	//根据项目号查找该项目的截止日期
	public String ProjectEndingBypId(String _pId)
	{
		String a=null;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				a=p.getEnding();
				return a;
			}				
		}
		return a;
	}
	
	//根据项目号查找该项目的报团最少人数
	public int ProjectMinBypId(String _pId)
	{
		int min=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				min=p.getMin();
				return min;
			}				
		}
		return min;		
	}
	
	//根据项目号查找该项目的报团最多人数
	public int ProjectMaxBypId(String _pId)
	{
		int max=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				max=p.getMax();
				return max;
			}				
		}
		return max;			
	}
	
	
	//根据负责人ID号查找项目，返回所有相关的项目信息
	public List<Project> ProjectBychargeId(String _chargeId)
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();		
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getChargeId().equals(_chargeId))
				li.add(p);
		}
		return li;
	}
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	public List<Project> ProjectByleadId(String _leadId)
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();	
		String a=null;
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findProjectByleadId(_leadId);
		return l;
	}
		
	//插入新项目信息,要求项目类别号和负责人ID号事先存在(导游ID是NULL)  flag=0--插入失败  flag=1--插入成功  
	//flag=2--插入失败，项目类别号不存在  flag=3--插入失败，该ID号不是员工或者员工ID号的职称不是负责人
	public int InsertProject(Project p)
	{
		int flag=0;	//插入失败
		String _pcId=p.getPcId();
		String _chargeId=p.getChargeId();
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		List<Category> l=new ArrayList<Category>();
		List<Employee> li=new ArrayList<Employee>();		
		l=categoryDao.findAllCategory();
		li=employeeDao.findAllEmployee();
		for(Category c:l)
		{
			if(c.getcId().equals(_pcId))
			{
				for(Employee e:li)
				{
					if(e.geteId().equals(_chargeId) && e.geteTitle().equals("负责人"))
					{
						if(projectDao.insertInfoToProject(p))
						{
							flag=1;
							return flag;
						}							
						else
						{
							flag=0;
							return flag;
						}							
					}
				}
				flag=3;
				return flag;
			}
		}
		flag=2;
		return flag;
	}
	
	//更新项目的负责人,要求项目和负责人ID号都事先存在   flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在  flag=3--更新失败，该ID号不是员工或者员工ID号的职称不是负责人
	public int UpdateProjectchargeIdBypId(String _pId,String _chargeId)
	{
		int flag=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();		
		List<Project> l=new ArrayList<Project>();
		List<Employee> li=new ArrayList<Employee>();		
		l=projectDao.findAllProject();
		li=employeeDao.findAllEmployee();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				for(Employee e:li)
				{
					if(e.geteId().equals(_chargeId) && e.geteTitle().equals("负责人"))
					{
						if(projectDao.updateProjectchargeIdBypId(_pId, _chargeId))
						{
							flag=1;
							return flag;
						}
						else
						{
							flag=0;
							return flag;
						}
					}
				}
				flag=3;
				return flag;
			}
		}
		flag=2;
		return flag;		
	}
	
	//更新项目的导游，要求项目事先存在和用户信息表的状态不能为未过期(1)  flag=0--更新失败  flag=1--更新成功
	//flag=2--更新失败，项目不存在   flag=3--更新失败，该员工ID号无法做该项目的导游
	public int UpdateProjectleadIdBypId(String _pId,String _leadId)
	{
		int flag=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		List<Project> l=new ArrayList<Project>();	
		List<String> li=new ArrayList<String>();
		l=projectDao.findAllProject();
		li=employeeDao.findEmployeeByepId();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				for(String a:li)
				{
					if(a.equals(_leadId))
					{
						if(projectDao.updateProjectleadIdBypId(_pId,_leadId))
						{
							flag=1;
							return flag;
						}
						else
						{
							flag=0;
							return flag;							
						}
					}
				}
				flag=3;
				return flag;
			}
		}
		flag=2;
		return flag;		
	}
	
	//更新项目信息，要求项目类别号，项目号，员工的ID号是负责人和导游ID号(导游不能正在带领某个项目)都要事先存在
	//flag=0--更新失败  flag=1--更新成功  flag=2--更新失败，项目类别不存在 
	//flag=3--更新失败，项目不存在  flag=4--更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人 
	//flag=5--更新失败，该员工ID号无法做该项目的导游	
	public int updateProject(Project p)
	{
		int flag=0;
		String _pId=p.getpId();
		String _chargeId=p.getChargeId();
		String _leadId=p.getLeadId();
		String _pcId=p.getPcId();	
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		List<Project> l=new ArrayList<Project>();
		List<Category> li=new ArrayList<Category>();
		List<Employee> lis=new ArrayList<Employee>();	
		List<String> list=new ArrayList<String>();			
		l=projectDao.findAllProject();
		li=categoryDao.findAllCategory();
		lis=employeeDao.findAllEmployee();
		list=employeeDao.findEmployeeByepId();
		for(Category c:li)
		{
			if(c.getcId().equals(_pcId))
			{
				for(Project p1:l)
				{
					if(p1.getpId().equals(_pId))
					{
						for(Employee e:lis)
						{
							if(e.geteId().equals(_chargeId) && e.geteTitle().equals("负责人"))
							{
								for(String a:list)
								{
									if(a.equals(_leadId))
									{
										if(projectDao.updateProject(p))
										{
											flag=1;
											return flag;
										}
										else
										{
											flag=0;
											return flag;											
										}
											
									}
								}
								flag=5;
								return flag;
							}
						}
						flag=4;
						return flag;
					}
				}
				flag=3;
				return flag;
			}
		}
		flag=2;
		return flag;
	}
		
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态	flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在
	public int UpdateProject(String _pId,int _pflag)
	{
		int flag=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				if(projectDao.updateProject(_pId, _pflag))
				{
					flag=1;
					return flag;
				}
				else
				{
					flag=0;
					return flag;					
				}
			}
		}
		flag=2;
		return flag;		
	}
				
	//跟团的话负责人分配导游和修改项目的状态   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	//flag=3--更新失败，该员工ID号无法做该项目的导游
	public int UpdateProject(String _pId,String _leadId,int _pflag)
	{
		int flag=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		List<Project> l=new ArrayList<Project>();
		List<String> li=new ArrayList<String>();	
		l=projectDao.findAllProject();
		li=employeeDao.findEmployeeByepId();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				for(String a:li)
				{
					if(a.equals(_leadId))
					{
						if(projectDao.updateProject(_pId, _leadId, _pflag))
						{
							flag=1;
							return flag;
						}
						else
						{
							flag=0;
							return flag;						
						}	
					}
				}
				flag=3;
				return flag;
			}
		}
		flag=2;
		return flag;		
	}
	
	//再次推出项目时，修改项目的状态，报名时间和截止时间   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
	public int UpdateProjectBypId(String _pId,String _beginning,String _ending,int _pflag)
	{
		int flag=0;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();	
		l=projectDao.findAllProject();
		for(Project p:l)
		{
			if(p.getpId().equals(_pId))
			{
				if(projectDao.updateProjectBypId(_pId, _beginning, _ending, _pflag))
				{
					flag=1;
					return flag;	
				}
				else
				{
					flag=0;
					return flag;						
				}
			}
		}
		flag=2;
		return flag;		
	}
	
	//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
	public boolean DeleteProject()
	{
		boolean flag=false;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		if(projectDao.deleteProject())
			flag=true;
		return flag;		
	}
}
