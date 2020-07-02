package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Information;

public interface IinformationService
{
	//�������е��û���Ϣ������һ��list
	abstract List<Information> AllInformation();
		
	//�����˻��ߵ��θ�����Ŀ�Ų����û���Ϣ�����زμ������Ŀ�������û���Ϣ
	abstract List<Information> InformationByipId(String _ipId);
	
	//��ԤԼ��������û���Ϣ
	abstract boolean InsertInformationFromBook(String _ipId);
	    
	//����һ����Ŀvip����
	 abstract int CountVipNumBypId(String _ipId);	
	//����һ����Ŀ��vip����
	 abstract int CountnormalNumBypId(String _ipId);
	 //�����ֻ���ɾ��
	 abstract boolean deleteInformationByTel(String _iTel);
	 
	 //�����ֻ��Ÿ����˺�
	 abstract boolean updateInformationByiTel(String old_bTel,String new_bTel);
	 
	 //������Ŀ�Ÿı��û�����״̬
	 abstract boolean updateInformationByipId(String _ipId,int _flag);
}
