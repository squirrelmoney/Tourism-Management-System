package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Category;

public interface IcategoryDao
{
	//查找所有的类别信息，返回一个list
	abstract List<Category> findAllCategory();
		
	//插入新类别信息
	abstract boolean insertInfoToCategory(Category c);
	
	//更新类别信息
	abstract boolean updateCategory(Category c);
}
