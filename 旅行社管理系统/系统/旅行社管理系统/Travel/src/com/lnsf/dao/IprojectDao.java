package com.lnsf.dao;

import java.util.List;

import com.lnsf.model.Project;


public interface IprojectDao 
{
	//�������е���Ŀ��Ϣ������һ��list
	abstract List<Project> findAllProject();
	
	//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	abstract List<Project> findProjectByleadId(String _leadId);	
				
	//��������Ŀ��Ϣ
	abstract boolean insertInfoToProject(Project p);
	
	//������Ŀ�ĸ�����
	abstract boolean updateProjectchargeIdBypId(String _pId,String _chargeId);
	
	//������Ŀ�ĵ���
	abstract boolean updateProjectleadIdBypId(String _pId,String _leadId);	
	
	//������Ŀ��Ϣ
	abstract boolean updateProject(Project p);
	
	//��Ŀ�Ľ�ֹʱ��֮�󣬷����������
	//�����еĻ��������޸���Ŀ��״̬
	abstract boolean updateProject(String _pId,int _pflag);
	
	//���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬
	abstract boolean updateProject(String _pId,String _leadId,int _pflag);
	
	//�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��
	abstract boolean updateProjectBypId(String _pId,String _beginning,String _ending,int _pflag);	
	
	//����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����
	abstract boolean deleteProject();	
}
