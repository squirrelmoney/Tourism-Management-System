package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Category;

public interface IcategoryService
{
	//查找所有的类别信息
	abstract List<Category> AllCategory();

	//根据类别名称查找类别号
	abstract String CategorycIdBycName(String _cName);	
	
	//插入新类别信息  flag=0--插入失败    flag=1--插入成功   flag=2--插入失败，主键约束
	abstract int InsertCategory(Category c);
	
	//更新类别信息  flag=0--更新失败    flag=1--更新成功   flag=2--更新失败，类别号不存在
	abstract int UpdateCategory(Category c);
}
