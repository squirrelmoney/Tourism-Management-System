package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Category;

public interface IcategoryDao
{
	//�������е������Ϣ������һ��list
	abstract List<Category> findAllCategory();
		
	//�����������Ϣ
	abstract boolean insertInfoToCategory(Category c);
	
	//���������Ϣ
	abstract boolean updateCategory(Category c);
}
