package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.CategoryController;
import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.dao.impl.EmployeeDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.service.impl.CategoryServiceImpl;
import com.lnsf.service.impl.EmployeeServiceImpl;

public class Categorytest 
{	
/*	
 	DaoImpl的测试类
	public static void main(String[] args)
	{
		List<Category> l=new ArrayList<Category>();
		CategoryDaoImpl cdi=new CategoryDaoImpl();
		l=cdi.findAllCategory();
		for(Category c:l)
			System.out.println(c);
		System.out.println();
		System.out.println(cdi.findCategorycNameBycId("c001"));
		System.out.println();
		Category c=new Category("c003", "zzz");
		System.out.println(cdi.insertInfoToCategory(c));
		System.out.println();
		Category c1=new Category("c002", "跟团行");
		System.out.println(cdi.updateCategory(c1));
	}	
*/
	
/*	
	//ServiceImpl的测试类
	public static void main(String[] args)
	{
		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		for(Category c:l)
			System.out.println(c);
		System.out.println();
	
		System.out.println(categoryService.CategorycIdBycName("跟团游"));
		System.out.println();
				
		Category c=new Category("c003", "zzz");
		System.out.println(categoryService.InsertCategory(c));
		System.out.println();
		
		Category c=new Category("c003", "www");
		System.out.println(categoryService.UpdateCategory(c));
		System.out.println();
				
	}
*/	
	
	//Controller的测试类	
//	public static void main(String[] args)
//	{	
//		CategoryController categoryControl=new CategoryController();
//		Scanner sc=new Scanner(System.in);
//		int a=1;
//		while(a!=0)
//		{
//			System.out.println("1.查找所有的类别信息");
//			System.out.println("2.根据类别名称查找类别号");	
//			System.out.println("3.插入新类别信息");
//			System.out.println("4.更新类别信息");
//			System.out.println("5.退出");
//			System.out.print("请选择:");
//			int b=sc.nextInt();
//			switch(b)
//			{
//				case 1:
//						List<Category> l=new ArrayList<Category>();
//						l=categoryControl.MfindAllCategory();
//						for(Category c:l)
//							System.out.println(c);
//						System.out.println();
//						break;
//						
//				case 2:					
//						System.out.println("类别名称:"+categoryControl.MfindCategorycIdBycName());
//						System.out.println();
//						break;
//						
//				case 3:
//						int flag=categoryControl.MinsertCategory();
//						switch(flag)
//						{						
//							case 0:
//								System.out.println("插入失败");
//								break;
//							case 1:
//								System.out.println("插入成功");
//								break;
//							case 2:
//								System.out.println("插入失败，主键约束");		
//								break;
//						}
//						System.out.println();
//						break;
//						
//				case 4:				
//						int flag1=categoryControl.MupdateCategory();
//						switch(flag1)
//						{						
//							case 0:
//								System.out.println("更新失败");
//								break;
//							case 1:
//								System.out.println("更新成功");
//								break;
//							case 2:
//								System.out.println("更新失败，类别号不存在");		
//								break;
//						}
//						System.out.println();
//						break;				
//				case 5:
//						break;
//			}
//		}
		
		
		
//	}

	public static void main(String[] args)
	{	
//		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
//		List<String> l=new ArrayList<String>();
//		l=employeeDao.findEmployeeByepId();
//		for(String a:l)
//			System.out.println(a);
		
		EmployeeServiceImpl employeeService =new EmployeeServiceImpl();
		List<String> l=new ArrayList<String>();
		l=employeeService.findEmployeeByepId();
		for(String a:l)
		System.out.println(a);		
	}
}

