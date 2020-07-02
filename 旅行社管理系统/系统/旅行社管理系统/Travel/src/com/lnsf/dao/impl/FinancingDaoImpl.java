package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IfinancingDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Financing;

public class FinancingDaoImpl implements IfinancingDao{

	//�������еĲ�����Ϣ������һ��list
	public List<Financing> findAllFinancing() {
		List<Financing> list=new ArrayList<Financing>();
		Statement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from Financing";
		    rs=stat.executeQuery(sql);
		    while(rs.next()){
		    	Financing f=new Financing(rs.getString("fpId"),rs.getDouble("basepay") , 
		       rs.getDouble("roompay"), rs.getDouble("poundage"), rs.getDouble("profit"));
				list.add(f);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, stat, conn);
		}
		
		return list;
	}


	
	
	//�����²�����Ϣ,Ҫ����Ŀ���ȴ��ڲ�������Ϊ0
	public boolean insertInfoToFinancing(Financing f) {
		boolean flag=false;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("select * from project where pId=?");
		    prep.setString(1, f.getFpId());
		    rs=prep.executeQuery();
		     while(rs.next()){
			prep1=conn.prepareStatement("insert into Financing values(?,?,?,?,?)");
			prep1.setString(1,f.getFpId());
			prep1.setDouble(2, f.getBasepay());
			prep1.setDouble(3,f.getRoompay());
			prep1.setDouble(4,f.getPoundage());
			prep1.setDouble(5,0);
			int n=prep1.executeUpdate();
			if(n!=0){
				flag=true;
			}
		 }}
			catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(prep1, conn);
			Dbutil.closeConnection(rs, prep, conn);
		}
		return flag;
	}

	//���»�����Ϣ,���ܸ�������
	public boolean updateFinancing(Financing f) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("update financing set basepay=?,roompay=?,poundage=? where fpId=?");
			prep.setDouble(1, f.getBasepay());
			prep.setDouble(2,f.getRoompay());
			prep.setDouble(3,f.getPoundage());
			prep.setString(4,f.getFpId());
		    int n=prep.executeUpdate();
		    if(n!=0){
		    	flag=true;
		    }
		   }
			catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;
	}


	//������Ŀ�Ÿ�������
	public boolean updateFinancingBypId(String _fpId,double _profit) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("update financing set profit=? where fpId=?");
			prep.setDouble(1,_profit);
			prep.setString(2,_fpId);
		    int n=prep.executeUpdate();
		    if(n!=0){
		    	flag=true;
		    }
		   }
			catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;
	}





}
