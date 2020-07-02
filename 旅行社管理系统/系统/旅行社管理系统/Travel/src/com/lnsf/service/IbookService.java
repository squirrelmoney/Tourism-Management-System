package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Book;

public interface IbookService
{
	//�������е�ԤԼ��Ϣ������һ��list
	abstract List<Book> AllBook();	
	
	//������Ŀ�Ų������е�ԤԼ��Ϣ
	abstract List<Book> BookBypId(String _pId);	
	
	//�����ֻ��Ų������е�ԤԼ��Ϣ	
	abstract List<Book> BookBybTel(String _bTel);
	//������ԤԼ��Ϣ��Ҫ����Ŀ���ȴ���
	abstract int InsertBook(Book b) ;
	
	//����ԤԼ��Ϣ��״̬
	abstract boolean updateBookbflagBybpId(String _bpId,int _bflag);
	
	//�����˺�
	abstract boolean updateBookbflagBybbTel(String old_bTel,String new_bTel);
		
	//��ʱɾ��ԤԼ��Ϣ
	abstract boolean DeleteBook(String _bpId);
	
    //����һ����Ŀ�μӵ�����
	abstract int CountNumBypId(String _bpId);
	
	//�����ֻ���ɾ��
	abstract boolean DeleteBookByTel(String _tel);
}
