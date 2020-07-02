package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Book;


public interface IbookDao
{
	//�������е�ԤԼ��Ϣ������һ��list
	abstract List<Book> findAllBook();	
		
	//������ԤԼ��Ϣ��Ҫ����Ŀ���ȴ���,����1��ʾ�ɹ���0��ʾʧ��
	abstract int insertInfoToBook(Book b);

	
	//������Ϣ
	abstract boolean UpdateBook(Book b,String old_bTel);
	
	//��ʱɾ��ԤԼ��Ϣ
	abstract boolean deleteBookBypId(String _bpId);
	
	//ɾ��
		abstract boolean deleteBookByTel(String _bTel);
}
