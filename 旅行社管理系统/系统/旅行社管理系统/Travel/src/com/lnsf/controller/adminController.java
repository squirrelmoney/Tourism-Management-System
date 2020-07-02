package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IbookDao;
import com.lnsf.dao.IsalaryDao;
import com.lnsf.dao.impl.BookDaoImpl;
import com.lnsf.dao.impl.SalaryDaoImpl;
import com.lnsf.model.Book;
import com.lnsf.model.Category;
import com.lnsf.model.Employee;
import com.lnsf.model.Financing;
import com.lnsf.model.Information;
import com.lnsf.model.Project;
import com.lnsf.model.ProjectHistory;
import com.lnsf.model.Salary;
import com.lnsf.model.User;
import com.lnsf.model.Word;
import com.lnsf.service.IbookService;
import com.lnsf.service.IemployeeService;
import com.lnsf.service.IfinacingService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.IsalaryService;
import com.lnsf.service.IuserService;
import com.lnsf.service.IwordService;
import com.lnsf.service.impl.BookServiceImpl;
import com.lnsf.service.impl.CategoryServiceImpl;
import com.lnsf.service.impl.EmployeeServiceImpl;
import com.lnsf.service.impl.FinancingServiceImpl;
import com.lnsf.service.impl.InformationServiceImpl;
import com.lnsf.service.impl.ProjectHistoryServiceImpl;
import com.lnsf.service.impl.ProjectServiceImpl;
import com.lnsf.service.impl.SalaryServiceImpl;
import com.lnsf.service.impl.UserServiceImpl;
import com.lnsf.service.impl.WordServiceImpl;

public class adminController
{

	/*--------------------------------�鿴��Ϣ-------------------------------*/

	//��ѯ��������
	public boolean adminAllBook(){
		boolean flag=false;
		IbookService bs=new BookServiceImpl();
		if(bs.AllBook().size()>0){
		for (Book a : bs.AllBook()) {
			System.out.println(a);
			flag=true;
		}
		}else{
			System.out.println("ԤԼ����������");
		}
		return flag;
	}
		
	//�������е�Ա����Ϣ����
	public boolean AllEmployee() {
		boolean flag=false;
		IemployeeService es=new EmployeeServiceImpl();
			if(es.AllEmployee().size()>0){
				for (Employee a :es.AllEmployee()) {
					System.out.println(a);
					flag=true;
				}
				}else{
					System.out.println("Ա������������");
				}
				return flag;
	}
	//�������в��񡣡�
	public boolean AllFinancing(){
		boolean flag=true;
		IfinacingService fs=new FinancingServiceImpl();
		if(fs.AllFinancing().size()>0){
			for (Financing f : fs.AllFinancing()) {
				System.out.println(f);
				flag=true;
			}
		}
		return flag;
	}
	
	//�������е��û���Ϣ������һ��list����
	public boolean AllInformation() {
		boolean flag=true;
		IinformationService fs=new InformationServiceImpl();
		if(fs.AllInformation().size()>0){
			for (Information f : fs.AllInformation()) {
				System.out.println(f);
				flag=true;
			}
		}
		return flag;
}



	//����ȫ���û���¼��Ϣ�������б�Ҫ�������û��Լ������Ȩ�ޡ���
	public boolean AllUser(){
    	boolean flag=false;
    	IuserService iw=new UserServiceImpl();
    		if(iw.AllUser().size()>0){
    			for (User i : iw.AllUser()) {
    				System.out.println(i);
				}
    			
			 flag=true;
			 }else{
				 System.out.println("û���û���¼��Ϣ");
			 }
			 return flag;			 
    	}



     //ccc��ѯ�����ȴ�	����
    public boolean AllWord(){
    	boolean flag=false;
    	IwordService iw=new WordServiceImpl();
    	if
    	(iw.AllWord().size()>0){
    		for (Word  a: iw.AllWord()) {
    			System.out.println(a);
			}
    		
    		flag=true;
    	}else{
    		System.out.println("û���ȴ�");
    	}
		return flag;
    }


	//ccc�������й�����Ϣ..
	public boolean AllSalary(){
    	boolean flag=false;
    	IsalaryService iw=new SalaryServiceImpl();
    		if(iw.AllSalary().size()>0){
    			for (Salary i : iw.AllSalary()) {
    				System.out.println(i);
				}
    			
			 flag=true;
			 }else{
				 System.out.println("û��Ա��������Ϣ");
			 }
			 return flag;			 
    	}







/*--------------------------------Ա������	--------------------------------*/
//���Ա��	����
public boolean eInsertEmployee() {
	IemployeeService es=new EmployeeServiceImpl();
	return es.InsertEmployee();
}

	//������Ա��������Ϣ..
//	���룬�Ȳ����µ���Ϣ��Ա�����ٲ��빤�ʱ������ǹ��ʱ�
	public int insertSalary(String _seId){
		int flag=0;
		Salary s =new Salary(null, 0, 0, 0);
		IsalaryService iw=new SalaryServiceImpl();
		s.setSeId(_seId);
		s.setReward(0);
		flag=iw.insertSalary(_seId);
		if(flag==1){
			System.out.println("�ɹ�����Ա�����ʵ�");
		}
		else{
			System.out.println("����ʧ��");
		}
		return flag;
	}


//�����ֻ���ɾ����ĳԱ����ְ�򱻳�����
public boolean eDeleteBookByTel() {
	boolean flag=false;
	IbookDao i=new BookDaoImpl();
	System.out.println("��������Ҫɾ�����˺�");
	Scanner in=new Scanner(System.in);
	String _tel=in.nextLine();
	flag=i.deleteBookByTel(_tel);
	if(flag==false){
		System.out.println("ɾ���˺�ʧ�ܣ�����");
	}
	return flag;
}






		//ccc���¹���..
         public int updateSalary(String _seId,Double _baseSalary,Double _insurance,Double _reward){
        	 int flag=0;
        	 Salary s= new Salary(null, 0, 0, 0);
        	 IsalaryService iw=new SalaryServiceImpl();
        	 s.setSeId(_seId);
        	 s.setBaseSalary(_baseSalary);
        	 s.setInsurance(_insurance);
        	 s.setReward(_reward);  
        		flag=iw.updateSalary(s);
//        		if(flag==2){
//        			System.out.println("����ʧ��");
//        		}
        		 if(flag==1){
        			System.out.println("�ɹ�����Ա�����ʵ�");
        		}
        		else if(flag!=1){
        			System.out.println("û������ţ�����ʧ��");
        		}
        		return flag;
         }
		
         
         
     	//ccc���½���
     	public int updateReward(String _seId,Double _reward){
             int flag=0;
             Salary s=new Salary(null, 0, 0, 0);   
             IsalaryService is=new SalaryServiceImpl();
             s.setSeId(_seId);
             s.setReward(_reward);
             flag=is.updateReward(s);
     		return flag;
     		 
     	}

    	//ccc����Ա���Ų��ҹ���
    	public boolean SalaryBycId(String _seId){
    		boolean flag =false;
    		IsalaryService iw=new SalaryServiceImpl();
            iw.SalaryBycId(_seId);
            if(iw.SalaryBycId(_seId).size()>0){
            	System.out.println("��Ա��������ϢΪ"+iw.SalaryBycId(_seId));
            	flag=true;
            }else{
            	System.out.println("�Ҳ�����Ա������");
            }
    		return flag;
    		}

    	


	//����Ա(����)�޸��û�Ȩ�ޡ���
	public int updateUser1(String _uTel,int _uSuper){
		int flag=0;
		IuserService is = new UserServiceImpl();
		User u =new User(null, null, 0);
		u.setuTel(_uTel);
		u.setuSuper(_uSuper);
		flag=is.updateUser1(u);
	    if(flag==1){
	    	System.out.println("�޸�Ȩ�޳ɹ�");
	    }
	    else{
	    	System.out.println("û�д��˻����޸�ʧ��");
	    }
		return flag;
	}


/*--------------------------------��Ŀ����	--------------------------------*/
//����һ���µ���Ŀʱ
//����һ��������Ϣ
public boolean InsertProjectAndFinancing(String _fpId){
	//��Ŀ��Ϣ¼��
	IfinacingService fs=new FinancingServiceImpl();
	return fs.InsertFinancing(_fpId);
	}





/*--------------------------------�������	--------------------------------*/
//���»����ĳɱ��۸�
public boolean UpdateFinancing(String _fpId){ 
	boolean flag=false;
	Scanner in=new Scanner(System.in);
	IfinacingService fs=new FinancingServiceImpl();
	Financing f=new Financing(null, 0, 0, 0, 0);
	    f.setFpId(_fpId);
		System.out.println("���˳ɱ���");
		f.setBasepay(in.nextDouble());
		System.out.println("���ѣ�" );
		f.setRoompay(in.nextDouble());
		System.out.println("�����ѣ�");
		f.setPoundage(in.nextDouble());
		f.setProfit(0);
		flag=fs.UpdateFinancing(f);
		return flag;
}
//������Ŀ�Ÿ�������
public boolean UpdateProfit(){
	Scanner in=new Scanner(System.in);
	IfinacingService fs=new FinancingServiceImpl();
	return fs.UpdateProfit();
	
}


//ccc���½���
public int updateReward(String _seId){
       int flag=0;
       Salary s=new Salary(null, 0, 0, 0);   
       IsalaryService is=new SalaryServiceImpl();
       s.setSeId(_seId);
       //s.setReward(_reward);
       flag=is.updateReward(s);
 return flag;
  
}
















Scanner sc=new Scanner(System.in);
public static adminController adminControl=new adminController();

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
public void MfindAllProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	List<Project> l=new ArrayList<Project>();
	l=projectService.AllProject();
	adminControl.printProject(l);
}

//�������е������Ϣ
public void MfindAllCategory()
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
public void MfindAllProjectHistory()
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



/*--------------------------------������ --------------------------------*/

//�����������Ϣ
public void MinsertCategory()
{
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	System.out.print("���������ţ�");
	String cId=sc.next();
	System.out.print("������������ƣ�");
	String cName=sc.next();		
	Category c=new Category(cId, cName);
	switch(categoryService.InsertCategory(c))
	{						
		case 0:
			System.out.println("����ʧ��");
			break;
		case 1:
			System.out.println("����ɹ�");
			break;
		case 2:
			System.out.println("����ʧ�ܣ�����Լ��");		
			break;
	}			
}	

//���������Ϣ
public void MupdateCategory()
{
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	System.out.print("���������ţ�");
	String cId=sc.next();
	System.out.print("������������ƣ�");
	String cName=sc.next();		
	Category c=new Category(cId, cName);
	switch(categoryService.UpdateCategory(c))
	{						
		case 0:
			System.out.println("����ʧ��");
			break;
		case 1:
			System.out.println("���³ɹ�");
			break;
		case 2:
			System.out.println("����ʧ�ܣ����Ų�����");		
			break;
	}
}	


//???	
/*--------------------------------��ʷ��¼���� --------------------------------*/

//��������ʷ��¼��Ϣ���߸��¸�����ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���  
//flag=0--����ʧ��    flag=1--�����ɹ�   
//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
public int MhandleProjectHistory(String _hpId)
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



/*--------------------------------��Ŀ���� --------------------------------*/	

//��������Ŀ��Ϣ,Ҫ����Ŀ���ź͸�����ID�����ȴ���(����ID��NULL)  flag=0--����ʧ��  flag=1--����ɹ�  
//flag=2--����ʧ�ܣ���Ŀ���Ų�����  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
public void MinsertProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
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
	switch(projectService.InsertProject(p))
	{
		case 0:
				System.out.println("����ʧ��");
				break;
		case 1:
				System.out.println("����ɹ�");	
				break;
		case 2:
				System.out.println("����ʧ�ܣ���Ŀ���Ų�����");
				break;
		case 3:
				System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
				break;
	}		
}	

//������Ŀ�ĸ�����,Ҫ����Ŀ�͸�����ID�Ŷ����ȴ���   flag=0--����ʧ��  flag=1--���³ɹ�
//flag=2--����ʧ�ܣ���Ŀ������  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
public void MupdateProjectchargeIdBypId()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("��Ŀ��:");
	String pId=sc.next();
	System.out.print("������ID��:");	
	String chargeId=sc.next();	
	switch(projectService.UpdateProjectchargeIdBypId(pId, chargeId))
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
			System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
			break;
	}		
}	

//������Ŀ��Ϣ��Ҫ����Ŀ���ţ���Ŀ�ţ�Ա����ID���Ǹ����˺͵���ID��(���β������ڴ���ĳ����Ŀ)��Ҫ���ȴ���
//flag=0--����ʧ��  flag=1--���³ɹ�  flag=2--����ʧ�ܣ���Ŀ��𲻴��� 
//flag=3--����ʧ�ܣ���Ŀ������  flag=4--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ����� 
//flag=5--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���	
public void MupdateProjectinfo()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
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
	switch(projectService.updateProject(p))
	{
		case 0:
			System.out.println("����ʧ��");
			break;
		case 1:
			System.out.println("���³ɹ�");	
			break;
		case 2:
			System.out.println("����ʧ�ܣ���Ŀ��𲻴���");
			break;
		case 3:
			System.out.println("����ʧ�ܣ���Ŀ������");		
			break;
		case 4:
			System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ�����");
			break;
		case 5:
			System.out.println("����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���");		
			break;		
	}			
}

//�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
public void MupdateProjectBypId()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("��Ŀ��:");
	String pId=sc.next();		
	System.out.print("����ʱ��:");	
	String beginning=sc.next();
	System.out.print("��ֹʱ��:");	
	String ending=sc.next();
	System.out.print("״̬:");
	int pflag=sc.nextInt();
	switch(projectService.UpdateProjectBypId(pId, beginning, ending, pflag))
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

//����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����
public void DeleteProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	if(projectService.DeleteProject())
		System.out.println("ɾ���ɹ�");
	else
		System.out.println("ɾ��ʧ��");
}		


/*--------------------------------Ա������ --------------------------------*/



//���Ա��	
public boolean eInsertEmployee1() {
	IemployeeService es=new EmployeeServiceImpl();
	return es.InsertEmployee();
}



//��Ա����ְ�ˣ��޸��û���¼���Ȩ��,�޸�Ա���Ļ�������
//����ְ�󣬸����µ�Ա���ţ����޸���Ŀ��
public boolean UpdateEmployeeTitleByeId(String _eId){
	boolean flag=false;
	int uflag=0;
	ProjectServiceImpl p=new ProjectServiceImpl(); 
	IemployeeService es=new EmployeeServiceImpl();
	List<Project> list=new ArrayList<Project>();
	list=p.ProjectByleadId(_eId);
	 if(es.UpdateEmployeeTitleByeId(_eId)){
		 if(list.size()>0){
			 System.out.println("��Ա�����ڸ���"+list.size()+"����Ŀ�����ȸ��ĸ����Ա��");
			 System.out.println("���е�Ա���У�");
			 es.findEmployeeByepId();
			 for (Project p1 : list) {
				 String _leaderId=sc.nextLine();
				 int n=p.UpdateProjectleadIdBypId(p1.getpId(), _leaderId);
				 if(n==1){
				 uflag++;
				 }
				 }
			}
		 if(uflag==list.size()){
			flag=es.reNewEmployeeTitleByeId(_eId);
			 
	 }
	  }else{//����ְΪ
		 flag=es.reNewEmployeeTitleByeId(_eId); 
	 }
	 return flag;
	}

//ccc���½���
public int updateReward1(String _seId){
       int flag=0;
       double   _reward=0;
       Salary s=new Salary(null, 0, 0, 0);  
       ProjectServiceImpl p=new ProjectServiceImpl(); 
       IsalaryService is=new SalaryServiceImpl();
      
       int n=0;
       if(p.ProjectByleadId(_seId).size()>0){
       n=p.ProjectByleadId(_seId).size();
       }else if(p.ProjectBychargeId(_seId).size()>0){
    	   n=p.ProjectBychargeId(_seId).size();
       }
       for (Salary s1 : is.AllSalary()) {
    	if(s1.getSeId().equals(_seId)){
    		_reward=n*s1.getBaseSalary()*0.2;
    		s.setBaseSalary(s1.getBaseSalary());
    		s.setInsurance(s1.getInsurance());
    	}
		
	  }
       s.setSeId(_seId);
       s.setReward(_reward);
       flag=is.updateReward(s);
     return flag;
  
}
}