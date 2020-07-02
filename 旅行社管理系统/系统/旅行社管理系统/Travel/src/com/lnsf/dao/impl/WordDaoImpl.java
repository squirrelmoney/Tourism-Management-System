package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IwordDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Word;

public class WordDaoImpl  implements IwordDao
{
	
	//查找所有的热词搜索信息，返回一个list
		 public List<Word> findAllWord(){
			List<Word> l =new ArrayList<Word>();	
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=Dbutil.getConnection();
				stat=conn.createStatement();
				String sql = "select * from word";
				rs=stat.executeQuery(sql);
				while(rs.next()){
					Word w = new Word(rs.getString("wpName"),rs.getInt("wNumber"));
					l.add(w);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				Dbutil.closeConnection(rs, stat, conn);
			}
			return l;
		}
		 
			//2.更新热词信息
		     public boolean updateWord(String _wpName,int _wNumber) {
			boolean flag=false;      	
	  		  Connection conn=null;
	  		  PreparedStatement prep=null; 
	  		try {		  			
				conn=Dbutil.getConnection();
				prep = conn.prepareStatement("update word set wNumber = ? where wpName = ?");
				prep.setInt(1, _wNumber);
				 prep.setString(2, _wpName);
			     prep.executeUpdate();
		         flag=true;
				
	  		}catch (SQLException e) {
				e.printStackTrace();
			
			}finally{
					Dbutil.closeConnection(prep, conn);					
			}
			return flag; 
		     }
			
			//插入热词信息
		     public boolean insertWord(String _wpName,int _wNumber) {
			boolean flag=false;      	
	  		  Connection conn=null;
	  		  PreparedStatement prep=null; 
	  		try {		  			
				conn=Dbutil.getConnection();
				prep = conn.prepareStatement("insert into word values(?,?)");
				prep.setString(1, _wpName);
				 prep.setInt(2, 1);
			     prep.executeUpdate();
		         flag=true;
				
	  		}catch (SQLException e) {
				e.printStackTrace();
			
			}finally{
					Dbutil.closeConnection(prep, conn);					
			}
			return flag;  	
			}	
}		     
