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
	//�������е���Ŀ��Ϣ������һ��list
	public List<Project> AllProject()
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findAllProject();
		return l;
	}
	
	//�������Ų�����Ŀ������������ص���Ŀ��Ϣ
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
	
	//����Ŀ�ĵز�����Ŀ������������ص���Ŀ��Ϣ
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
	
	//������Ŀ�Ų��Ҹ���Ŀ�Ľ�ֹ����
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
	
	//������Ŀ�Ų��Ҹ���Ŀ�ı�����������
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
	
	//������Ŀ�Ų��Ҹ���Ŀ�ı����������
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
	
	
	//���ݸ�����ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
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
	
	//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public List<Project> ProjectByleadId(String _leadId)
	{
		ProjectDaoImpl projectDao=new ProjectDaoImpl();	
		String a=null;
		List<Project> l=new ArrayList<Project>();
		l=projectDao.findProjectByleadId(_leadId);
		return l;
	}
		
	//��������Ŀ��Ϣ,Ҫ����Ŀ���ź͸�����ID�����ȴ���(����ID��NULL)  flag=0--����ʧ��  flag=1--����ɹ�  
	//flag=2--����ʧ�ܣ���Ŀ���Ų�����  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
	public int InsertProject(Project p)
	{
		int flag=0;	//����ʧ��
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
					if(e.geteId().equals(_chargeId) && e.geteTitle().equals("������"))
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
	
	//������Ŀ�ĸ�����,Ҫ����Ŀ�͸�����ID�Ŷ����ȴ���   flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
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
					if(e.geteId().equals(_chargeId) && e.geteTitle().equals("������"))
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
	
	//������Ŀ�ĵ��Σ�Ҫ����Ŀ���ȴ��ں��û���Ϣ���״̬����Ϊδ����(1)  flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������   flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
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
	
	//������Ŀ��Ϣ��Ҫ����Ŀ���ţ���Ŀ�ţ�Ա����ID���Ǹ����˺͵���ID��(���β������ڴ���ĳ����Ŀ)��Ҫ���ȴ���
	//flag=0--����ʧ��  flag=1--���³ɹ�  flag=2--����ʧ�ܣ���Ŀ��𲻴��� 
	//flag=3--����ʧ�ܣ���Ŀ������  flag=4--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ����� 
	//flag=5--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���	
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
							if(e.geteId().equals(_chargeId) && e.geteTitle().equals("������"))
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
		
	//��Ŀ�Ľ�ֹʱ��֮�󣬷����������
	//�����еĻ��������޸���Ŀ��״̬	flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������
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
				
	//���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	//flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
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
	
	//�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
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
	
	//����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����
	public boolean DeleteProject()
	{
		boolean flag=false;
		ProjectDaoImpl projectDao=new ProjectDaoImpl();
		if(projectDao.deleteProject())
			flag=true;
		return flag;		
	}
}
