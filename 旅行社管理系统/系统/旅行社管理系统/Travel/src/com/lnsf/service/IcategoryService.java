package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Category;

public interface IcategoryService
{
	//�������е������Ϣ
	abstract List<Category> AllCategory();

	//����������Ʋ�������
	abstract String CategorycIdBycName(String _cName);	
	
	//�����������Ϣ  flag=0--����ʧ��    flag=1--����ɹ�   flag=2--����ʧ�ܣ�����Լ��
	abstract int InsertCategory(Category c);
	
	//���������Ϣ  flag=0--����ʧ��    flag=1--���³ɹ�   flag=2--����ʧ�ܣ����Ų�����
	abstract int UpdateCategory(Category c);
}
