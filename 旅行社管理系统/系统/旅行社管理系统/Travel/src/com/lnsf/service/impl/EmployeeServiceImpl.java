package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IemployeeDao;
import com.lnsf.dao.IsalaryDao;
import com.lnsf.dao.IuserDao;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.dao.impl.SalaryDaoImpl;
import com.lnsf.dao.impl.UserDaoImpl;
import com.lnsf.model.Employee;
import com.lnsf.model.Salary;
import com.lnsf.model.User;
import com.lnsf.service.IemployeeService;

public class EmployeeServiceImpl implements IemployeeService{

	public static Scanner in=new Scanner(System.in);
	//查找所有的员工信息
	public List<Employee> AllEmployee() {
		IemployeeDao i=new EmployeeDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		for (Employee a : i.findAllEmployee()) {
			list.add(a);
		}
		return list;
	}

	//根据员工号查找员工，返回员工信息
	public List<Employee> EmployeeByeId(String _eId) {
		IemployeeDao i=new EmployeeDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		for (Employee a : i.findAllEmployee()) {
			if(a.geteId().equals(_eId)){
			list.add(a);
			}
		}
		
		return list;
	}

	//插入新员工信息
	public boolean InsertEmployee() {
		boolean flag=false;
		int n = 0;
		String _eId=null;
		Scanner in=new Scanner(System.in);
		IemployeeDao i=new EmployeeDaoImpl();
		Employee e=new Employee(null, null, null, null);
		List<Employee> list=new ArrayList<Employee>();
		System.out.println("姓名：");
		e.seteName(in.nextLine());
		System.out.println("电话：");
		e.seteTel(in.nextLine());
		while(true){
		System.out.println("职位：");
		System.out.println("1.导游     2.负责人");
		String b=in.nextLine();
		if(b.equals("1")){
		 e.seteTitle("导游");
		 for (Employee ep : i.findAllEmployee()) {
			 if(ep.geteId().toString().substring(0, 1).equals("d")){
			 n=Integer.parseInt(ep.geteId().toString().substring(1));
			 _eId=ep.geteId();
			}
		}
		 _eId=count(_eId,n);
		 e.seteId(_eId);
		 flag=i.insertInfoToEmployee(e);
		 break;
		}else if(b.equals("2")){
			 e.seteTitle("负责人");
			 for (Employee ep1 : i.findAllEmployee()) {
				 if(ep1.geteId().toString().substring(0, 1).equals("f")){
				 n=Integer.parseInt(ep1.geteId().toString().substring(1));
				 _eId=ep1.geteId();
				}
			 }
				 _eId=count(_eId,n);
				 e.seteId(_eId);
				 flag=i.insertInfoToEmployee(e);
				 break;
		}else{
			System.out.println("没有该选项，请重选");
		}
		}	
		if(flag==false){
			System.out.println("添加员工失败");
		}
		return flag;
	}

	//当员工升职了，修改用户登录表的权限,修改员工的基本工资
	public boolean UpdateEmployeeTitleByeId(String _eId) {
		boolean flag=false;
		String _eTitle;
		IemployeeDao i=new EmployeeDaoImpl();
		for (Employee e1 : i.findAllEmployee()) {
			if(e1.geteId().equals(_eId)){
				System.out.println("选择要升职的职位，返回输入0");
				while(true){
					System.out.println("职位：");
					System.out.println("1.负责人     2.经理");
					String b=in.next();
					if(b.equals("1")){
						_eTitle="负责人";
						flag=i.updateEmployeeTitleByeId(_eId, _eTitle);
						break;
					}
					else if(b.equals("2")){
						_eTitle="经理";
						flag=i.updateEmployeeTitleByeId(_eId, _eTitle);
						if(flag){
							System.out.println("太多经理啦，你是要辞职了吗");
						}
						break;
					}
					else{
						System.out.println("没有该选项，请重选");
					}
			}
			}
	}
		
		return flag;
	}
	
	//当升职后，更新新的员工号，先修改项目表
	 public boolean  reNewEmployeeTitleByeId(String _eId){
		Boolean flag=false;
		String _str=null;
		int n=0;
		Employee e=new Employee(null, null, null, null);
		Salary   sa=new Salary(null, 0, 0, 0);
		IsalaryDao s=new SalaryDaoImpl();
		IemployeeDao i=new EmployeeDaoImpl();
		List<Employee> list=new ArrayList<Employee>();
		for (Salary s1 : s.findAllSalary()) {
			if(s1.getSeId().equals(_eId)){
				sa.setBaseSalary(s1.getBaseSalary());
				sa.setInsurance(s1.getInsurance());
				sa.setReward(s1.getReward());
			}
		}
		for (Employee e1 : i.findAllEmployee()) {
			if(e1.geteId().equals(_eId)&&e1.geteTitle().equals("负责人")){
			e.seteName(e1.geteName());
			e.seteTel(e1.geteTel());
			e.seteTitle(e1.geteTitle());	
			 for (Employee ep1 : i.findAllEmployee()) {
				 if(ep1.geteId().toString().substring(0, 1).equals("f")){
				 n=Integer.parseInt(ep1.geteId().toString().substring(1));
				 _str=ep1.geteId();
				}
			 }
			 e.seteId(count(_str,n));
			 sa.setSeId(count(_str,n));
			 s.deleteSalary(_eId);
			 i.deleteEmployee(_eId);
			 flag=i.insertInfoToEmployee(e);
			 s.insertInfoToSalary(sa);
			 break;
			}
			else if(e1.geteId().equals(_eId)&&e1.geteTitle().equals("经理")){
				e.seteName(e1.geteName());
				e.seteTel(e1.geteTel());
				e.seteTitle(e1.geteTitle());
				 for (Employee ep1 : i.findAllEmployee()) {
					 if(ep1.geteId().toString().substring(0, 1).equals("j")){
					 n=Integer.parseInt(ep1.geteId().toString().substring(1));
					 _str=ep1.geteId();
					}
				 }
				 e.seteId(count(_str,n));
				 sa.setSeId(count(_str,n));
				 s.deleteSalary(_eId);
				 i.deleteEmployee(_eId);
				 flag=i.insertInfoToEmployee(e);
				 s.insertInfoToSalary(sa);
				 break;
				}
		}
		 if(flag==false){
			 System.out.println("更新失败，请检查数据");
		 }
		return flag;
	 }
	 
	 
	//当员工修改电话号码，修改用户登录表的电话号码
	public boolean UpdateEmployeeTelByeId(String old_eTel) {
		boolean flag=false;
		int n=0;
		String new_eTel=null;
		IemployeeDao i=new EmployeeDaoImpl();
		IuserDao u=new UserDaoImpl();
		Scanner in=new Scanner(System.in);
		List<Employee> list=new ArrayList<Employee>();
		for (Employee a : i.findAllEmployee()) {
			if(a.geteTel().equals(old_eTel)){
			System.out.println("请输入新手机号");
			 new_eTel=in.nextLine();
			Employee e=new Employee(a.geteId(),a.geteName(),new_eTel, a.geteTitle());
			if(i.updateEmployee(e)){
			n=1;
			}
			break;
			}
		}
		if(n==1){
			for (User u1 :u.findAllUser()) {
				if(u1.getuTel().equals(old_eTel)){
				User user=new User(new_eTel, u1.getuPassWord(), u1.getuSuper());
				if(u.updateUser(user, u1.getuTel())==1)
				n=2;
				break;
				}
			}
			
		}
		if(n==2){
			flag=true;
		}
		return flag;
	}

	//删除员工信息，同时删除该员工的工资信息
	public boolean DeleteEmployee(String _eId) {
		boolean flag=false;
		IsalaryDao s=new SalaryDaoImpl();
		IemployeeDao i=new EmployeeDaoImpl();
		if(s.deleteSalary(_eId))
		flag=i.deleteEmployee(_eId);
		return flag;
	}

  public String count(String _eId,int n){
	if(n<10){
		_eId=_eId.toString().substring(0,3)+Integer.toString(n+1);
	}else if(n<100){
		_eId=_eId.toString().substring(0,2)+Integer.toString(n+1);
	}else{
		_eId=_eId.toString().substring(0,1)+Integer.toString(n+1);
	}
	return _eId;
}

//根据项目号查找有空的导游
public List<String> findEmployeeByepId() {
	IemployeeDao i=new EmployeeDaoImpl();
	List<String> list=new ArrayList<String>();
	for (String a : i.findEmployeeByepId()) {
		System.out.println(a);
		list.add(a);
	}
	return list;
}


}
