package com.lnsf.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.adminController;
import com.lnsf.controller.adminControllermoney;
import com.lnsf.dao.impl.SalaryDaoImpl;
import com.lnsf.model.Salary;

public class adminView
{
	public void admin()
	{
		
	adminController a=new  adminController();
	Scanner input=new Scanner(System.in);
	adminControllermoney mon=new adminControllermoney();
	int n = 0;
	while(true){
	System.out.println("---------0.����-----------");
	System.out.println("---------1.�鿴��������Ϣ-----------");
	System.out.println("---------2.Ա������-----------");
	System.out.println("---------3.��Ŀ����----------");
	System.out.println("---------4.�������----------");
	System.out.print("��ѡ��:");
	int num1=input.nextInt();
	switch(num1){
	case 1:
		while(true){
		//�鿴��������Ϣ
		System.out.println("---------0.����-----------");
		System.out.println("---------1.�鿴ԤԼ��Ϣ----------");
		System.out.println("---------2.�鿴�û���Ϣ----------");
		System.out.println("��ѡ��:");
		 n=input.nextInt();
		switch(n){
		case 1:a.adminAllBook(); break;
		case 2:a.AllInformation(); break;
		default:break;
		}
		if(n==0){
			break;
		}
		}
		 
			break;
		
	case 2:
		//Ա������
		while(true){
			System.out.println("---------0.����-----------");
			System.out.println("---------1.�鿴Ա����Ϣ----------");
			System.out.println("---------2.�޸�Ȩ��----------");
			System.out.println("---------3.Ա�����ʹ���----------");
			System.out.println("---------4.Ա����ְ----------");
			System.out.println("---------5.Ա������----------");
			System.out.println("---------6.������Ա��----------");
			System.out.println("��ѡ��:");
			 n=input.nextInt();
			switch(n){
			case 1:a.AllEmployee();break;
			case 2:
				if(a.AllUser()){
					System.out.println("��Ҫ�޸�Ȩ�޵��˺ţ�");
		            String _uTel=input.next();
		            System.out.println("�޸��µ�Ȩ��Ϊ��");
		            System.out.println("��ʾ������1��������Ǿ���2�������Ϊ�����ˣ�3�������Ϊ���Σ�4�������Ϊ��ͨ�û�");
		            int _uSuper=input.nextInt();
					a.updateUser1(_uTel, _uSuper);
					  break;
					   }
			case 3:
				while(true)
				{
				System.out.println("---------0.����-----------");
				System.out.println("---------1.�޸�Ա������----------");
				System.out.println("---------2.����Ա�����----------");
				System.out.println("---------3.�鿴����Ա������----------");
			
				int choose=input.nextInt();
		       switch(choose)
		       {
		       case 1:
					System.out.println("��Ҫ�޸Ĺ������˺ţ�");
		            String _seId=input.next();
		            System.out.println("�޸��µĹ���Ϊ��");
		            
		            Double _baseSalary=input.nextDouble();
		        	List<Salary>list=new ArrayList<Salary>();
		            SalaryDaoImpl id=new SalaryDaoImpl();
		        	list=id.findAllSalary();				        	
		        	for(Salary s1:list)
		        	{
		        		if(s1.getSeId().equals(_seId))
		        		{
		 a.updateSalary(_seId, _baseSalary, 1200d,s1.getReward());
		        		}
		        	}
		    	   break;
		       case 2:System.out.println("����Ҫ����ɵ�Ա�����");
               String _seId1=input.next();
               a.updateReward(_seId1);
                break;//���
		    	 
		       case 3:
		    	   //�鿴����Ա������
		    	   System.out.println(a.AllSalary());
		    	   break;
		       default:break;
				}
				
				break;
				}
				break;
			case 4:
					System.out.println("��������Ҫ��ְ��Ա����:");
					String _eId=null;
					_eId=input.next();
					System.out.println(_eId);
				   System.out.println(a.UpdateEmployeeTitleByeId(_eId));
			       break;
			case 5: 
				a.AllEmployee();
				System.out.println("��������Ҫɾ����Ա����:");
				 _eId=null;
				_eId=input.next();
				System.out.println(mon.DeleteEmployee(_eId)); 
				break;
			     
			case 6:
              //�����µ�Ա������
				System.out.println("�����µ�Ա��������Ϣ");
				String _seId =input.next();
				a.insertSalary(_seId);
				
			default:break;
			}
			if(n==0){
				break;
			}
			}
		
			break;
		
	  case 3:
		//��Ŀ����
		while(true)
		{
			System.out.println("---------0.����-----------");
			System.out.println("---------1.�鿴��Ŀ��Ϣ-----------");
			System.out.println("---------2.�����Ŀ----------");
			System.out.println("---------3.������Ŀ�ĸ�����-----------");
			System.out.println("---------4.������Ŀ��Ϣ-----------");
			System.out.println("---------5.�ٴ��Ƴ���Ŀʱ���޸���Ŀ��״̬������ʱ��ͽ�ֹʱ��----------");		
			System.out.println("---------6.����ʷ��¼��ͳ��ĳ����Ŀ�Ĵ����������Σ�ɾ����ʷ��¼�������Ŀ����Ϣͬʱ����״̬Ϊ3-����----------");	
			System.out.print("��ѡ��:");
			n=input.nextInt();
			switch(n)
			{
				case 1: 
						a.MfindAllProject();
						break;
				case 2:
						a.MinsertProject();
						break;
				case 3: 
						a.MupdateProjectchargeIdBypId();
						break;
				case 4:
						a.MupdateProjectinfo();
						break;
				case 5: 
						a.MupdateProjectBypId();
						break;							
				case 6: 
						a.DeleteProject();
						break;								
				default:break;
			}
			if(n==0)
			{
				break;
			}
		}
		break;
				
		case 4:
			//�������
					while(true){
						System.out.println("---------0.����-----------");
						System.out.println("---------1.�鿴������Ϣ-----------");
						System.out.println("---------2.�鿴����-----------");
						System.out.println("---------3.������Ŀ�ɱ�----------");
						System.out.println("---------4.�����Ŀ����----------");
						System.out.println("��ѡ��:");
						 n=input.nextInt();
						switch(n){
						case 1:a.AllFinancing();break;
						case 2:a.UpdateProfit();
						       a.AllFinancing(); 
						       break;
						case 3:
							a.AllFinancing();
							System.out.println("��������Ҫ�޸ĵ���Ŀ���:");
							String pid=null;
							pid=input.next();
							System.out.println(a.UpdateFinancing(pid));
						        break;
						        
						case 4:
							System.out.println("��������Ҫ��Ӳ������Ŀ���:");
							pid=null;
							pid=input.next();
							System.out.println(a.InsertProjectAndFinancing(pid));
							break;
						default:break;
						}
						if(n==0){
							break;
						}
						}
						break;
					
		default:
			break;
	}
	if(num1==0){
		break;
	}
			}

	}
		

}

