package com.lnsf.view;

import java.util.Scanner;

import com.lnsf.controller.userController;
import com.lnsf.model.User;

public class loginView
{
	public static void main(String[] args) {
		userController u=new userController();
		UserView u2=new UserView();
		adminView a=new adminView();
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("---------1.��½-----------");
			System.out.println("---------2.ע��-----------");
			System.out.println("---------3.�˳�ϵͳ----------");
			System.out.print("��ѡ��:");
		int num1=input.nextInt();
		switch(num1){
		
		case 1:			//��½---��ȡ��Ϣ---��ת����ӦȨ�޵�ҳ��
            
            System.out.print("�˺ţ�");
            String _uTel=input.next();
            System.out.print("���룺");
            String _uPassWord=input.next();
            for (User u1 :u.Login(_uTel, _uPassWord)) {
				if(u1.getuSuper()==1){
					//����Ա
					adminView a1=new adminView();
				    a1.admin();
				}
				else if(u1.getuSuper()==2){
					//������
					chargerView charger =new chargerView();
					charger.charger();
				}
				else if(u1.getuSuper()==3){
					leaderView leader=new leaderView();
					leader.leader(u1);				
				}
				else if(u1.getuSuper()==4){
					//��ͨ�û�
				u2.userview(u1);
				}
			}
			break;
		case 2:
			//ע��--��ȡ��Ϣ---��ת����ӦȨ��ҳ��
			System.out.println("������Ҫע����˻�");
			String _auTel =input.next();
			System.out.println("����������");
			String _auPassWord =input.next();
			if(u.InsertUser(_auTel, _auPassWord)){
				System.out.println("ע��ɹ�");
			}
			break;
		default:
				break;
		}
		if(num1==3){
			break;
		}
		}
	}

}
