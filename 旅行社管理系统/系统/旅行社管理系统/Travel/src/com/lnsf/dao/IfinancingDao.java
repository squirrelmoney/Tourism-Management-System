package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Financing;


public interface IfinancingDao 
{
	//查找所有的财务信息，返回一个list
	abstract List<Financing> findAllFinancing();

	//插入新财务信息,要求项目事先存在并且利润为0
	abstract boolean insertInfoToFinancing(Financing f);
	
	//更新基本利润，不包括利润
	abstract boolean updateFinancing(Financing f);
    
	//根据项目号更新利润
	abstract boolean updateFinancingBypId(String _fpId,double _profit);
}
