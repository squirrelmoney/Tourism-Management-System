package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Project;
import com.lnsf.service.impl.ProjectServiceImpl;

public class Projecttest
{
/*
	DaoImpl�Ĳ�����
	public static void main(String[] args) 
	{
		List<Project> l=new ArrayList<Project>();
		ProjectDaoImpl pdi=new ProjectDaoImpl();
		l=pdi.findAllProject();
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
		System.out.println();
		
		List<Project> li=new ArrayList<Project>();
		li=pdi.findProjectByDestination("����");
		for(Project p:li)
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
		System.out.println();
		
		System.out.println(pdi.findProjectEndingBypId("p006"));
		System.out.println();
		
		List<Project> lis=new ArrayList<Project>();
		lis=pdi.findProjectBychargeId("f001");
		for(Project p:lis)
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
		System.out.println();
		
		List<Project> list=new ArrayList<Project>();
		list=pdi.findProjectByleadId("d001");
		for(Project p:list)
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
		System.out.println();		
		
		Project p=new Project("p007","�¼���3����", "�¼���", 1, "2019-05-01", "2019-05-10", 
				"9��25������7:00���ƻ����ǻ�,9��28����7:00�¼��»����ǻ��س�", 7, 15, 1, "f001",null,"c002");
		System.out.println(pdi.insertInfoToProject(p));
		System.out.println();
				
		System.out.println(pdi.updateProjectchargeIdBypId("p007", "f001"));
		System.out.println();
		
		System.out.println(pdi.updateProjectleadIdBypId("p001"));
		System.out.println();
		
		System.out.println(pdi.updateProject("p006", "f001", 1));
		System.out.println();		
		
		System.out.println(pdi.updateProject("p006", "f001", "d001", 1));
		System.out.println();
		
		System.out.println(pdi.updateProjectBypId("p006", "2010-01-02", "2010-01-28", 1));
		System.out.println();
		
		System.out.println(pdi.deleteProject());
		System.out.println();
	}
*/
	
	//ServiceImpl�Ĳ�����
	public static void main(String[] args) 
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
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
		System.out.println();
		
		System.out.println(projectService.ProjectMinBypId("p001"));
		System.out.println(projectService.ProjectMaxBypId("p001"));
		
//		List<Project> ll=new ArrayList<Project>();
//		ll=projectService.ProjectBypcId("c002");
//		for(Project p:ll)
//		{
//			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
//					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
//					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
//			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
//					+p.getMin()+"  �����������:"+p.getMax());					
//			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
//					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
//					+p.getPcId());
//			System.out.println();
//		}	
//		System.out.println();		
		
//		List<Project> li=new ArrayList<Project>();
//		li=projectService.ProjectByDestination("����");
//		for(Project p:li)
//		{
//			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
//					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
//					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
//			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
//					+p.getMin()+"  �����������:"+p.getMax());					
//			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
//					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
//					+p.getPcId());
//			System.out.println();			
//		}
//		System.out.println();
//		
//		System.out.println(projectService.ProjectEndingBypId("p001"));
//		System.out.println();
//		
//		List<Project> lis=new ArrayList<Project>();
//		lis=projectService.ProjectBychargeId("f001");
//		for(Project p:lis)
//		{
//			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
//					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
//					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
//			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
//					+p.getMin()+"  �����������:"+p.getMax());					
//			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
//					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
//					+p.getPcId());
//			System.out.println();			
//		}			
//		System.out.println();
//		
//		List<Project> list=new ArrayList<Project>();
//		list=projectService.ProjectByleadId("d001");	
//		for(Project p:list)
//		{
//			System.out.println("��Ŀ��:"+p.getpId()+"  ��Ŀ��:"+p.getpName()
//					+"  Ŀ�ĵ�:"+p.getDestination()+"  ����ʱ��:"+p.getLast()
//					+"  ����ʱ��:"+p.getBeginning()+"  ��ֹʱ��:"+p.getEnding());
//			System.out.println("��ϸ��Ϣ:"+p.getDescribing()+"  ������������:"
//					+p.getMin()+"  �����������:"+p.getMax());					
//			System.out.println("״̬:"+p.getPflag()+"  ������ID��:"+
//					p.getChargeId()+"  ����ID��:"+p.getLeadId()+"  ��Ŀ����:"
//					+p.getPcId());
//			System.out.println();			
//		}			
//		System.out.println();	

//		Project p=new Project("p007","�¼���3����", "�¼���", 1, "2019-05-01", "2019-05-10", 
//				"6��25������7:00���ƻ����ǻ�,6��28����7:00�¼��»����ǻ��س�", 7, 15, 1, "f001",null,"c002");		
//		int flag=projectService.InsertProject(p);
//		switch(flag)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("����ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ�ܣ���Ŀ���Ų�����");
//				break;
//			case 3:
//				System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
//				break;
//		}
//		System.out.println();
		
//		int flag1=projectService.UpdateProjectchargeIdBypId("p007", "f002");
//		switch(flag1)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("���³ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ�ܣ���Ŀ������");
//				break;
//			case 3:
//				System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
//				break;
//		}
//		System.out.println();
		
//		int flag2=projectService.UpdateProjectleadIdBypId("p006", "d001");
//		switch(flag2)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("���³ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ�ܣ���Ŀ������");
//				break;
//			case 3:
//				System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");		
//				break;			
//		}
//		System.out.println();		
		
		
//		Project p1=new Project("p001","�¼���3����", "�¼���", 1, "2019-05-01", "2019-05-10", 
//				"6��25������7:00���ƻ����ǻ�,6��28����7:00�¼��»����ǻ��س�", 7, 15, 1, "f003","d003","c002");	
//		int flag3=projectService.updateProject(p1);
//		switch(flag3)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("���³ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ�ܣ���Ŀ��𲻴���");
//				break;
//			case 3:
//				System.out.println("����ʧ�ܣ���Ŀ������");		
//				break;
//			case 4:
//				System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ�����");
//				break;
//			case 5:
//				System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");					
//		}
//		System.out.println();		
		
//		int flag4=projectService.UpdateProject("p001", 1);
//		switch(flag4)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("���³ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ��,��Ŀ������");
//				break;
//		}
//		System.out.println();		
		
//		int flag5=projectService.UpdateProject("p002", "d003", 2);
//		switch(flag5)
//		{
//			case 0:
//				System.out.println("����ʧ��");
//				break;
//			case 1:
//				System.out.println("���³ɹ�");	
//				break;
//			case 2:
//				System.out.println("����ʧ��,��Ŀ������");
//				break;
//			case 3:
//				System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");	
//				break;			
//		}
//		System.out.println();		
		
//		System.out.println(projectService.DeleteProject());				
	}
}
