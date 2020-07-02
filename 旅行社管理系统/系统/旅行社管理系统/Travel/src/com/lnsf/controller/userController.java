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
	
	/*--------------------------------我要用的方法，不用管-------------------------------*/	
	
    //n搜索词语，更新或插入热词信息
    public void UpdateWord(String _wpName)
    {
		Word w=new Word(null, 0);
		IwordService iw=new WordServiceImpl();
		w.setWpName(_wpName);
		 int flag=iw.UpdateWord(w);
		 if (flag==1)
		 {
			 System.out.println("原本就有的情况下，number加1");
		 }
		 else if(flag==2)
		 {
			 System.out.println("第一次搜索，添加搜索词，number=1");
		 }
		 else if(flag==0)
		 {
			 System.out.println("插入失败");
		 }	
    }	
	
	//数出一个项目参加的人数
	public int eCountNumBypId(String _bpId){
		int n=0;
		IbookService bs=new BookServiceImpl();
		n=bs.CountNumBypId(_bpId);
		return n;
	}	
	
	
	
	/*--------------------------------查看信息-------------------------------*/
	//根据手机号查找所有的预约信息
	public boolean nBookByTel(String _bTel){
		boolean flag=false;
		IbookService bs=new BookServiceImpl();
		if(bs.AllBook().size()>0){
		for (Book a : bs.BookBybTel(_bTel)) {
			System.out.println(a);
			flag=true;
			}
		}else{
			System.out.println("你尚未有订单");
		}
		return flag;
	}
	
	//n根据电话号码和密码查找账户信息，返回一个list
	public List<User> Login(String _uTel,String _uPassWord){
		boolean flag=false;
		IuserService iw=new UserServiceImpl();
		iw.Login(_uTel, _uPassWord);
		if(iw.Login(_uTel, _uPassWord).size()>0){
    		System.out.println("此用户权限为"+iw.Login(_uTel, _uPassWord));
    		flag=true;
    	}else{
    		System.out.println("密码或电话号输入错误");
    	}
		return iw.Login(_uTel, _uPassWord);
	}	
	
	
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
	public void UfindAllProject()
	{
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		List<Project> l=new ArrayList<Project>();
		l=projectService.AllProject();
		userControl.printProject(l);
	}	
	
	
	
	
	/*--------------------------------雯丽-------------------------------*/
	
	//根据目的地搜索项目
	public void UfindProjectByDestination()
	{
		System.out.print("请输入目的地:");
		String destination=sc.next();
		userControl.UpdateWord(destination); 		
		List<Project> l=new ArrayList<Project>();
		List<Project> li=new ArrayList<Project>();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		l=projectService.ProjectByDestination(destination);
		li=projectService.AllProject();
		userControl.printProject(l);
		System.out.print("请输入想要去旅游的项目号:");
		String pId=sc.next();
		for(Project p:li)
		{
			if(p.getpId().equals(pId) && p.getPcId().equals("c001"))
			{
				int num=userControl.eCountNumBypId(pId);
				if(num>=p.getMax())
				{
					System.out.println("该项目已满人，无法报名参加");
					/*
					 * 跟团的话
					 * 不用等待项目的截止时间，负责人选择导游，判断导游是否空闲
					 * 改变用户页面的报名状态
					 * 把预约表信息插入到用户信息表
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
	
	
	
	
	//根据类别号搜索项目
	public void UfindProjectBypcId()
	{
		System.out.print("请输入类别名称:");
		String cName=sc.next();
		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		String pcId=categoryService.CategorycIdBycName(cName);
		List<Project> l=new ArrayList<Project>();
		ProjectServiceImpl projectService=new ProjectServiceImpl();
		l=projectService.ProjectBypcId(pcId);
		userControl.printProject(l);
		System.out.print("请输入想要去旅游的项目号:");
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
					System.out.println("该项目已满人，无法报名参加");
					/*
					 * 跟团的话
					 * 不用等待项目的截止时间，负责人选择导游，判断导游是否空闲
					 * 改变用户页面的报名状态
					 * 把预约表信息插入到用户信息表
					 */
				}
				else
				{
					userControl.userInsertBook(p.getpId());
				}				
			}
		}
	}
	
	
	
	/* -----------------------------------加入项目---------------------------------------*/
	//插入新预约信息，要求项目事先存在
	public  int userInsertBook(String _bpId){
		int flag=0;
		Book b=new Book(null, null, null, null, 0, 0);
		IbookService bs=new BookServiceImpl();
		Scanner in=new Scanner(System.in);
		b.setBpId(_bpId);
		b.setBflag(1);
		System.out.println("电话：");
		b.setbTel(in.nextLine());
		System.out.println("姓名：");
		b.setbName(in.nextLine());
		System.out.println("身份证：");
		b.setbNum(in.nextLine());
		System.out.println("要订的房间：");
		b.setBroom(in.nextInt());
		flag=bs.InsertBook(b);
		if(flag==1){
			System.out.println("预约成功");
		}else if(flag==2){
			System.out.println("你已经参加该项目了");
		}
		else if(flag==0){
			System.out.println("该社团不存在或已结束报名，预约失败");
		}
		return flag;
	}
    
	
	//n插入新用户（用户注册）
	public boolean InsertUser(String _uTel,String _uPassWord){
		boolean flag=false;
		IuserService iw=new UserServiceImpl();
		iw.InsertUser(_uTel, _uPassWord);
		return flag;
	}
	
	

	/* -----------------------------------更改信息---------------------------------------*/
	
	//根据手机号删除----------------注销账号时
		public boolean deleteInformationByTel(String _iTel) {
				boolean flag=false;
				IinformationDao i=new InformationDaoImpl();
				flag=i.deleteInformationByTel(_iTel);
				return flag;
			}

	 //更新信息表账号-----------------修改账号时
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
		//更新预约信息的手机------------修改账号时
		public boolean eupdateBookbflagBybbTel(String _bpId,String _bTel){
			boolean flag=false;
			IbookService bs=new BookServiceImpl();
			Scanner in=new Scanner(System.in);
			flag=bs.updateBookbflagBybbTel(_bpId, _bTel);
		    if(flag==false){
				System.out.println("更新预约信息的账号失败，请检查");
			}
			return flag;
		}
		
		
		//更新user表的账户密码（修改账户密码）
		  public int updateUser(User u){
		   int flag=0;
		   IuserService iw=new UserServiceImpl();
		   Scanner in = new Scanner(System.in);
		   System.out.println("请选择你要操作的编号");
		   while(true){
		   System.out.println("1.修改密码 2.修改账户 3.注销账户 4.返回");
		   int n=in.nextInt();
		   if(n==1||n==2){
		    flag=iw.updateUser(u, n);
		    
		    break;//登录一次只能修改一次，若想修改第二次要用新账号密码登录再修改
		   }else if(n==3){
		    System.out.println("你确定要注销吗？你的信息将会全部清除Y/N");
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
		    System.out.println("请输入1、2、3、4");
		   }
		   }
		   return flag;

		  }	
}
