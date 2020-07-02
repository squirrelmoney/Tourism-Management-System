package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.InformationDaoImpl;
import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.model.Employee;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.service.impl.ProjectServiceImpl;



public class ProjectController
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	/*
	 * �û���Ȩ��
	 */

	
	/*
	 * ���ε�Ȩ��
	 */	
	//�������е���ʷ��¼��Ϣ������һ��list


	
	/*
	 * �����˵�Ȩ��
	 */
	//�������е���ʷ��¼��Ϣ������һ��list

	
	/*
	 * �����Ȩ��
	 */	
	
	//�������е���Ŀ��Ϣ������һ��list
	public List<Project> MfindAllProject()
	{
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		return l;
	}

	//���list�е�������Ŀ��Ϣ
	public void printProject(List<Project> l)
	{
		for(Project p:l)
		{
			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
					+p.getMin()+"  �����������:"+p.getMax());					
			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
					+p.getPcId());
			System.out.println();			
		}			
	}
	
	//�������Ų�����Ŀ������������ص���Ŀ��Ϣ
	public List<Project> MfindProjectBypcId(String _pcId)
	{
		return projectService.ProjectBypcId(_pcId);
	}	
	
	//����Ŀ�ĵز�����Ŀ������������ص���Ŀ��Ϣ
	public List<Project> MfindProjectByDestination(String _destination)
	{
		return projectService.ProjectByDestination(_destination);		
	}	
	
	//������Ŀ�Ų��Ҹ���Ŀ�Ľ�ֹ����
	public String MfindProjectEndingBypId(String _pId)
	{		
		return projectService.ProjectEndingBypId(_pId);
	}	
	
	//���ݸ�����ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public List<Project> MfindProjectBychargeId(String _chargeId)
	{
		return projectService.ProjectBychargeId(_chargeId);		
	}
	
	//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public List<Project> MfindProjectByleadId(String _leadId)
	{		
		return projectService.ProjectByleadId(_leadId);
	}
	
	//��������Ŀ��Ϣ,Ҫ����Ŀ���ź͸�����ID�����ȴ���(����ID��NULL)  flag=0--����ʧ��  flag=1--����ɹ�  
	//flag=2--����ʧ�ܣ���Ŀ���Ų�����  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
	public int MinsertProject()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("��Ŀ��:");	
		String pName=sc.next();
		System.out.print("Ŀ�ĵ�:");	
		String destination=sc.next();
		System.out.print("���γ���ʱ��:");
		int last=sc.nextInt();
		System.out.print("����ʱ��:");	
		String beginning=sc.next();
		System.out.print("��ֹʱ��:");	
		String ending=sc.next();
		System.out.print("��ϸ��Ϣ:");
		String describing=sc.next();
		System.out.print("������������:");	
		int min=sc.nextInt();
		System.out.print("�����������:");	
		int max=sc.nextInt();
		System.out.print("״̬:");
		int pflag=sc.nextInt();
		System.out.print("������ID��:");	
		String chargeId=sc.next();	
		String leadId=null;		
		System.out.print("��Ŀ����:");	
		String pcId =sc.next();	
		Project p=new Project
		(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);
		return projectService.InsertProject(p);
	}	
	
	//������Ŀ�ĸ�����,Ҫ����Ŀ�͸�����ID�Ŷ����ȴ���   flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
	public int MupdateProjectchargeIdBypId()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("������ID��:");	
		String chargeId=sc.next();	
		return projectService.UpdateProjectchargeIdBypId(pId, chargeId);	
	}	
	
	//������Ŀ�ĵ��Σ�Ҫ����Ŀ���ȴ��ں��û���Ϣ���״̬����Ϊδ����(1)  flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������   flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
	public int MupdateProjectleadIdBypId()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("����ID��:");	
		String leadId=sc.next();	
		return projectService.UpdateProjectleadIdBypId(pId, leadId);		
	}	
	
	//������Ŀ��Ϣ��Ҫ����Ŀ���ţ���Ŀ�ţ�Ա����ID���Ǹ����˺͵���ID��(���β������ڴ���ĳ����Ŀ)��Ҫ���ȴ���
	//flag=0--����ʧ��  flag=1--���³ɹ�  flag=2--����ʧ�ܣ���Ŀ��𲻴��� 
	//flag=3--����ʧ�ܣ���Ŀ������  flag=4--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ����� 
	//flag=5--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���	
	public int MupdateProjectinfo()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("��Ŀ��:");	
		String pName=sc.next();
		System.out.print("Ŀ�ĵ�:");	
		String destination=sc.next();
		System.out.print("���γ���ʱ��:");
		int last=sc.nextInt();
		System.out.print("����ʱ��:");	
		String beginning=sc.next();
		System.out.print("��ֹʱ��:");	
		String ending=sc.next();
		System.out.print("��ϸ��Ϣ:");
		String describing=sc.next();
		System.out.print("������������:");	
		int min=sc.nextInt();
		System.out.print("�����������:");	
		int max=sc.nextInt();
		System.out.print("״̬:");
		int pflag=sc.nextInt();
		System.out.print("������ID��:");	
		String chargeId=sc.next();	
		System.out.print("����ID��:");			
		String leadId=sc.next();
		System.out.print("��Ŀ����:");	
		String pcId =sc.next();		
		Project p=new Project
		(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);	
		return projectService.updateProject(p);
	}	
	
	//��Ŀ�Ľ�ֹʱ��֮�󣬷����������
	//�����еĻ��������޸���Ŀ��״̬	flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������
	public int MupdateProjectflag(String _pId,int _pflag)
	{
		return projectService.UpdateProject(_pId, _pflag);		
	}
	
	//���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	//flag=3--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���   flag=4--����ʧ�ܣ��������ڴ���ĳ����Ŀ�����ܸ��¸õ��ε�  
	public int MupdateProject(String _pId)
	{
		System.out.print("״̬:");
		int pflag=sc.nextInt();
		System.out.print("����ID��:");			
		String leadId=sc.next();		
		return projectService.UpdateProject(_pId, leadId, pflag);		
	}
	
	//�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	public int MupdateProjectBypId(String _pId)
	{
		System.out.print("����ʱ��:");	
		String beginning=sc.next();
		System.out.print("��ֹʱ��:");	
		String ending=sc.next();
		System.out.print("״̬:");
		int pflag=sc.nextInt();		
		return projectService.UpdateProjectBypId(_pId, beginning, ending, pflag);		
	}	
	
	//����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����
	public boolean DeleteProject()
	{
		return projectService.DeleteProject();	
	}	
}
