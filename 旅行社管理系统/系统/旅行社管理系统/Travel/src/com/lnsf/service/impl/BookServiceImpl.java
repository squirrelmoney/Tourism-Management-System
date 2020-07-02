package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IbookDao;
import com.lnsf.dao.impl.BookDaoImpl;
import com.lnsf.dao.impl.ProjectDaoImpl;
import com.lnsf.model.Book;
import com.lnsf.model.Project;
import com.lnsf.service.IbookService;

public class BookServiceImpl implements IbookService{
	//�������е�ԤԼ��Ϣ������һ��list
	public List<Book> AllBook() {
		IbookDao i=new BookDaoImpl();
		List<Book> list=new ArrayList<Book>();
		for (Book a : i.findAllBook()) {
			list.add(a);
		}
		return list;
	}

	//������Ŀ�Ų������е�ԤԼ��Ϣ
	public List<Book> BookBypId(String _pId) {
		 Boolean flag=false;
			IbookDao i=new BookDaoImpl();
			List<Book> list=new ArrayList<Book>();
			for (Book a : i.findAllBook()) {
				if(a.getBpId().equals(_pId)&&a.getBflag()==1){
					 list.add(a);
					}
				}
				
	return list;
	}
	
	//�����ֻ��Ų������е�ԤԼ��Ϣ
	public List<Book> BookBybTel(String _bTel) {
		    Boolean flag=false;
			IbookDao i=new BookDaoImpl();
			List<Book> list=new ArrayList<Book>();
			List<Book> l=new ArrayList<Book>();
			list=i.findAllBook();
			for (Book a : list) {
				if(a.getbTel().equals(_bTel)){
				l.add(a);
				}
			}
			return l;
	}
	
	//������ԤԼ��Ϣ��Ҫ����Ŀ���ȴ���
	public int InsertBook(Book b) {
		int flag=0;
		IbookService bs=new BookServiceImpl();
		IbookDao i=new BookDaoImpl();
		List<Project> list=new ArrayList<Project>();
		ProjectDaoImpl pdi=new ProjectDaoImpl();
		list=pdi.findAllProject();
		for (Project b1 : list) {
			if(b1.getpId().equals(b.getBpId())&&b1.getPflag()==1){
				flag=3;
			}
		}
		for(Book b2:bs.BookBypId(b.getBpId())){
				if(b2.getBpId().equals(b.getBpId())&&b2.getbTel().equals(b.getbTel()))
				{
					flag=2;
					break;
				}
			}
			if(flag==3){
				flag=i.insertInfoToBook(b);
		}
		return flag;
	}

	//����ԤԼ��Ϣ��״̬
	public boolean updateBookbflagBybpId(String _bpId, int _bflag) {
		boolean flag=false;
		IbookDao i=new BookDaoImpl();
	    for (Book b : i.findAllBook()) {
			if(b.getBpId().equals(_bpId)){
				Book b1=new Book(b.getbTel(), b.getBpId(), b.getbName(),
						b.getbNum(), b.getBroom(),_bflag);
				flag=i.UpdateBook(b1,b.getbTel());
			}
		}
		return flag;
	}
	
	//�����˺�
	public boolean updateBookbflagBybbTel(String old_bTel,String new_bTel){
		boolean flag=false;
		IbookDao i=new BookDaoImpl();
	    for (Book b : i.findAllBook()) {
			if(b.getbTel().equals(old_bTel)){
				Book b1=new Book(new_bTel, b.getBpId(), b.getbName(),
						b.getbNum(), b.getBroom(), b.getBflag());
				flag=i.UpdateBook(b1,old_bTel);
			}
		}
		return flag;
	}
	
	//��ʱɾ��ԤԼ��Ϣ
	public boolean DeleteBook(String _bpId) {
		boolean flag=false;
		IbookDao i=new BookDaoImpl();
		flag=i.deleteBookBypId(_bpId);
		return flag;
	}

	//����һ����Ŀ�μӵ�����
	public int CountNumBypId(String _bpId) {
		IbookDao i=new BookDaoImpl();
		List<Book> list=new ArrayList<Book>();
		for (Book b : i.findAllBook()) {
			if(b.getBpId().equals(_bpId)&&b.getBflag()==1){
				list.add(b);
			}
		}
		return list.size();
	}

	//�����ֻ���ɾ��
	public boolean DeleteBookByTel(String _tel) {
		boolean flag=false;
		IbookDao i=new BookDaoImpl();
		flag=i.deleteBookByTel(_tel);
		return flag;
	}




}
