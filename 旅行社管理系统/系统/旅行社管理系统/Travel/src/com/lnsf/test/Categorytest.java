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
 	DaoImpl�Ĳ�����
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
		Category c1=new Category("c002", "������");
		System.out.println(cdi.updateCategory(c1));
	}	
*/
	
/*	
	//ServiceImpl�Ĳ�����
	public static void main(String[] args)
	{
		CategoryServiceImpl categoryService=new CategoryServiceImpl();
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		for(Category c:l)
			System.out.println(c);
		System.out.println();
	
		System.out.println(categoryService.CategorycIdBycName("������"));
		System.out.println();
				
		Category c=new Category("c003", "zzz");
		System.out.println(categoryService.InsertCategory(c));
		System.out.println();
		
		Category c=new Category("c003", "www");
		System.out.println(categoryService.UpdateCategory(c));
		System.out.println();
				
	}
*/	
	
	//Controller�Ĳ�����	
//	public static void main(String[] args)
//	{	
//		CategoryController categoryControl=new CategoryController();
//		Scanner sc=new Scanner(System.in);
//		int a=1;
//		while(a!=0)
//		{
//			System.out.println("1.�������е������Ϣ");
//			System.out.println("2.����������Ʋ�������");	
//			System.out.println("3.�����������Ϣ");
//			System.out.println("4.���������Ϣ");
//			System.out.println("5.�˳�");
//			System.out.print("��ѡ��:");
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
//						System.out.println("�������:"+categoryControl.MfindCategorycIdBycName());
//						System.out.println();
//						break;
//						
//				case 3:
//						int flag=categoryControl.MinsertCategory();
//						switch(flag)
//						{						
//							case 0:
//								System.out.println("����ʧ��");
//								break;
//							case 1:
//								System.out.println("����ɹ�");
//								break;
//							case 2:
//								System.out.println("����ʧ�ܣ�����Լ��");		
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
//								System.out.println("����ʧ��");
//								break;
//							case 1:
//								System.out.println("���³ɹ�");
//								break;
//							case 2:
//								System.out.println("����ʧ�ܣ����Ų�����");		
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

