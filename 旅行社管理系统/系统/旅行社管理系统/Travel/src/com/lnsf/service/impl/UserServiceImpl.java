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
	//���������û���¼ѶϢ������list
	public List<User> AllUser(){
		IuserDao i=new UserDaoImpl();
		List<User>list=new ArrayList<User>();
		list=i.findAllUser();
		return list;
		}
		
	
	//���ݵ绰������������Ȩ�ޣ�����һ��list
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
	
	//�������û���¼��Ϣ
	public int InsertUser(String _uTel,String _uPassWord){
		int flag=0;
		int n=0;
		User u=new User(null, null, 0);
		IuserDao i=new UserDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
        list=edi.findAllEmployee();
        for(Employee u1 : list){
        	if(u1.geteTitle().equals("������")&&u1.geteTel().equals(_uTel)){
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(2);
        		flag=i.insertInfoToUser(u);
        		n=2;
        		break;
        	}
        	else if(u1.geteTitle().equals("����")&&u1.geteTel().equals(_uTel)){
        		u.setuPassWord(_uPassWord);
        		u.setuTel(_uTel);
        		u.setuSuper(1);
        		flag=i.insertInfoToUser(u);
        		n=1;
        		break;
        	}
        	else if(u1.geteTitle().equals("����")&&u1.geteTel().equals(_uTel)){
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
        	System.out.println("�ǹ�˾Ա����ע��ɹ�");
        }else if(n==4&&flag==1){            	
    		System.out.println("��Ա��ע��ɹ�");
        }else if(n==0||flag==2){
        	flag=2;
        	System.out.println("ע��ʧ��");
        }
        return flag;
	}
	
	//�����û���¼��Ϣ
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
				System.out.println("����������");
				_password=in.nextLine();
				u.setuPassWord(_password);
				u.setuTel(u2.getuTel());
				u.setuSuper(u2.getuSuper());
				flag=i.updateUser(u,u2.getuTel());
			}
		}}else if(n==2){
			for(User u3:list){
				if(u3.getuTel().equals(u.getuTel())){
					System.out.println("�������µ��˺�");
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
			System.out.println("�޸ĳɹ�");
		}else{
			System.out.println("�޸�ʧ��");
		}
		return flag;
		
		}	
	//����Ա�޸�Ȩ�ޣ�����
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

	
	
	//ɾ���û���¼��Ϣ,�����û��Լ�����
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
		    	System.out.println("ע���û��ɹ�");
		    }else{
		    	System.out.println("ע��ʧ��");
		    }
			return flag;
			}
      
      //����ȷ�ϣ���ֻ�е�¼�����޸�����Ļ������ò���
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