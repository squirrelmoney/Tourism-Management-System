package com.lnsf.service;

import java.util.List;

import com.lnsf.model.Project;

public interface IprojectService 
{
	//�������е���Ŀ��Ϣ������һ��list
	abstract List<Project> AllProject();
	
	//�������Ų�����Ŀ������������ص���Ŀ��Ϣ
	abstract List<Project> ProjectBypcId(String _pcId);	
	
	//����Ŀ�ĵز�����Ŀ������������ص���Ŀ��Ϣ
	abstract List<Project> ProjectByDestination(String _destination);
	
	//������Ŀ�Ų��Ҹ���Ŀ�Ľ�ֹ����
	abstract String ProjectEndingBypId(String _pId);
	
	//������Ŀ�Ų��Ҹ���Ŀ�ı�����������
	abstract int ProjectMinBypId(String _pId);
	
	//������Ŀ�Ų��Ҹ���Ŀ�ı����������
	abstract int ProjectMaxBypId(String _pId);
	
	//���ݸ�����ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	abstract List<Project> ProjectBychargeId(String _chargeId);
	
	//���ݵ���ID�Ų�����Ŀ������������ص���Ŀ��Ϣ
	abstract List<Project> ProjectByleadId(String _leadId);	
				
	//��������Ŀ��Ϣ,Ҫ����Ŀ���ź͸�����ID�����ȴ���(����ID��NULL)  flag=0--����ʧ��  flag=1--����ɹ�  
	//flag=2--����ʧ�ܣ���Ŀ���Ų�����  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
	abstract int InsertProject(Project p);
	
	//������Ŀ�ĸ�����,Ҫ����Ŀ�͸�����ID�Ŷ����ȴ���   flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������  flag=3--����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����
	abstract int UpdateProjectchargeIdBypId(String _pId,String _chargeId);
	
	
	//������Ŀ�ĵ��Σ�Ҫ����Ŀ���ȴ��ں��û���Ϣ���״̬����Ϊδ����(1)  flag=0--����ʧ��  flag=1--���³ɹ�
	//flag=2--����ʧ�ܣ���Ŀ������   flag=3--����ʧ�ܣ���Ա��ID���޷�������Ŀ�ĵ���
	abstract int UpdateProjectleadIdBypId(String _pId,String _leadId);	
	
	
	//������Ŀ��Ϣ��Ҫ����Ŀ���ţ���Ŀ�ţ�Ա����ID���Ǹ����˺͵���ID��(���β������ڴ���ĳ����Ŀ)��Ҫ���ȴ���
	//flag=0--����ʧ��  flag=1--���³ɹ�  flag=2--����ʧ�ܣ���Ŀ��𲻴��� 
	//flag=3--����ʧ�ܣ���Ŀ������  flag=4--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ����� 
	//flag=5--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���   flag=6--����ʧ�ܣ��������ڴ���ĳ����Ŀ�����ܸ��¸õ��ε� 	
	abstract int updateProject(Project p);
	
	
	//��Ŀ�Ľ�ֹʱ��֮�󣬷����������
	//�����еĻ��������޸���Ŀ��״̬	flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������
	abstract int UpdateProject(String _pId,int _pflag);
	
	
	//���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	//flag=3--����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���   flag=4--����ʧ�ܣ��������ڴ���ĳ����Ŀ�����ܸ��¸õ��ε�  
	abstract int UpdateProject(String _pId,String _leadId,int _pflag);
	
	//�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��   flag=0--����ʧ��   flag=1--���³ɹ�  flag=2--����ʧ��,��Ŀ������  
	abstract int UpdateProjectBypId(String _pId,String _beginning,String _ending,int _pflag);	
	
	//����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����
	abstract boolean DeleteProject();
}
