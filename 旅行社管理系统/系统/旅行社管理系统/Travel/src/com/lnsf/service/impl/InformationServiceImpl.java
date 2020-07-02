package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.IinformationDao;
import com.lnsf.dao.impl.InformationDaoImpl;
import com.lnsf.model.Book;
import com.lnsf.model.Information;
import com.lnsf.service.IbookService;
import com.lnsf.service.IinformationService;

public class InformationServiceImpl implements IinformationService {

	//查找所有的用户信息，返回一个list
	public List<Information> AllInformation() {
		IinformationDao i=new InformationDaoImpl();
		List<Information> list=new ArrayList<Information>();
		for (Information i1 : i.findAllInformation()) {
			list.add(i1);
		}
		return list;
	}

	//负责人或者导游根据项目号查找用户信息，返回参加这个项目的所有用户信息
	public List<Information> InformationByipId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		List<Information> list=new ArrayList<Information>();
		Scanner in=new Scanner(System.in);
		int k=0;
		while(true){
		System.out.println("状态：1.正在进行      2.已结束      0.返回");
		int n=in.nextInt();
		for (Information i1 : i.findAllInformation()) {
			if(i1.getIpId().equals(_ipId)&&i1.getIflag()==1&&n==1){
			System.out.println(i1);
			list.add(i1);
            if(list.size()>0){
			  k=1;//标记
            }
			}
			else if(i1.getIpId().equals(_ipId)&&i1.getIflag()==2&&n==2){
				System.out.println(i1);
				list.add(i1);
				 if(list.size()>0){
						k=1;//标记
			        }
			}
		}
		if(k==0&&n==1){
			System.out.println("该项目现在没有人参加");
		}else if(k==0&&n==2){
			System.out.println("该项目没有人参加过");
		}
        if(n==0){
			break;
		}
		}
		return list;
	}

	//从预约表插入新用户信息
	public boolean InsertInformationFromBook(String _ipId) {
		boolean flag=false;
		IbookService bs=new BookServiceImpl();
		List<Information> list =new ArrayList<Information>();
		IinformationDao im=new InformationDaoImpl();
		int n=0;
        int max=bs.CountNumBypId(_ipId);
		for (Book i : bs.BookBypId(_ipId)) {
		if(i.getBflag()==1){
		for (Information in : im.findAllInformation())
		{
		if(i.getBpId().equals(in.getIpId())&&i.getbTel().equals(in.getiTel())){
			Information m=new Information(i.getbTel(), i.getBpId(), i.getbName(), 
					i.getbNum(),i.getBroom(),in.getItimes()+1,1);	
		    im.updateInformation(m,i.getbTel());
		    n++;
		}
		else if(i.getBpId().equals(in.getIpId())&&!i.getbTel().equals(in.getiTel())){
			Information m=new Information(i.getbTel(), i.getBpId(), i.getbName(), 
					i.getbNum(),i.getBroom(),in.getItimes(),1);	
			im.insertInfoToInformation(m);
			n++;
		}
		}
		}
		}
		
			flag=true;
		
		return flag;
	}

	//数出一个项目vip人数
	public int CountVipNumBypId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		int n=0;
		n=i.countVip(_ipId);
		return n;
	}

	//数出一个项目非vip人数
	public int CountnormalNumBypId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		int n=0;
		n=i.countnormal(_ipId);
		return n;
	}
	//根据手机号删除
	public boolean deleteInformationByTel(String _iTel) {
			boolean flag=false;
			IinformationDao i=new InformationDaoImpl();
			flag=i.deleteInformationByTel(_iTel);
			return flag;
		}

	//更新账号
	public boolean updateInformationByiTel(String old_bTel, String new_bTel) {
		boolean flag=false;
		IinformationDao i=new InformationDaoImpl();
	    for (Information i1 : i.findAllInformation()) {
			if(i1.getiTel().equals(old_bTel)){
				Information m=new Information(new_bTel, i1.getIpId(), i1.getiName(),
						i1.getiNum(), i1.getIroom(),i1.getItimes() , i1.getIflag());
				flag=i.updateInformation(m,old_bTel);
			}
		}
		return flag;
	}

	//根据项目号改变用户旅游状态
	public boolean updateInformationByipId(String _ipId,int _iflag) {
		boolean flag=false;
		IinformationDao im=new InformationDaoImpl();
		im.updateInformationBypId(_ipId,_iflag);
		return flag;
	}


	}


