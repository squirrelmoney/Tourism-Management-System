package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IbookDao;
import com.lnsf.dao.IinformationDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Book;
import com.lnsf.model.Information;

public class InformationDaoImpl implements IinformationDao {

	//查找所有的用户信息，返回一个list
	public List<Information> findAllInformation() {
		List<Information> list=new ArrayList<Information>();
		Statement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from information";
		    rs=stat.executeQuery(sql);
		    while(rs.next()){
		    	Information i=new Information(rs.getString("iTel"), rs.getString("ipId"),rs.getString("iName"), 
						rs.getString("iNum"), rs.getInt("iroom"),rs.getInt("itimes"), rs.getInt("iflag"));
				list.add(i);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, stat, conn);
		}
		
		return list;
	}

	

	//当项目可以顺利进行时，从预约表插入新用户信息
	public boolean insertInfoToInformation(Information b) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("insert into information values(?,?,?,?,?,?,?)");
			prep.setString(1,b.getiTel());
			prep.setString(2, b.getIpId());
			prep.setString(3,b.getiName());
			prep.setString(4, b.getiNum());
			prep.setInt(5,b.getIroom());
			prep.setInt(6, b.getItimes());
			prep.setInt(7,b.getIflag());
		    int n=prep.executeUpdate();
		    if(n!=0){
		    	flag=true;
		    }
		}
			catch (SQLException e) {
		}finally{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;
	}





	public boolean updateInformation(Information m,String old_bTel) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		int num=0;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("update information set iTel=?,ipId=?,"
		    		+ "iName=?,iNum=?,iroom=?,itimes=?,iflag=? where iTel=?");
		    prep.setString(1,m.getiTel());
			prep.setString(2,m.getIpId());
			prep.setString(3,m.getiName());
			prep.setString(4, m.getiNum());
			prep.setInt(5,m.getIroom());
			prep.setInt(6, m.getItimes());
			prep.setInt(7,m.getIflag());
			prep.setString(8,old_bTel);
		    int n=prep.executeUpdate();
		    if(n!=0){
			   flag=true;
			}
		     }
			catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, prep, conn);
		}
		return flag;
	}
	
	//删除
	public boolean deleteInformationByTel(String _bTel) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement("delete from Information where iTel=?");
			prep.setString(1,_bTel);
			int i=prep.executeUpdate();
			if(i!=0){
			flag=true;
			conn.commit();
			conn.setAutoCommit(true);
			}
		 }catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				Dbutil.closeConnection(prep, conn);
			}
		return flag;
	}



	//算出vip人数
	public int countVip(String _ipId) {
		int n=0;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement
			("select count(*) vip from information  where ipid=? and iflag=1 and itimes>=2");
			prep.setString(1,_ipId);
			rs=prep.executeQuery();
			if(rs.next()){
			n=Integer.parseInt(rs.getString("vip"));
			conn.commit();
			conn.setAutoCommit(true);
			}
		 }catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				Dbutil.closeConnection(rs,prep, conn);
			}
		return n;
	}



	//算出非normal人数
	public int countnormal(String _ipId) {
		int n=0;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement
			("select count(*) vip from information  where ipid=? and iflag=1 and itimes=1");
			prep.setString(1,_ipId);
			rs=prep.executeQuery();
			if(rs.next()){
			n=Integer.parseInt(rs.getString("vip"));
			conn.commit();
			conn.setAutoCommit(true);
			}
		 }catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				Dbutil.closeConnection(rs,prep, conn);
			}
		return n;
	}
	public boolean updateInformationBypId(String _ipId,int _iflag) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		int num=0;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("update information set iflag=? where ipId=?");
		    prep.setInt(1, _iflag);
		    prep.setString(2, _ipId);
		    int n=prep.executeUpdate();
		    if(n!=0){
			   flag=true;
			}
		     }
			catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, prep, conn);
		}
		return flag;
	}

}
