package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Word;


public interface IwordDao 
{
	//�������е��ȴ�������Ϣ������һ��list
	 abstract List<Word> findAllWord();
	  	 
	 //�����ȴ�������Ϣ�Ĵ���
	 abstract boolean updateWord(String _wpName,int _wNumber);
	 
	// ����
	 abstract boolean insertWord(String _wpName,int _wNumber);

}
