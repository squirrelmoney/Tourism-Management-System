package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Word;

public interface IwordService
{
	//查找所有的热词搜索信息，返回一个list
	 abstract List<Word> AllWord();
	  	 
	 //更新热词搜索信息的次数
	 abstract int UpdateWord(Word w);
}
