package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Information;

public interface IinformationService
{
	//查找所有的用户信息，返回一个list
	abstract List<Information> AllInformation();
		
	//负责人或者导游根据项目号查找用户信息，返回参加这个项目的所有用户信息
	abstract List<Information> InformationByipId(String _ipId);
	
	//从预约表插入新用户信息
	abstract boolean InsertInformationFromBook(String _ipId);
	    
	//数出一个项目vip人数
	 abstract int CountVipNumBypId(String _ipId);	
	//数出一个项目非vip人数
	 abstract int CountnormalNumBypId(String _ipId);
	 //根据手机号删除
	 abstract boolean deleteInformationByTel(String _iTel);
	 
	 //根据手机号更新账号
	 abstract boolean updateInformationByiTel(String old_bTel,String new_bTel);
	 
	 //根据项目号改变用户旅游状态
	 abstract boolean updateInformationByipId(String _ipId,int _flag);
}
