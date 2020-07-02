package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Financing;


public interface IfinancingDao 
{
	//�������еĲ�����Ϣ������һ��list
	abstract List<Financing> findAllFinancing();

	//�����²�����Ϣ,Ҫ����Ŀ���ȴ��ڲ�������Ϊ0
	abstract boolean insertInfoToFinancing(Financing f);
	
	//���»������󣬲���������
	abstract boolean updateFinancing(Financing f);
    
	//������Ŀ�Ÿ�������
	abstract boolean updateFinancingBypId(String _fpId,double _profit);
}
