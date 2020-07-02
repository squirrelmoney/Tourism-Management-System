package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Book;


public interface IbookDao
{
	//查找所有的预约信息，返回一个list
	abstract List<Book> findAllBook();	
		
	//插入新预约信息，要求项目事先存在,返回1表示成功，0表示失败
	abstract int insertInfoToBook(Book b);

	
	//更新信息
	abstract boolean UpdateBook(Book b,String old_bTel);
	
	//定时删除预约信息
	abstract boolean deleteBookBypId(String _bpId);
	
	//删除
		abstract boolean deleteBookByTel(String _bTel);
}
