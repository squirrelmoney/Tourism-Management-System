package com.lnsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lnsf.dao.impl.FinancingDaoImpl;
import com.lnsf.model.Financing;
import com.lnsf.model.Project;
import com.lnsf.service.IfinacingService;
import com.lnsf.service.IinformationService;

public class FinancingServiceImpl implements IfinacingService{

	//查找所有的财务信息，返回一个list
	public List<Financing> AllFinancing() {
		FinancingDaoImpl f=new FinancingDaoImpl();
		List<Financing> list=new ArrayList<Financing>();
		for (Financing f1 : f.findAllFinancing()) {
			list.add(f1);
		}
		return list;
	}

	//插入新财务信息
	public boolean InsertFinancing(String _fpId) {
		boolean flag=false;
		int n1=0;
		FinancingDaoImpl fd=new FinancingDaoImpl();
		Financing f=new Financing(null, 0, 0, 0, 0);
		ProjectServiceImpl pj=new ProjectServiceImpl();
		List<Financing> list=new ArrayList<Financing>();
		Scanner in=new Scanner(System.in);
		int n=0;
		for (Project p : pj.AllProject()) {
			if(p.getpId().equals(_fpId)){
			    n=2;
			}
		}
		for (Financing f1 : fd.findAllFinancing()) {
			if(f1.getFpId().equals(_fpId)){
				System.out.println("该项目已经有财务啦！");
				n=1;
				break;
			}
		}
		if(n==2){
		f.setFpId(_fpId);
		System.out.println("请输入该项目每个人的成本：");
		f.setBasepay(in.nextDouble());
		System.out.println("请输入该项目订一间房的资金：");
		f.setPoundage(in.nextDouble());
		f.setProfit(0);
		flag=fd.insertInfoToFinancing(f);
		return flag;
		}else if(n==0){
			System.out.println("一定要填已存在的项目号");
		}
		return flag;
	}

	//更新基本成本，不包括利润
	public boolean UpdateFinancing(Financing f) {
		boolean flag=false;
		String _eTitle;
		Scanner in=new Scanner(System.in);
		FinancingDaoImpl fd=new FinancingDaoImpl();
		for (Financing fn : fd.findAllFinancing()) {
			if(fn.getFpId().equals(f.getFpId())){
					flag=fd.updateFinancing(f);
			}
			}
		return flag;
	}

	//根据项目号更新利润
	public boolean UpdateProfit() {
		boolean flag=false;
		FinancingDaoImpl f=new FinancingDaoImpl();
		IinformationService is=new InformationServiceImpl();
		int vip=0,all=0,normal=0;
		double profit=0,base=0;
		for (Financing f1 : f.findAllFinancing()) {
		vip=is.CountVipNumBypId(f1.getFpId());
		normal=is.CountnormalNumBypId(f1.getFpId());
		all=vip+normal;
		if(all!=0){
		base=f1.getBasepay()+f1.getRoompay()+f1.getPoundage();
		profit=(normal*f1.getPoundage())+(base*vip*0.9)-(f1.getBasepay()+f1.getRoompay());
		if(f.updateFinancingBypId(f1.getFpId(), f1.getProfit()+profit))
		flag=is.updateInformationByipId(f1.getFpId(),2);
		}
		if(profit<0){
			flag=f.updateFinancingBypId(f1.getFpId(), 0);
		}
		}
		return flag;
	}

	


}
