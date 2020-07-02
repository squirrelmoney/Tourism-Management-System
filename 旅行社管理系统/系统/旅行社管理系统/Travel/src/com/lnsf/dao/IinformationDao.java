package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Book;
import com.lnsf.model.Information;


public interface IinformationDao 
{
	//�������е��û���Ϣ������һ��list
	abstract List<Information> findAllInformation();
	
	//����Ŀ����˳������ʱ����ԤԼ��������û���Ϣ
	abstract boolean insertInfoToInformation(Information m);
	
	//����
	abstract boolean updateInformation(Information m,String old_bTel);
	
	//ɾ��
	abstract boolean deleteInformationByTel(String _bTel);
	
	//���vip
	abstract int countVip(String _ipId);
	
	//�����normal����
	abstract int countnormal(String _ipId);
	//��������״̬
	abstract boolean updateInformationBypId(String _ipId,int _flag);
}
