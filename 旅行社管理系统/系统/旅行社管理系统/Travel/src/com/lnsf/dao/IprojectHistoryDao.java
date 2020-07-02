package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.ProjectHistory;


public interface IprojectHistoryDao
{
	//�������е���ʷ��¼��Ϣ������һ��list
	abstract List<ProjectHistory> findAllProjectHistory();
		
	//��������ʷ��¼��Ϣ��Ҫ����Ŀ���ȴ���
	abstract boolean insertInfoToProjectHistory(ProjectHistory ph);
	
	//������ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���
	abstract boolean updateProjectHistory(ProjectHistory ph);
}
