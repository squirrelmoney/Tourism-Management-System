package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.service.IcategoryService;

public class CategoryServiceImpl implements IcategoryService 
{
	//查找所有的类别信息
	public List<Category> AllCategory()
	{
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();
		List<Category> l=new ArrayList<Category>();
		l=categoryDao.findAllCategory();
		return l;
	}

	//根据类别号查找类别名称
	public String CategorycIdBycName(String _cName)	
	{
		String a=null;
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();	
		List<Category> l=new ArrayList<Category>();
		l=categoryDao.findAllCategory();
		for(Category c:l)
		{
			if(c.getcName().equals(_cName))
				a=c.getcId();
		}
		return a;
	}
	
	//插入新类别信息  flag=0--插入失败    flag=1--插入成功   flag=2--插入失败，主键约束
	public int InsertCategory(Category c)
	{
		int flag=0;
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();	
		List<Category> l=new ArrayList<Category>();
		l=categoryDao.findAllCategory();
		for(Category c1:l)
		{
			if(c1.getcId().equals(c.getcId()))
			{
				flag=2;
				return flag;
			}
		}
		if(categoryDao.insertInfoToCategory(c))
			flag=1;
		return flag;
	}
	
	//更新类别信息  flag=0--更新失败    flag=1--更新成功   flag=2--更新失败，类别号不存在
	public int UpdateCategory(Category c)
	{
		int flag=0;
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();	
		List<Category> l=new ArrayList<Category>();
		l=categoryDao.findAllCategory();
		for(Category c1:l)
		{
			if(c1.getcId().equals(c.getcId()))
			{
				if(categoryDao.updateCategory(c))
				{
					flag=1;
					return flag;
				}
				else
				{
					flag=0;
					return flag;
				}				
			}
		}
		flag=2;
		return flag;
	}
}
