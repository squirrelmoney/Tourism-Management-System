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
			System.out.println("---------1.登陆-----------");
			System.out.println("---------2.注册-----------");
			System.out.println("---------3.退出系统----------");
			System.out.print("请选择:");
		int num1=input.nextInt();
		switch(num1){
		
		case 1:			//登陆---获取信息---跳转到相应权限的页面
            
            System.out.print("账号：");
            String _uTel=input.next();
            System.out.print("密码：");
            String _uPassWord=input.next();
            for (User u1 :u.Login(_uTel, _uPassWord)) {
				if(u1.getuSuper()==1){
					//管理员
					adminView a1=new adminView();
				    a1.admin();
				}
				else if(u1.getuSuper()==2){
					//负责人
					chargerView charger =new chargerView();
					charger.charger();
				}
				else if(u1.getuSuper()==3){
					leaderView leader=new leaderView();
					leader.leader(u1);				
				}
				else if(u1.getuSuper()==4){
					//普通用户
				u2.userview(u1);
				}
			}
			break;
		case 2:
			//注册--获取信息---跳转到相应权限页面
			System.out.println("输入需要注册的账户");
			String _auTel =input.next();
			System.out.println("请输入密码");
			String _auPassWord =input.next();
			if(u.InsertUser(_auTel, _auPassWord)){
				System.out.println("注册成功");
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
