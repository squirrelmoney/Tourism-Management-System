package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Word;

public interface IwordService
{
	//�������е��ȴ�������Ϣ������һ��list
	 abstract List<Word> AllWord();
	  	 
	 //�����ȴ�������Ϣ�Ĵ���
	 abstract int UpdateWord(Word w);
}
