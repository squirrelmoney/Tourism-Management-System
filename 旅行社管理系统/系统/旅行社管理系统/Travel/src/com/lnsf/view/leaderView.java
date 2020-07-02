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
		System.out.println("---------0.退出登录----------");
		System.out.println("---------1.负责项目-----------");
		System.out.println("---------2.我的工资-----------");
		System.out.println("---------3.账号管理----------");
		int num2=input.nextInt();
		switch(num2){
		case 1:
				System.out.print("请输入导游ID号:");
				String _leadId=input.next();
				lc.MfindProjectByleadId(_leadId);
				break;
		case 2:
			//通过员工号查找工资
			break;
		case 3: 
			System.out.println("---------0.退出登录----------");
			System.out.println("---------1.修改账号-----------");
			System.out.println("---------2.修改密码-----------");
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
			System.out.println("退出登录");
			break;
		}

		}
}
}