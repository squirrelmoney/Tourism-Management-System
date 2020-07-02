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
	 * 用户的权限
	 */
	//查找所有的类别信息
	public List<Category> UfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
		
	//根据类别名称查找类别号
	public String UfindCategorycIdBycName()
	{
		System.out.print("请输入类别名称：");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}	
	
	/*
	 * 导游的权限
	 */	
	
	//查找所有的类别信息
	public List<Category> DfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
		
	//根据类别名称查找类别号
	public String DfindCategorycIdBycName()
	{
		System.out.print("请输入类别名称：");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}		
	
	/*
	 * 负责人的权限
	 */
	
	//查找所有的类别信息
	public List<Category> FfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}	
	
	//根据类别名称查找类别号
	public String FfindCategorycIdBycName()
	{
		System.out.print("请输入类别名称：");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}	
	
	/*
	 * 经理的权限
	 */	
		
	//查找所有的类别信息
	public List<Category> MfindAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		l=categoryService.AllCategory();
		return l;
	}
	
	//根据类别名称查找类别号---用户
	public String MfindCategorycIdBycName()
	{
		System.out.print("请输入类别名称：");
		String _cName=sc.next();
		return categoryService.CategorycIdBycName(_cName);
	}
	
	//插入新类别信息
	public int MinsertCategory()
	{
		int flag=0;
		System.out.print("请输入类别号：");
		String cId=sc.next();
		System.out.print("请输入类别名称：");
		String cName=sc.next();		
		Category c=new Category(cId, cName);
		return categoryService.InsertCategory(c);				
	}
	
	//更新类别信息
	public int MupdateCategory()
	{
		System.out.print("请输入类别号：");
		String cId=sc.next();
		System.out.print("请输入类别名称：");
		String cName=sc.next();		
		Category c=new Category(cId, cName);	
		return categoryService.UpdateCategory(c);
	}
}
