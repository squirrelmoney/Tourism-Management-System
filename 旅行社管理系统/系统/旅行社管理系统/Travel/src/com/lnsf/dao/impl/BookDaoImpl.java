package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IbookDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Book;

public class BookDaoImpl implements IbookDao {
	//查找所有的预约信息，返回一个list
	public List<Book> findAllBook() {
		List<Book> list=new ArrayList<Book>();
		Statement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from book";
		    rs=stat.executeQuery(sql);
		    while(rs.next()){
				Book b=new Book(rs.getString("bTel"), rs.getString("bpId"),rs.getString("bName"), 
						rs.getString("bNum"), rs.getInt("broom"), rs.getInt("bflag"));
				list.add(b);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, stat, conn);
		}
		
		return list;
	}

	
	
	
	//插入新预约信息
	public int insertInfoToBook(Book b) {
		int flag=0;
		List<Book> list=new ArrayList<Book>();
		PreparedStatement prep1=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
            conn=Dbutil.getConnection();
			prep1=conn.prepareStatement("insert into book values(?,?,?,?,?,?)");
			prep1.setString(1,b.getbTel());
			prep1.setString(2, b.getBpId());
			prep1.setString(3,b.getbName());
			prep1.setString(4, b.getbNum());
			prep1.setInt(5,b.getBroom());
			prep1.setInt(6,b.getBflag());
			int n=prep1.executeUpdate();
			if(n!=0){
				flag=1;
			}
		 }
			catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, prep1, conn);
		}
		return flag;
	}

	//定时删除预约信息
	public boolean deleteBookBypId(String _bpId) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("delete from  book where bpId=?");
			prep.setString(1,_bpId);
			int n=prep.executeUpdate();
			if(n!=0){
				flag=true;
			}
		     }
			catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;
	}




	//更新信息
	public boolean UpdateBook(Book b,String old_bTel) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		ResultSet rs=null;
		int num=0;
		try {
			conn=Dbutil.getConnection();
		    prep=conn.prepareStatement("update Book set bTel=?,BpId=?,"
		    		+ "bName=?,bNum=?,Broom=?,Bflag=? where bTel=?");
		    prep.setString(1,b.getbTel());
			prep.setString(2, b.getBpId());
			prep.setString(3,b.getbName());
			prep.setString(4, b.getbNum());
			prep.setInt(5,b.getBroom());
			prep.setInt(6,b.getBflag());
			prep.setString(7,old_bTel);
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
	public boolean deleteBookByTel(String _bTel) {
		boolean flag=false;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement("delete from Book where bTel=?");
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





	}

