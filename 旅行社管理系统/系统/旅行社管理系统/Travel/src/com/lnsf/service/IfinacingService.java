package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Financing;

public interface IfinacingService 
{
	//查找所有的财务信息，返回一个list
	abstract List<Financing> AllFinancing();

	//插入新财务信息
	abstract boolean InsertFinancing(String  _fpId);
	
	//更新基本成本，不包括利润
	abstract boolean UpdateFinancing(Financing  b);
    
	//根据项目号更新利润
	abstract boolean UpdateProfit();
}
