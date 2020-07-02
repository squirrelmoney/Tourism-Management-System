package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Word;


public interface IwordDao 
{
	//查找所有的热词搜索信息，返回一个list
	 abstract List<Word> findAllWord();
	  	 
	 //更新热词搜索信息的次数
	 abstract boolean updateWord(String _wpName,int _wNumber);
	 
	// 插入
	 abstract boolean insertWord(String _wpName,int _wNumber);

}
