package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IwordDao;
import com.lnsf.dao.impl.WordDaoImpl;
import com.lnsf.model.Word;
import com.lnsf.service.IwordService;

public class WordServiceImpl implements IwordService {
	//查找所有热词，返回list
	public List<Word> AllWord()
	{
		IwordDao i=new WordDaoImpl();
		List<Word>list=new ArrayList<Word>();
		list=i.findAllWord();
		return list;
	}
	
//更新热词信息	
public int UpdateWord(Word w)
{
int flag=0;
String _wpName=w.getWpName();
int _wNumber=w.getwNumber();
IwordDao i=new WordDaoImpl();
List<Word>list=new ArrayList<Word>();
list=i.findAllWord();
for(Word w1:list){
	if(w1.getWpName().equals(_wpName))
	{
		_wNumber=w1.getwNumber()+1;			
		if(i.updateWord( _wpName,_wNumber))
		{
			flag=1;
			return flag;
		}
		else
		{
			flag=0;
			return flag;					
		}
	}
}

if(i.insertWord(_wpName,1))
{
	System.out.println(_wpName);
	flag=2;
	return flag;
}
else
{
	flag=0;
	return flag;					
}

}		
}

