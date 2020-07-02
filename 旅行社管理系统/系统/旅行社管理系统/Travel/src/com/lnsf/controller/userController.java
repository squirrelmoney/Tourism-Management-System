package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IinformationDao;
import com.lnsf.dao.impl.InformationDaoImpl;
import com.lnsf.model.Book;
import com.lnsf.model.Category;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.model.User;
import com.lnsf.model.Word;
import com.lnsf.service.IbookService;
import com.lnsf.service.IuserService;
import com.lnsf.service.IwordService;
import com.lnsf.service.impl.BookServiceImpl;
import com.lnsf.service.impl.CategoryServiceImpl;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;
import com.lnsf.service.impl.ProjectServiceImpl;
import com.lnsf.service.impl.UserServiceImpl;
import com.lnsf.service.impl.WordServiceImpl;

public class userController
{
	Scanner sc=new Scanner(System.in);
	public static userController userControl=new userController();
	
	/*--------------------------------��Ҫ�õķ��������ù�-------------------------------*/	
	
    //n����������»�����ȴ���Ϣ
    public void UpdateWord(String _wpName)
    {
		Word w=new Word(null, 0);
		IwordService iw=new WordServiceImpl();
		w.setWpName(_wpName);
		 int flag=iw.UpdateWord(w);
		 if (flag==1)
		 {
			 System.out.println("ԭ�����е�����£�number��1");
		 }
		 else if(flag==2)
		 {
			 System.out.println("��һ����������������ʣ�number=1");
		 }
		 else if(flag==0)
		 {
			 System.out.println("����ʧ��");
		 }	
    }	
	
	//����һ����Ŀ�μӵ�����
	public int eCountNumBypId(String _bpId){
		int n=0;
		IbookService bs=new BookServiceImpl();
		n=bs.CountNumBypId(_bpId);
		return n;
	}	
	
	
	
	/*--------------------------------�鿴��Ϣ-------------------------------*/
	//�����ֻ��Ų������е�ԤԼ��Ϣ
	public boolean nBookByTel(String _bTel){
		boolean flag=false;
		IbookService bs=new BookServiceImpl();
		if(bs.AllBook().size()>0){
		for (Book a : bs.BookBybTel(_bTel)) {
			System.out.println(a);
			flag=true;
			}
		}else{
			System.out.println("����δ�ж���");
		}
		return flag;
	}
	
	//n���ݵ绰�������������˻���Ϣ������һ��list
	public List<User> Login(String _uTel,String _uPassWord){
		boolean flag=false;
		IuserService iw=new UserServiceImpl();
		iw.Login(_uTel, _uPassWord);
		if(iw.Login(_uTel, _uPassWord).size()>0){
    		System.out.println("���û�Ȩ��Ϊ"+iw.Login(_uTel, _uPassWord));
    		flag=true;
    	}else{
    		System.out.println("�����绰���������");
    	}
		return iw.Login(_uTel, _uPassWord);
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
	
	//�������е���Ŀ��Ϣ������һ��list
	public void UfindAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		userControl.printProject(l);
	}	
	
	
	
	
	/*--------------------------------����-------------------------------*/
	
	//����Ŀ�ĵ�������Ŀ
	public void UfindProjectByDestination()
	{
		System.out.print("������Ŀ�ĵ�:");
		String destination=sc.next();
		userControl.UpdateWord(destination); 		
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		l=projectService.ProjectByDestination(destination);
		li=projectService.AllProject();
		userControl.printProject(l);
		System.out.print("��������Ҫȥ���ε���Ŀ��:");
		String pId=sc.next();
		for(Project p:li)
		{
			if(p.getpId().equals(pId) && p.getPcId().equals("c001"))
			{
				int num=userControl.eCountNumBypId(pId);
				if(num>=p.getMax())
				{
					System.out.println("����Ŀ�����ˣ��޷������μ�");
					/*
					 * ���ŵĻ�
					 * ���õȴ���Ŀ�Ľ�ֹʱ�䣬������ѡ���Σ��жϵ����Ƿ����
					 * �ı��û�ҳ��ı���״̬
					 * ��ԤԼ����Ϣ���뵽�û���Ϣ��
					 */
				}
				else
					userControl.userInsertBook(p.getpId());
			}
			if(p.getpId().equals(pId) && p.getPcId().equals("c002"))	
			{
				userControl.userInsertBook(p.getpId());
			}
		}	
	}
	
	
	
	
	//��������������Ŀ
	public void UfindProjectBypcId()
	{
		System.out.print("�������������:");
		String cName=sc.next();
		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		String pcId=categoryService.CategorycIdBycName(cName);
		List<Project> l=new ArrayList<Project>();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		l=projectService.ProjectBypcId(pcId);
		userControl.printProject(l);
		System.out.print("��������Ҫȥ���ε���Ŀ��:");
		String pId=sc.next();
		for(Project p:l)
		{
			if(p.getpId().equals(pId) && p.getPcId().equals("c002"))
			{

			}
			if(p.getpId().equals(pId) && p.getPcId().equals("c001"))
			{
				int num=userControl.eCountNumBypId(pId);
				if(num>=p.getMax())
				{
					System.out.println("����Ŀ�����ˣ��޷������μ�");
					/*
					 * ���ŵĻ�
					 * ���õȴ���Ŀ�Ľ�ֹʱ�䣬������ѡ���Σ��жϵ����Ƿ����
					 * �ı��û�ҳ��ı���״̬
					 * ��ԤԼ����Ϣ���뵽�û���Ϣ��
					 */
				}
				else
				{
					userControl.userInsertBook(p.getpId());
				}				
			}
		}
	}
	
	
	
	/* -----------------------------------������Ŀ---------------------------------------*/
	//������ԤԼ��Ϣ��Ҫ����Ŀ���ȴ���
	public  int userInsertBook(String _bpId){
		int flag=0;
		Book b=new Book(null, null, null, null, 0, 0);
		IbookService bs=new BookServiceImpl();
		Scanner in=new Scanner(System.in);
		b.setBpId(_bpId);
		b.setBflag(1);
		System.out.println("�绰��");
		b.setbTel(in.nextLine());
		System.out.println("������");
		b.setbName(in.nextLine());
		System.out.println("���֤��");
		b.setbNum(in.nextLine());
		System.out.println("Ҫ���ķ��䣺");
		b.setBroom(in.nextInt());
		flag=bs.InsertBook(b);
		if(flag==1){
			System.out.println("ԤԼ�ɹ�");
		}else if(flag==2){
			System.out.println("���Ѿ��μӸ���Ŀ��");
		}
		else if(flag==0){
			System.out.println("�����Ų����ڻ��ѽ���������ԤԼʧ��");
		}
		return flag;
	}
    
	
	//n�������û����û�ע�ᣩ
	public boolean InsertUser(String _uTel,String _uPassWord){
		boolean flag=false;
		IuserService iw=new UserServiceImpl();
		iw.InsertUser(_uTel, _uPassWord);
		return flag;
	}
	
	

	/* -----------------------------------������Ϣ---------------------------------------*/
	
	//�����ֻ���ɾ��----------------ע���˺�ʱ
		public boolean deleteInformationByTel(String _iTel) {
				boolean flag=false;
				IinformationDao i=new InformationDaoImpl();
				flag=i.deleteInformationByTel(_iTel);
				return flag;
			}

	 //������Ϣ���˺�-----------------�޸��˺�ʱ
		public boolean updateInformationByiTel(String old_bTel, String new_bTel) {
			boolean flag=false;
			IinformationDao i=new InformationDaoImpl();
		    for (Information i1 : i.findAllInformation()) {
				if(i1.getiTel().equals(old_bTel)){
					Information m=new Information(new_bTel, i1.getIpId(), i1.getiName(),
							i1.getiNum(), i1.getIroom(),i1.getItimes() , i1.getIflag());
					flag=i.updateInformation(m,i1.getiTel());
				}
			}
			return flag;
		}
		//����ԤԼ��Ϣ���ֻ�------------�޸��˺�ʱ
		public boolean eupdateBookbflagBybbTel(String _bpId,String _bTel){
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			Scanner in=new Scanner(System.in);
			flag=bs.updateBookbflagBybbTel(_bpId, _bTel);
		    if(flag==false){
				System.out.println("����ԤԼ��Ϣ���˺�ʧ�ܣ�����");
			}
			return flag;
		}
		
		
		//����user����˻����루�޸��˻����룩
		  public int updateUser(User u){
		   int flag=0;
		   IuserService iw=new UserServiceImpl();
		   Scanner in = new Scanner(System.in);
		   System.out.println("��ѡ����Ҫ�����ı��");
		   while(true){
		   System.out.println("1.�޸����� 2.�޸��˻� 3.ע���˻� 4.����");
		   int n=in.nextInt();
		   if(n==1||n==2){
		    flag=iw.updateUser(u, n);
		    
		    break;//��¼һ��ֻ���޸�һ�Σ������޸ĵڶ���Ҫ�����˺������¼���޸�
		   }else if(n==3){
		    System.out.println("��ȷ��Ҫע���������Ϣ����ȫ�����Y/N");
		    String str=in.next();
		    if(str.equals("Y")){
		       flag=iw.deleteUser(u.getuTel());
		    }else
		    {
		       break;
		       }
		    break;
		   }else if(n==4){
		    break;
		   }else{
		    System.out.println("������1��2��3��4");
		   }
		   }
		   return flag;

		  }	
}
