package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Book;
import com.lnsf.model.Information;


public interface IinformationDao 
{
	//查找所有的用户信息，返回一个list
	abstract List<Information> findAllInformation();
	
	//当项目可以顺利进行时，从预约表插入新用户信息
	abstract boolean insertInfoToInformation(Information m);
	
	//更新
	abstract boolean updateInformation(Information m,String old_bTel);
	
	//删除
	abstract boolean deleteInformationByTel(String _bTel);
	
	//算出vip
	abstract int countVip(String _ipId);
	
	//算出非normal人数
	abstract int countnormal(String _ipId);
	//更改旅行状态
	abstract boolean updateInformationBypId(String _ipId,int _flag);
}
