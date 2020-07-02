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

	/*--------------------------------查看信息-------------------------------*/

	//查询订单表。。
	public boolean adminAllBook(){
		boolean flag=false;
		IbookService bs=new BookServiceImpl();
		if(bs.AllBook().size()>0){
		for (Book a : bs.AllBook()) {
			System.out.println(a);
			flag=true;
		}
		}else{
			System.out.println("预约表暂无数据");
		}
		return flag;
	}
		
	//查找所有的员工信息。。
	public boolean AllEmployee() {
		boolean flag=false;
		IemployeeService es=new EmployeeServiceImpl();
			if(es.AllEmployee().size()>0){
				for (Employee a :es.AllEmployee()) {
					System.out.println(a);
					flag=true;
				}
				}else{
					System.out.println("员工表暂无数据");
				}
				return flag;
	}
	//查找所有财务。。
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
	
	//查找所有的用户信息，返回一个list。。
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



	//查找全部用户登录信息，经理有必要看所有用户以及密码和权限。。
	public boolean AllUser(){
    	boolean flag=false;
    	IuserService iw=new UserServiceImpl();
    		if(iw.AllUser().size()>0){
    			for (User i : iw.AllUser()) {
    				System.out.println(i);
				}
    			
			 flag=true;
			 }else{
				 System.out.println("没有用户登录信息");
			 }
			 return flag;			 
    	}



     //ccc查询所有热词	。。
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
    		System.out.println("没有热词");
    	}
		return flag;
    }


	//ccc查找所有工资信息..
	public boolean AllSalary(){
    	boolean flag=false;
    	IsalaryService iw=new SalaryServiceImpl();
    		if(iw.AllSalary().size()>0){
    			for (Salary i : iw.AllSalary()) {
    				System.out.println(i);
				}
    			
			 flag=true;
			 }else{
				 System.out.println("没有员工工资信息");
			 }
			 return flag;			 
    	}







/*--------------------------------员工管理	--------------------------------*/
//添加员工	。。
public boolean eInsertEmployee() {
	IemployeeService es=new EmployeeServiceImpl();
	return es.InsertEmployee();
}

	//插入新员工工资信息..
//	插入，先插入新的信息到员工表，再插入工资表，下面是工资表
	public int insertSalary(String _seId){
		int flag=0;
		Salary s =new Salary(null, 0, 0, 0);
		IsalaryService iw=new SalaryServiceImpl();
		s.setSeId(_seId);
		s.setReward(0);
		flag=iw.insertSalary(_seId);
		if(flag==1){
			System.out.println("成功插入员工工资单");
		}
		else{
			System.out.println("插入失败");
		}
		return flag;
	}


//根据手机号删除，某员工辞职或被炒。。
public boolean eDeleteBookByTel() {
	boolean flag=false;
	IbookDao i=new BookDaoImpl();
	System.out.println("请输入你要删除的账号");
	Scanner in=new Scanner(System.in);
	String _tel=in.nextLine();
	flag=i.deleteBookByTel(_tel);
	if(flag==false){
		System.out.println("删除账号失败，请检查");
	}
	return flag;
}






		//ccc更新工资..
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
//        			System.out.println("更新失败");
//        		}
        		 if(flag==1){
        			System.out.println("成功更新员工工资单");
        		}
        		else if(flag!=1){
        			System.out.println("没有这个号，更新失败");
        		}
        		return flag;
         }
		
         
         
     	//ccc更新奖金
     	public int updateReward(String _seId,Double _reward){
             int flag=0;
             Salary s=new Salary(null, 0, 0, 0);   
             IsalaryService is=new SalaryServiceImpl();
             s.setSeId(_seId);
             s.setReward(_reward);
             flag=is.updateReward(s);
     		return flag;
     		 
     	}

    	//ccc根据员工号查找工资
    	public boolean SalaryBycId(String _seId){
    		boolean flag =false;
    		IsalaryService iw=new SalaryServiceImpl();
            iw.SalaryBycId(_seId);
            if(iw.SalaryBycId(_seId).size()>0){
            	System.out.println("此员工工资信息为"+iw.SalaryBycId(_seId));
            	flag=true;
            }else{
            	System.out.println("找不到此员工工资");
            }
    		return flag;
    		}

    	


	//管理员(经理)修改用户权限。。
	public int updateUser1(String _uTel,int _uSuper){
		int flag=0;
		IuserService is = new UserServiceImpl();
		User u =new User(null, null, 0);
		u.setuTel(_uTel);
		u.setuSuper(_uSuper);
		flag=is.updateUser1(u);
	    if(flag==1){
	    	System.out.println("修改权限成功");
	    }
	    else{
	    	System.out.println("没有此账户，修改失败");
	    }
		return flag;
	}


/*--------------------------------项目管理	--------------------------------*/
//插入一个新的项目时
//插入一个财务信息
public boolean InsertProjectAndFinancing(String _fpId){
	//项目信息录入
	IfinacingService fs=new FinancingServiceImpl();
	return fs.InsertFinancing(_fpId);
	}





/*--------------------------------财务管理	--------------------------------*/
//更新基本的成本价格
public boolean UpdateFinancing(String _fpId){ 
	boolean flag=false;
	Scanner in=new Scanner(System.in);
	IfinacingService fs=new FinancingServiceImpl();
	Financing f=new Financing(null, 0, 0, 0, 0);
	    f.setFpId(_fpId);
		System.out.println("个人成本：");
		f.setBasepay(in.nextDouble());
		System.out.println("房费：" );
		f.setRoompay(in.nextDouble());
		System.out.println("手续费：");
		f.setPoundage(in.nextDouble());
		f.setProfit(0);
		flag=fs.UpdateFinancing(f);
		return flag;
}
//根据项目号更新利润
public boolean UpdateProfit(){
	Scanner in=new Scanner(System.in);
	IfinacingService fs=new FinancingServiceImpl();
	return fs.UpdateProfit();
	
}


//ccc更新奖金
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

/*--------------------------------查看信息-------------------------------*/

//输出list中的所有项目信息	
public void printProject(List<Project> l)
{
	for(Project p:l)
	{
		System.out.println("项目号:"+p.getpId()+"  项目名:"+p.getpName()
				+"  目的地:"+p.getDestination()+"  持续时间:"+p.getLast()
				+"  报名时间:"+p.getBeginning()+"  截止时间:"+p.getEnding());
		System.out.println("详细信息:"+p.getDescribing()+"  报团最少人数:"
				+p.getMin()+"  报团最多人数:"+p.getMax());					
		System.out.println("状态:"+p.getPflag()+"  负责人ID号:"+
				p.getChargeId()+"  导游ID号:"+p.getLeadId()+"  项目类别号:"
				+p.getPcId());
		System.out.println();			
	}			
}

//查找所有的项目信息，返回一个list
public void MfindAllProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	List<Project> l=new ArrayList<Project>();
	l=projectService.AllProject();
	adminControl.printProject(l);
}

//查找所有的类别信息
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

//查找所有的历史记录信息，返回一个list
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



/*--------------------------------类别管理 --------------------------------*/

//插入新类别信息
public void MinsertCategory()
{
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	System.out.print("请输入类别号：");
	String cId=sc.next();
	System.out.print("请输入类别名称：");
	String cName=sc.next();		
	Category c=new Category(cId, cName);
	switch(categoryService.InsertCategory(c))
	{						
		case 0:
			System.out.println("插入失败");
			break;
		case 1:
			System.out.println("插入成功");
			break;
		case 2:
			System.out.println("插入失败，主键约束");		
			break;
	}			
}	

//更新类别信息
public void MupdateCategory()
{
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	System.out.print("请输入类别号：");
	String cId=sc.next();
	System.out.print("请输入类别名称：");
	String cName=sc.next();		
	Category c=new Category(cId, cName);
	switch(categoryService.UpdateCategory(c))
	{						
		case 0:
			System.out.println("更新失败");
			break;
		case 1:
			System.out.println("更新成功");
			break;
		case 2:
			System.out.println("更新失败，类别号不存在");		
			break;
	}
}	


//???	
/*--------------------------------历史记录管理 --------------------------------*/

//插入新历史记录信息或者更新更新历史记录信息的次数，要求项目事先存在  
//flag=0--操作失败    flag=1--操作成功   
//flag=2--操作失败，项目表中没有该项目，则无法插入到历史记录表中
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



/*--------------------------------项目管理 --------------------------------*/	

//插入新项目信息,要求项目类别号和负责人ID号事先存在(导游ID是NULL)  flag=0--插入失败  flag=1--插入成功  
//flag=2--插入失败，项目类别号不存在  flag=3--插入失败，该ID号不是员工或者员工ID号的职称不是负责人
public void MinsertProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("项目号:");
	String pId=sc.next();
	System.out.print("项目名:");	
	String pName=sc.next();
	System.out.print("目的地:");	
	String destination=sc.next();
	System.out.print("旅游持续时间:");
	int last=sc.nextInt();
	System.out.print("报名时间:");	
	String beginning=sc.next();
	System.out.print("截止时间:");	
	String ending=sc.next();
	System.out.print("详细信息:");
	String describing=sc.next();
	System.out.print("报团最少人数:");	
	int min=sc.nextInt();
	System.out.print("报团最多人数:");	
	int max=sc.nextInt();
	System.out.print("状态:");
	int pflag=sc.nextInt();
	System.out.print("负责人ID号:");	
	String chargeId=sc.next();	
	String leadId=null;		
	System.out.print("项目类别号:");	
	String pcId =sc.next();	
	Project p=new Project
	(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);
	switch(projectService.InsertProject(p))
	{
		case 0:
				System.out.println("插入失败");
				break;
		case 1:
				System.out.println("插入成功");	
				break;
		case 2:
				System.out.println("插入失败，项目类别号不存在");
				break;
		case 3:
				System.out.println("插入失败，该ID号不是员工或者员工ID号的职称不是负责人");		
				break;
	}		
}	

//更新项目的负责人,要求项目和负责人ID号都事先存在   flag=0--更新失败  flag=1--更新成功
//flag=2--更新失败，项目不存在  flag=3--更新失败，该ID号不是员工或者员工ID号的职称不是负责人
public void MupdateProjectchargeIdBypId()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("项目号:");
	String pId=sc.next();
	System.out.print("负责人ID号:");	
	String chargeId=sc.next();	
	switch(projectService.UpdateProjectchargeIdBypId(pId, chargeId))
	{
		case 0:
			System.out.println("更新失败");
			break;
		case 1:
			System.out.println("更新成功");	
			break;
		case 2:
			System.out.println("更新失败，项目不存在");
			break;
		case 3:
			System.out.println("更新失败，该ID号不是员工或者员工ID号的职称不是负责人");		
			break;
	}		
}	

//更新项目信息，要求项目类别号，项目号，员工的ID号是负责人和导游ID号(导游不能正在带领某个项目)都要事先存在
//flag=0--更新失败  flag=1--更新成功  flag=2--更新失败，项目类别不存在 
//flag=3--更新失败，项目不存在  flag=4--更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人 
//flag=5--更新失败，该员工ID号无法做该项目的导游	
public void MupdateProjectinfo()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("项目号:");
	String pId=sc.next();
	System.out.print("项目名:");	
	String pName=sc.next();
	System.out.print("目的地:");	
	String destination=sc.next();
	System.out.print("旅游持续时间:");
	int last=sc.nextInt();
	System.out.print("报名时间:");	
	String beginning=sc.next();
	System.out.print("截止时间:");	
	String ending=sc.next();
	System.out.print("详细信息:");
	String describing=sc.next();
	System.out.print("报团最少人数:");	
	int min=sc.nextInt();
	System.out.print("报团最多人数:");	
	int max=sc.nextInt();
	System.out.print("状态:");
	int pflag=sc.nextInt();
	System.out.print("负责人ID号:");	
	String chargeId=sc.next();	
	System.out.print("导游ID号:");			
	String leadId=sc.next();
	System.out.print("项目类别号:");	
	String pcId =sc.next();		
	Project p=new Project
	(pId, pName, destination, last, beginning, ending, describing, min, max, pflag, chargeId, leadId, pcId);
	switch(projectService.updateProject(p))
	{
		case 0:
			System.out.println("更新失败");
			break;
		case 1:
			System.out.println("更新成功");	
			break;
		case 2:
			System.out.println("更新失败，项目类别不存在");
			break;
		case 3:
			System.out.println("更新失败，项目不存在");		
			break;
		case 4:
			System.out.println("更新失败，ID号不是员工的ID号或者该员工的ID号不是负责人");
			break;
		case 5:
			System.out.println("更新失败，该员工ID号无法做该项目的导游");		
			break;		
	}			
}

//再次推出项目时，修改项目的状态，报名时间和截止时间   flag=0--更新失败   flag=1--更新成功  flag=2--更新失败,项目不存在  
public void MupdateProjectBypId()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	System.out.print("项目号:");
	String pId=sc.next();		
	System.out.print("报名时间:");	
	String beginning=sc.next();
	System.out.print("截止时间:");	
	String ending=sc.next();
	System.out.print("状态:");
	int pflag=sc.nextInt();
	switch(projectService.UpdateProjectBypId(pId, beginning, ending, pflag))
	{
		case 0:
			System.out.println("更新失败");
			break;
		case 1:
			System.out.println("更新成功");	
			break;
		case 2:
			System.out.println("更新失败,项目不存在");
			break;		
	}			
}	

//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
public void DeleteProject()
{
	ProjectServiceImpl projectService=new ProjectServiceImpl();
	if(projectService.DeleteProject())
		System.out.println("删除成功");
	else
		System.out.println("删除失败");
}		


/*--------------------------------员工管理 --------------------------------*/



//添加员工	
public boolean eInsertEmployee1() {
	IemployeeService es=new EmployeeServiceImpl();
	return es.InsertEmployee();
}



//当员工升职了，修改用户登录表的权限,修改员工的基本工资
//当升职后，更新新的员工号，先修改项目表
public boolean UpdateEmployeeTitleByeId(String _eId){
	boolean flag=false;
	int uflag=0;
	ProjectServiceImpl p=new ProjectServiceImpl(); 
	IemployeeService es=new EmployeeServiceImpl();
	List<Project> list=new ArrayList<Project>();
	list=p.ProjectByleadId(_eId);
	 if(es.UpdateEmployeeTitleByeId(_eId)){
		 if(list.size()>0){
			 System.out.println("该员工正在负责"+list.size()+"个项目，请先更改负责的员工");
			 System.out.println("空闲的员工有：");
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
	  }else{//当升职为
		 flag=es.reNewEmployeeTitleByeId(_eId); 
	 }
	 return flag;
	}

//ccc更新奖金
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