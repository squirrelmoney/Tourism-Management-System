package com.lnsf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.ProjectController;
import com.lnsf.model.Project;

public class projectControltest
{
	public static void main(String[] args)
	{
		ProjectController projectControl=new ProjectController();
		Scanner sc=new Scanner(System.in);
		int a=1;
		while(a!=0)
		{
			System.out.println("1.�������е���Ŀ��Ϣ");
			System.out.println("2.�������Ų�����Ŀ");
			System.out.println("3.����Ŀ�ĵز�����Ŀ");	
			System.out.println("4.������Ŀ�Ų��Ҹ���Ŀ�Ľ�ֹ����");
			System.out.println("5.���ݸ�����ID�Ų�����Ŀ");			
			System.out.println("6.���ݵ���ID�Ų�����Ŀ");		
			System.out.println("7.��������Ŀ��Ϣ");
			System.out.println("8.������Ŀ�ĸ�����");
			System.out.println("9.������Ŀ�ĵ���");		
			System.out.println("10.������Ŀ��Ϣ");		
			System.out.println("11.�����еĻ��������޸���Ŀ��״̬");	
			System.out.println("12.���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬");	
			System.out.println("13.�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��");	
			System.out.println("14.ɾ����Ŀ��Ϣ");
			System.out.println("15.�˳�");
			System.out.print("��ѡ��:");
			int b=sc.nextInt();
			switch(b)
			{
				case 1:
						List<Project> l=new ArrayList<Project>();
						l=projectControl.MfindAllProject();
						projectControl.printProject(l);
						System.out.println();
						break;
						
				case 2:
						System.out.print("����������:");
						String pcId=sc.next();
						List<Project> li=new ArrayList<Project>();
						li=projectControl.MfindProjectBypcId(pcId);
						projectControl.printProject(li);
						System.out.println();
						break;
						
				case 3:
						System.out.print("������Ŀ�ĵ�:");
						String destination=sc.next();
						List<Project> lis=new ArrayList<Project>();
						lis=projectControl.MfindProjectByDestination(destination);
						projectControl.printProject(lis);
						System.out.println();
						break;		
						
				case 4:
						System.out.print("��������Ŀ��:");
						String pId=sc.next();	
						System.out.println(projectControl.MfindProjectEndingBypId(pId));
						System.out.println();
						break;
						
				case 5:
						System.out.print("�����븺����ID��:");
						String chargeId=sc.next();	
						List<Project> list=new ArrayList<Project>();
						list=projectControl.MfindProjectBychargeId(chargeId);
						projectControl.printProject(list);
						System.out.println();
						break;			
						
				case 6:
						System.out.print("�����뵼��ID��:");
						String leadId=sc.next();
						List<Project> list1=new ArrayList<Project>();
						list1=projectControl.MfindProjectByleadId(leadId);
						projectControl.printProject(list1);
						System.out.println();
						break;		
						
				case 7:
						switch(projectControl.MinsertProject())
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("����ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ�ܣ���Ŀ���Ų�����");
								break;
							case 3:
								System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
								break;
						}
						System.out.println();
						break;						
							
				case 8:
						switch(projectControl.MupdateProjectchargeIdBypId())
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ�ܣ���Ŀ������");
								break;
							case 3:
								System.out.println("����ʧ�ܣ���ID�Ų���Ա������Ա��ID�ŵ�ְ�Ʋ��Ǹ�����");		
								break;
						}		
						System.out.println();
						break;
						
				case 9:
						switch(projectControl.MupdateProjectleadIdBypId())
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ�ܣ���Ŀ������");
								break;
							case 3:
								System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���");		
								break;
							case 4:
								System.out.println("����ʧ�ܣ��õ������ڸ����������Ŀ�����ܸ�������");		
								break;				
						}		
						System.out.println();
						break;

				case 10:
						switch(projectControl.MupdateProjectinfo())
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ�ܣ���Ŀ��𲻴���");
								break;
							case 3:
								System.out.println("����ʧ�ܣ���Ŀ������");		
								break;
							case 4:
								System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��Ǹ�����");
								break;
							case 5:
								System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���");		
								break;				
							case 6:
								System.out.println("����ʧ�ܣ��������ڴ���ĳ����Ŀ�����ܸ��¸õ��ε�ID�� ");		
								break;			
						}		
						System.out.println();
						break;						
				
				case 11:
						System.out.print("��Ŀ��:");
						String _pId=sc.next();
						System.out.print("״̬:");
						int pflag=sc.nextInt();
						switch(projectControl.MupdateProjectflag(_pId,pflag))
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ��,��Ŀ������");
								break;		
						}		
						System.out.println();
						break;							

				case 12:
						System.out.print("��Ŀ��:");
						String pId2=sc.next();
						switch(projectControl.MupdateProject(pId2))
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ��,��Ŀ������");
								break;
							case 3:
								System.out.println("����ʧ�ܣ�ID�Ų���Ա����ID�Ż��߸�Ա����ID�Ų��ǵ���");	
								break;
							case 4:
								System.out.println("����ʧ�ܣ��������ڴ���ĳ����Ŀ�����ܸ��¸õ��ε�");
								break;		
						}		
						System.out.println();
						break;	
					
				case 13:
						System.out.print("��Ŀ��:");
						String pId1=sc.next();
						switch(projectControl.MupdateProjectBypId(pId1))
						{
							case 0:
								System.out.println("����ʧ��");
								break;
							case 1:
								System.out.println("���³ɹ�");	
								break;
							case 2:
								System.out.println("����ʧ��,��Ŀ������");
								break;		
						}		
						System.out.println();
						break;		
		
				case 14:
						if(projectControl.DeleteProject())
							System.out.println("ɾ���ɹ�");
						else
							System.out.println("ɾ��ʧ��");
						break;
						
				case 15:
						break;
			}
		}				
	}
}
