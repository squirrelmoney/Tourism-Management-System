package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Financing;

public interface IfinacingService 
{
	//�������еĲ�����Ϣ������һ��list
	abstract List<Financing> AllFinancing();

	//�����²�����Ϣ
	abstract boolean InsertFinancing(String  _fpId);
	
	//���»����ɱ�������������
	abstract boolean UpdateFinancing(Financing  b);
    
	//������Ŀ�Ÿ�������
	abstract boolean UpdateProfit();
}
