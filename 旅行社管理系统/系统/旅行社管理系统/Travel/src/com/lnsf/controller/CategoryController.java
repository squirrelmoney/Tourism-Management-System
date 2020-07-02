package com.lnsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.model.Category;
import com.lnsf.service.impl.CategoryServiceImpl;

public class CategoryController
{
	CategoryServiceImpl categoryService=new CategoryServiceImpl();
	Scanner sc=new Scanner(System.in);
	
	/*
	 * �û���Ȩ��
	 */
	//�������е������Ϣ
	public List<Category> UfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
		
	//����������Ʋ�������
	public String UfindCategorycIdBycName()
	{
		System.out.print("������������ƣ�");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}	
	
	/*
	 * ���ε�Ȩ��
	 */	
	
	//�������е������Ϣ
	public List<Category> DfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
		
	//����������Ʋ�������
	public String DfindCategorycIdBycName()
	{
		System.out.print("������������ƣ�");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}		
	
	/*
	 * �����˵�Ȩ��
	 */
	
	//�������е������Ϣ
	public List<Category> FfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}	
	
	//����������Ʋ�������
	public String FfindCategorycIdBycName()
	{
		System.out.print("������������ƣ�");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}	
	
	/*
	 * �����Ȩ��
	 */	
		
	//�������е������Ϣ
	public List<Category> MfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
	
	//����������Ʋ�������---�û�
	public String MfindCategorycIdBycName()
	{
		System.out.print("������������ƣ�");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}
	
	//�����������Ϣ
	public int MinsertCategory()
	{
		int flag=0;
		System.out.print("���������ţ�");
		String cId=sc.next();
		System.out.print("������������ƣ�");
		String cName=sc.next();		
		Category c=new Category(cId, cName);
		return categoryService.InsertCategory(c);				
	}
	
	//���������Ϣ
	public int MupdateCategory()
	{
		System.out.print("���������ţ�");
		String cId=sc.next();
		System.out.print("������������ƣ�");
		String cName=sc.next();		
		Category c=new Category(cId, cName);	
		return categoryService.UpdateCategory(c);
	}
}
