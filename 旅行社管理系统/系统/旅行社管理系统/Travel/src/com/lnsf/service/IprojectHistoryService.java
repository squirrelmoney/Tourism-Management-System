package com.lnsf.service;

import java.util.List;

import com.lnsf.model.ProjectHistory;

public interface IprojectHistoryService
{
	//�������е���ʷ��¼��Ϣ������һ��list
	abstract List<ProjectHistory> AllProjectHistory();
		
	//��������ʷ��¼��Ϣ��Ҫ����Ŀ���ȴ���  flag=0--����ʧ��    flag=1--����ɹ�   
	//flag=2--����ʧ�ܣ���Ŀ����û�и���Ŀ�����޷����뵽��ʷ��¼����
	abstract int InsertProjectHistory(ProjectHistory ph);
	
	//������ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���
	abstract int UpdateProjectHistory(ProjectHistory ph);	
}
