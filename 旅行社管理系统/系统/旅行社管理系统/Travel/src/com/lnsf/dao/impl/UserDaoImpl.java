package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IuserDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.User;

public class UserDaoImpl implements IuserDao{
	//�������е��û���¼��Ϣ������һ��list
		public List<User> findAllUser(){
			List<User> l =new ArrayList<User>();	
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=Dbutil.getConnection();
				stat=conn.createStatement();
				String sql = "select * from user";
				rs=stat.executeQuery(sql);
				while(rs.next()){
					User u = new User(rs.getString("uTel"),rs.getString("uPassWord"),rs.getInt("uSuper"));
					l.add(u);
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
		
		//�����û��ֻ��ź���������û���Ȩ��
		public int login(String _uTel,String _uPassWord){
	      int flag = 0;
		  Connection conn=null;
		  PreparedStatement prep=null;
		  ResultSet  rs=null;
			try {
				conn=Dbutil.getConnection();
				prep = conn.prepareStatement
						 ("select uSuper from user where uTel = ? and uPassWord = ?");
				prep.setString(1,_uTel);
				prep.setString(2,_uPassWord);
				 rs = prep.executeQuery();
	                 if(rs.next())
	                 {
	                	  flag=rs.getInt("uSuper");
	                	  System.out.println(flag);
	                }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
					Dbutil.closeConnection(rs, prep, conn);
				}		
				return flag;
		}
		
		
		//2.�������û���¼��Ϣ
		public int insertInfoToUser(User u){
       	int flag=0;       	
 		  Connection conn=null;
 		  PreparedStatement prep=null; 
 		try {
 			
			conn=Dbutil.getConnection();
			prep = conn.prepareStatement("insert into user values(?,?,?)");
			 prep.setString(1, u.getuTel());
			 prep.setString(2, u.getuPassWord());
			 prep.setInt(3, u.getuSuper());
		     int n=prep.executeUpdate();
	         if(n!=0){
	        	 flag = 1;
	         }
			
 		}catch (SQLException e) {
			flag = 2;//����д��󷵻�2
			//e.printStackTrace();
		}finally{
				Dbutil.closeConnection(prep, conn);
				
		}
		return flag;  		
		}

		
		//2.�����û���¼��Ϣ������uTel �޸� �˻�������
		public int updateUser(User u,String _uTel){
		    int flag=0;       	
		  	Connection conn=null;
		  	PreparedStatement prep=null; 
		  	try {		  			
					conn=Dbutil.getConnection();
					prep = conn.prepareStatement("update user set uTel = ? ,uSuper = ? ,uPassword = ?  where uTel = ?");
					prep.setString(1, u.getuTel());
					 prep.setInt(2, u.getuSuper());
					 prep.setString(3, u.getuPassWord());
					 prep.setString(4, _uTel);
				     int n=prep.executeUpdate();
			         if(n!=0){
			        	
			        	 flag = 1;
			         }
					
		  		}catch (SQLException e) {
					flag = 2;//����д��󷵻�2
					e.printStackTrace();
				
				}finally{
						Dbutil.closeConnection(prep, conn);
						
				}
				return flag;  		
				} 
		
		     //�޸�Ȩ��
		     public int updateUser1(User u){
			    int flag=0;       	
			  	Connection conn=null;
			  	PreparedStatement prep=null; 
			  	try {		  			
						conn=Dbutil.getConnection();
						prep = conn.prepareStatement("update user set uTel = ? ,uSuper = ? ,uPassword = ?  where uTel = ?");
						prep.setString(1, u.getuTel());
						 prep.setInt(2, u.getuSuper());
						 prep.setString(3, u.getuPassWord());
						 prep.setString(4, u.getuTel());
					     int n=prep.executeUpdate();
				         if(n!=0){
				        	
				        	 flag = 1;
				         }
						
			  		}catch (SQLException e) {
						flag = 2;//����д��󷵻�2
						e.printStackTrace();
					
					}finally{
							Dbutil.closeConnection(prep, conn);
							
					}
					return flag;  		
					} 
		

		// 2.ɾ���û���¼��Ϣ
		            public int deleteUser(String _uTel){
		            int flag=0;
		            Connection conn=null;
				     PreparedStatement  prep=null;
				     try{
				    	 conn = Dbutil.getConnection();
				    	 prep =conn.prepareStatement
					    		 ("delete from user where uTel = ?");
					     prep.setString(1,_uTel);
			           int n=prep.executeUpdate();
			           if(n!=0)
					 	flag = 1;					 			
				} catch (SQLException e) {
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
