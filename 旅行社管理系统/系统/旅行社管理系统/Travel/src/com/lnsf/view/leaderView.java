package com.lnsf.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.leaderController;
import com.lnsf.controller.userController;
import com.lnsf.model.Book;
import com.lnsf.model.Information;
import com.lnsf.model.User;
import com.lnsf.service.IbookService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.IuserService;
import com.lnsf.service.impl.UserServiceImpl;

public class leaderView {

public void leader(User u1){
	leaderController lc=new leaderController();
	Scanner input=new Scanner(System.in);
	userController uc=new userController();
	IuserService is=new UserServiceImpl();
	while(true){
		System.out.println("---------0.�˳���¼----------");
		System.out.println("---------1.������Ŀ-----------");
		System.out.println("---------2.�ҵĹ���-----------");
		System.out.println("---------3.�˺Ź���----------");
		int num2=input.nextInt();
		switch(num2){
		case 1:
				System.out.print("�����뵼��ID��:");
				String _leadId=input.next();
				lc.MfindProjectByleadId(_leadId);
				break;
		case 2:
			//ͨ��Ա���Ų��ҹ���
			break;
		case 3: 
			System.out.println("---------0.�˳���¼----------");
			System.out.println("---------1.�޸��˺�-----------");
			System.out.println("---------2.�޸�����-----------");
			int b=input.nextInt();
			switch(b){
			case 1:lc.UpdateEmployeeTelByeId(u1.getuTel());break;
			case 2:is.updateUser(u1, 1); break;
			default:break;
			}
			break;
		default:
				break;
		}
		if(num2==0){
			System.out.println("�˳���¼");
			break;
		}

		}
}
}