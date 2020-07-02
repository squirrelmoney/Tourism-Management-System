package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Book;

public interface IbookService
{
	//查找所有的预约信息，返回一个list
	abstract List<Book> AllBook();	
	
	//根据项目号查找所有的预约信息
	abstract List<Book> BookBypId(String _pId);	
	
	//根据手机号查找所有的预约信息	
	abstract List<Book> BookBybTel(String _bTel);
	//插入新预约信息，要求项目事先存在
	abstract int InsertBook(Book b) ;
	
	//更新预约信息的状态
	abstract boolean updateBookbflagBybpId(String _bpId,int _bflag);
	
	//更新账号
	abstract boolean updateBookbflagBybbTel(String old_bTel,String new_bTel);
		
	//定时删除预约信息
	abstract boolean DeleteBook(String _bpId);
	
    //数出一个项目参加的人数
	abstract int CountNumBypId(String _bpId);
	
	//根据手机号删除
	abstract boolean DeleteBookByTel(String _tel);
}
