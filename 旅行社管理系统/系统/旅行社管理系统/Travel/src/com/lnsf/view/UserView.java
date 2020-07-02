package com.lnsf.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.controller.userController;
import com.lnsf.model.Book;
import com.lnsf.model.Information;
import com.lnsf.model.User;
import com.lnsf.service.IbookService;
import com.lnsf.service.IinformationService;
import com.lnsf.service.impl.BookServiceImpl;
import com.lnsf.service.impl.InformationServiceImpl;
public class UserView {

	public  void  userview(User u1){
		userController uc=new userController();
		IbookService ib=new BookServiceImpl();
		IinformationService is=new InformationServiceImpl();
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("---------0.退出登录----------");
			System.out.println("---------1.我的旅途-----------");
			System.out.println("---------2.搜索目的地-----------");
			System.out.println("---------3.查看类别----------");
			System.out.println("---------4.账号管理----------");
			int num2=input.nextInt();
			switch(num2){
			case 1:
				List<Book> list=new ArrayList<Book>();
				list=ib.BookBybTel(u1.getuTel());
				if(list.size()>0){
					for (Book b : list) {
						if(b.getBflag()==1){
							System.out.println(b);
						}
					}
				}if(is.AllInformation().size()>0){
					for(Information i:is.AllInformation()){
						if(i.getiTel().equals(u1.getuTel())){
							System.out.println(i);
						}
					}
				}
				break;
			case 2:
					uc.UfindProjectByDestination();				
				    break;
			case 3:
					uc.UfindProjectBypcId();
					break;
			case 4:
				uc.updateUser(u1);		
				//根据手机号删除----------------注销账号时-----------------修改账号时
				//更改账号
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

