package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.impl.CategoryDaoImpl;
import com.lnsf.model.Category;
import com.lnsf.service.IcategoryService;

public class CategoryServiceImpl implements IcategoryService 
{
	//�������е������Ϣ
	public List<Category> AllCategory()
	{
		CategoryDaoImpl categoryDao=new CategoryDaoImpl();
		List<Category> l=new ArrayList<Category>();
		l=categoryDao.findAllCategory();
		return l;
	}

	//�������Ų����������
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
	
	//�����������Ϣ  flag=0--����ʧ��    flag=1--����ɹ�   flag=2--����ʧ�ܣ�����Լ��
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
	
	//���������Ϣ  flag=0--����ʧ��    flag=1--���³ɹ�   flag=2--����ʧ�ܣ����Ų�����
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
