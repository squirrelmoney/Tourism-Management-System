package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IuserDao;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.UserDaoImpl;
import com.lnsf.model.Employee;
import com.lnsf.model.User;
import com.lnsf.service.IbookService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.IuserService;

public class UserServiceImpl implements IuserService {
	//查找所有用户登录讯息，返回list
	public List<User> AllUser(){
		IuserDao i=new UserDaoImpl();
		List<User>list=new ArrayList<User>();
		list=i.findAllUser();
		return list;
		}
		
	
	//根据电话号码和密码查找权限，返回一个list
	public List<User> Login(String _uTel,String _uPassWord){
		IuserDao i=new UserDaoImpl();
		List<User>list=new ArrayList<User>();
		for(User a : i.findAllUser()){
			if(a.getuTel().equals(_uTel)&& a.getuPassWord().equals(_uPassWord)){
			   list.add(a);
		}
			
	}
		return list;
	}
	
	//插入新用户登录信息
	public int InsertUser(String _uTel,String _uPassWord){
		int flag=0;
		int n=0;
		User u=new User(null, null, 0);
		IuserDao i=new UserDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
        list=edi.findAllEmployee();
        for(Employee u1 : list){
        	if(u1.geteTitle().equals("负责人")&&u1.geteTel().equals(_uTel)){
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(2);
        		flag=i.insertInfoToUser(u);
        		n=2;
        		break;
        	}
        	else if(u1.geteTitle().equals("经理")&&u1.geteTel().equals(_uTel)){
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(1);
        		flag=i.insertInfoToUser(u);
        		n=1;
        		break;
        	}
        	else if(u1.geteTitle().equals("导游")&&u1.geteTel().equals(_uTel)){
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(3);
        		flag=i.insertInfoToUser(u);
        		n=3;
        		break;
        	}
        	else{
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(4);
        		flag=i.insertInfoToUser(u);
        		n=4;
        		break;
        	}
        	
        }
        
        if(n!=4&&flag==1){
        	System.out.println("是公司员工，注册成功");
        }else if(n==4&&flag==1){            	
    		System.out.println("非员工注册成功");
        }else if(n==0||flag==2){
        	flag=2;
        	System.out.println("注册失败");
        }
        return flag;
	}
	
	//更新用户登录信息
	public int updateUser(User u,int n){
		int flag=0;
		Scanner in = new Scanner(System.in);
		IuserDao i=new UserDaoImpl();
		String _password=null;
		String _uTel=null;
		IinformationService inf=new InformationServiceImpl();
		IbookService ib=new BookServiceImpl();
		List<User> list = new ArrayList<User>();
		list = i.findAllUser();
		System.out.println(list);
		if(n==1){
		for(User u2:list){
			if(u2.getuTel().equals(u.getuTel())){
				System.out.println("请输入密码");
				_password=in.nextLine();
				u.setuPassWord(_password);
				u.setuTel(u2.getuTel());
				u.setuSuper(u2.getuSuper());
				flag=i.updateUser(u,u2.getuTel());
			}
		}}else if(n==2){
			for(User u3:list){
				if(u3.getuTel().equals(u.getuTel())){
					System.out.println("请输入新的账号");
					_uTel=in.nextLine();
					 u.setuTel(_uTel);
					u.setuPassWord(u3.getuPassWord());		
					u.setuSuper(u3.getuSuper());
					flag=i.updateUser(u, u3.getuTel());
					inf.updateInformationByiTel(u3.getuTel(),_uTel);
					ib.updateBookbflagBybbTel(u3.getuTel(),_uTel);
					}
					}
		}
		if(flag==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return flag;
		
		}	
	//管理员修改权限，经理
	public int updateUser1(User u){
		int flag=0;
		IuserDao i=new UserDaoImpl();
		List<User> list = new ArrayList<User>();
		UserDaoImpl id = new UserDaoImpl();
		list = id.findAllUser();
		for(User u2:list){
			if(u2.getuTel().equals(u.getuTel())){
				u.setuPassWord(u2.getuPassWord());
				u.setuTel(u2.getuTel());
				u.setuSuper(u.getuSuper());
				flag=i.updateUser1(u);

			}
		}
		return flag;
		}

	
	
	//删除用户登录信息,放在用户自己那里
      public int deleteUser(String _uTel){
    	  int flag=0;
			List<User> list = new ArrayList<User>();
			UserDaoImpl id = new UserDaoImpl();
			IinformationService inf=new InformationServiceImpl();
		IbookService ib=new BookServiceImpl();
			list = id.findAllUser();

			for(User u2:list){
				if(u2.getuTel().equals(_uTel)){
					flag=id.deleteUser(_uTel);
					inf.deleteInformationByTel(_uTel);
					ib.DeleteBookByTel(_uTel);
				}
		}
			if(flag==1){
		    	System.out.println("注销用户成功");
		    }else{
		    	System.out.println("注销失败");
		    }
			return flag;
			}
      
      //密码确认，若只有登录才能修改密码的话，则用不上
      public boolean password(String _uPassword,String _uTel){
    	  boolean flag=false;
			IuserDao i=new UserDaoImpl();
			List<User> list = new ArrayList<User>();
			UserDaoImpl id = new UserDaoImpl();
			list = id.findAllUser();
			for(User u2:list){
				if(u2.getuPassWord().equals(_uPassword)&&u2.getuTel().equals(_uTel)){
					return true;
					
				}
					
			}
      return flag;
}




}