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
	
	/*--------------------------------�鿴��Ϣ-------------------------------*/
	
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
	
	//�������е���Ŀ��Ϣ������һ��list
	public void findAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		chargerControl.printProject(l);
	}	
	
	//���ݸ�����ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	public void findProjectBychargeId()
	{
		System.out.print("�����븺����ID��:");
		String chargeId=sc.next();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();		
		l=projectService.ProjectBychargeId(chargeId);	
		chargerControl.printProject(l);			
	}
	
	//�������е������Ϣ
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
	
	//�������е���ʷ��¼��Ϣ������һ��list
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

	
	
	/*--------------------------------��Ŀ���� --------------------------------*/	
	
	//������Ŀ�ĵ��Σ�Ҫ����Ŀ���ȴ��ں��û���Ϣ���״̬����Ϊδ����(1)  flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������   flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
	public void updateProjectleadIdBypId()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("����ID��:");	
		String leadId=sc.next();		
		switch(projectService.UpdateProjectleadIdBypId(pId, leadId))
		{
		case 0:
			System.out.println("����ʧ��");
			break;
		case 1:
			System.out.println("���³ɹ�");	
			break;
		case 2:
			System.out.println("����ʧ�ܣ���Ŀ������");
			break;
		case 3:
			System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");		
			break;			
		}
	}
	
	//��Ŀ�Ľ�ֹʱ��֮�󣬷����������
	//�����еĻ��������޸���Ŀ��״̬	flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������
	public int updateProjectflag(String pId)
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		return projectService.UpdateProject(pId, 2);
	}
	
	//���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	//flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
	public int updateProjectleadIDandflag(String pId,int pflag,String leadId)
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		return projectService.UpdateProject(pId, leadId, pflag);
	}
	
	public void MupdateProjectflag()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("״̬:");
		int pflag=sc.nextInt();
		ProjectServiceImpl projectService=new ProjectServiceImpl();		
		switch(projectService.UpdateProject(pId, pflag))
		{
			case 0:
				System.out.println("����ʧ��");
				break;
			case 1:
				System.out.println("���³ɹ�");	
				break;
			case 2:
				System.out.println("����ʧ��,��Ŀ������");
				break;		
		}			
	}

	public void MupdateProject()
	{
		System.out.print("��Ŀ��:");
		String pId=sc.next();
		System.out.print("״̬:");
		int pflag=sc.nextInt();
		System.out.print("����ID��:");			
		String leadId=sc.next();	
		ProjectServiceImpl projectService=new ProjectServiceImpl();	
		switch(projectService.UpdateProject(pId, leadId, pflag))
		{
			case 0:
				System.out.println("����ʧ��");
				break;
			case 1:
				System.out.println("���³ɹ�");	
				break;
			case 2:
				System.out.println("����ʧ��,��Ŀ������");
				break;
			case 3:
				System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");	
				break;		
		}				
	}	
	
	//��������ʷ��¼��Ϣ���߸��¸�����ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���  
	//flag=0--����ʧ��    flag=1--�����ɹ�   
	//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
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
	
	
	//---------------------------����-----------------------------
	/*
	 * ������Ŀ�Ľ�ֹʱ���޸���������Ŀ��״̬
	 */
	public void selfending()
	{
		System.out.print("����������:");
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
		 * ������Ŀ�Ľ�ֹʱ���޸ĸ�������Ŀ��״̬
		 */
		public void group()
		{
			System.out.print("����������:");
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
						System.out.print("�����뵼��ID��:");
						String leadId=sc.next();
						if(informationService.InsertInformationFromBook(p.getpId()))
						{
							if(chargerControl.updateProjectleadIDandflag(p.getpId(), 2, leadId)==1)
								System.out.println("��Ŀ˳����չ");
						}
							
					}
					if(num>0 && num<min)
					{				
						if(chargerControl.updateProjectflag(p.getpId())==1);
							System.out.println("�����˲μ���Ŀ");
					}
					if(num==0)
					{
						if(chargerControl.handleProjectHistory(p.getpId())==1)
								System.out.println("û�˲μ���Ŀ");								
					}
				}				
			}
		}		
	

	
	
	

	
	
	
	/* -----------------------------------������Ϣ---------------------------------------*/
		//������Ŀ�Ų������е�ԤԼ��Ϣ
		public boolean eBookBypId(String _pId){
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			if(bs.BookBypId(_pId).size()>0){
			for (Book a : bs.BookBypId(_pId)) {
				System.out.println(a);
				flag=true;
			}
			}else{
				System.out.println("ԤԼ����������");
			}
			return flag;
		}
		//�����˻��ߵ��θ�����Ŀ�Ų����û���Ϣ�����زμ������Ŀ�������û���Ϣ
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
		
		
		
		
		
		
		
		
	/* -----------------------------------������Ϣ---------------------------------------*/
		//����һ����Ŀ�μӵ�����
		public int eCountNumBypId(String _bpId){
			int n=0;
			IbookService bs=new BookServiceImpl();
			n=bs.CountNumBypId(_bpId);
			return n;
		}
		//��ԤԼ��������û���Ϣ
		public boolean InsertInformationFromBook(String _ipId) {
			boolean flag=false;
			IinformationService fs=new InformationServiceImpl();
			flag=fs.InsertInformationFromBook(_ipId);
			return flag;
		}
		//����ԤԼ��Ϣ��״̬
		public boolean eupdateBookbflagBybpId(String _bpId) {
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			Scanner in=new Scanner(System.in);
			int _bflag=0;
			_bflag=in.nextInt();
			flag=bs.updateBookbflagBybpId(_bpId, _bflag);
			if(flag==false){
				System.out.println("����ԤԼ��Ϣʧ�ܣ�����");
			}
			in.close();
			return flag;
		}	
		//��ʱɾ��ԤԼ��Ϣ
		public boolean eDeleteBook(String _bpId) {
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			flag=bs.DeleteBook(_bpId);
			if(flag==false){
				System.out.println("ɾ��ԤԼ��Ϣʧ�ܣ�����");
			}
			return flag;
		}	
	
}
