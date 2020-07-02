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

	//�������е��û���Ϣ������һ��list
	public List<Information> AllInformation() {
		IinformationDao i=new InformationDaoImpl();
		List<Information> list=new ArrayList<Information>();
		for (Information i1 : i.findAllInformation()) {
			list.add(i1);
		}
		return list;
	}

	//�����˻��ߵ��θ�����Ŀ�Ų����û���Ϣ�����زμ������Ŀ�������û���Ϣ
	public List<Information> InformationByipId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		List<Information> list=new ArrayList<Information>();
		Scanner in=new Scanner(System.in);
		int k=0;
		while(true){
		System.out.println("״̬��1.���ڽ���      2.�ѽ���      0.����");
		int n=in.nextInt();
		for (Information i1 : i.findAllInformation()) {
			if(i1.getIpId().equals(_ipId)&&i1.getIflag()==1&&n==1){
			System.out.println(i1);
			list.add(i1);
            if(list.size()>0){
			  k=1;//���
            }
			}
			else if(i1.getIpId().equals(_ipId)&&i1.getIflag()==2&&n==2){
				System.out.println(i1);
				list.add(i1);
				 if(list.size()>0){
						k=1;//���
			        }
			}
		}
		if(k==0&&n==1){
			System.out.println("����Ŀ����û���˲μ�");
		}else if(k==0&&n==2){
			System.out.println("����Ŀû���˲μӹ�");
		}
        if(n==0){
			break;
		}
		}
		return list;
	}

	//��ԤԼ��������û���Ϣ
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

	//����һ����Ŀvip����
	public int CountVipNumBypId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		int n=0;
		n=i.countVip(_ipId);
		return n;
	}

	//����һ����Ŀ��vip����
	public int CountnormalNumBypId(String _ipId) {
		IinformationDao i=new InformationDaoImpl();
		int n=0;
		n=i.countnormal(_ipId);
		return n;
	}
	//�����ֻ���ɾ��
	public boolean deleteInformationByTel(String _iTel) {
			boolean flag=false;
			IinformationDao i=new InformationDaoImpl();
			flag=i.deleteInformationByTel(_iTel);
			return flag;
		}

	//�����˺�
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

	//������Ŀ�Ÿı��û�����״̬
	public boolean updateInformationByipId(String _ipId,int _iflag) {
		boolean flag=false;
		IinformationDao im=new InformationDaoImpl();
		im.updateInformationBypId(_ipId,_iflag);
		return flag;
	}


	}


