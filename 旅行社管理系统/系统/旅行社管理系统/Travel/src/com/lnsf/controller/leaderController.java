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
	
	//��Ա���޸ĵ绰���룬�޸��û���¼��ĵ绰����
		public boolean UpdateEmployeeTelByeId(String old_eTel)
		{
			boolean flag=false;
			IemployeeService es=new EmployeeServiceImpl();
			flag=es.UpdateEmployeeTelByeId(old_eTel);
			return flag;
			
		}
		
		//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
		public void MfindProjectByleadId(String _leadId)
		{		
			ProjectServiceImpl projectService=new ProjectServiceImpl();
			List<Project> l=new ArrayList<Project>();
			l=projectService.ProjectByleadId(_leadId);
			leaderControl.printProject(l);
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
}
