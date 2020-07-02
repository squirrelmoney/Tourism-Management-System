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
			System.out.println("---------0.�˳���¼----------");
			System.out.println("---------1.�ҵ���;-----------");
			System.out.println("---------2.����Ŀ�ĵ�-----------");
			System.out.println("---------3.�鿴���----------");
			System.out.println("---------4.�˺Ź���----------");
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
				//�����ֻ���ɾ��----------------ע���˺�ʱ-----------------�޸��˺�ʱ
				//�����˺�
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

