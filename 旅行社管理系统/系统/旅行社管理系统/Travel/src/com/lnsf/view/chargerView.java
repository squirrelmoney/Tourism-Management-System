package com.lnsf.view;

import java.util.Scanner;

import com.lnsf.controller.chargerController;

public class chargerView
{
	public void charger()
	{
		chargerController c=new chargerController();
		Scanner input=new Scanner(System.in);
		int n;
		
		while(true){
		System.out.println("---------0.����-----------");	
		System.out.println("---------1.�鿴��������Ϣ-----------");
		System.out.println("---------2.��Ŀ����-----------");		
		System.out.print("��ѡ��:");
		int num1=input.nextInt();
		
		switch(num1)
		{
		case 1:
			while(true)
			{
				//�鿴��������Ϣ
				System.out.println("---------0.����-----------");
				System.out.println("---------1.�鿴��Ŀ��Ϣ-----------");
				System.out.println("---------2.�鿴�����Ϣ----------");
				System.out.println("---------3.�鿴��ʷ��¼��Ϣ----------");
				System.out.print("��ѡ��:");
				 n=input.nextInt();
				switch(n)
				{
					case 1:
							c.findAllProject();
							break;
					case 2:
							c.findAllCategory(); 
							break;
					case 3:
							c.findAllProjectHistory(); 
							break;
					default:break;
				}
				if(n==0)
				{
					break;
				}
			}
			break;
		case 2:
			//��Ŀ����
			while(true)
			{
				System.out.println("---------0.����-----------");
				System.out.println("---------1.���ݸ�����ID�Ų�����Ŀ----------");
				System.out.println("---------2.������Ŀ�ĵ���----------");
				System.out.println("---------3.�����еĻ��������޸���Ŀ��״̬----------");
				System.out.println("---------4.���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬----------");
				System.out.println("---------5.������Ŀ�Ľ�ֹʱ���޸���������Ŀ��״̬----------");
				System.out.println("---------6.���ŵĻ������˷��䵼�κ��޸���Ŀ��״̬----------");				
				System.out.println("��ѡ��:");
				 n=input.nextInt();
				switch(n)
				{
					case 1: 
							c.findProjectBychargeId();
							break;
					case 2:
							c.updateProjectleadIdBypId();
							break;
					case 3:
							c.MupdateProjectflag();
							break;
					case 4: 
							c.MupdateProject();
							break;
					case 5:
							c.selfending();
							break;
					case 6: 
							c.group();
							break;							
							
					default:break;
				}
				if(n==0)
				{
					break;
				}
			}
			break;
			
		default:
				break;
	}
		break;
		}
	}
}
