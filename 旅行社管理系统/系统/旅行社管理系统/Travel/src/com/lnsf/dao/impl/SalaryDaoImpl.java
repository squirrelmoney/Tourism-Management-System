package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IsalaryDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Salary;

public class SalaryDaoImpl  implements IsalaryDao{
	//�������е�Ա��������Ϣ������һ��list
	public List<Salary> findAllSalary(){
			List<Salary> l =new ArrayList<Salary>();	
			Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			try{
				conn=Dbutil.getConnection();
				stat=conn.createStatement();
				String sql = "select * from salary";
				rs=stat.executeQuery(sql);
				while(rs.next()){
					Salary s = new Salary(rs.getString("seId"),rs.getDouble("baseSalary"),rs.getDouble("insurance"),rs.getDouble("reward"));
					l.add(s);
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
			
			
	//����Ա���Ų��ҹ��ʣ�����Ա��������Ϣ
			public List<Salary> findSalaryBycId(String _seId){
				List<Salary> l =new ArrayList<Salary>();	
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try{
					conn=Dbutil.getConnection();
					prep = conn.prepareStatement
							 ("select * from salary where seId = ?");
					 prep.setString(1,_seId);
					 rs = prep.executeQuery();					
					while(rs.next()){
						Salary s = new Salary(rs.getString("seId"),rs.getDouble("baseSalary"),rs.getDouble("insurance"),rs.getDouble("reward"));
						l.add(s);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					Dbutil.closeConnection(rs, prep, conn);
				}
				return l;
			}
			
			
			
			//1.������Ա��������Ϣ��Ҫ��Ա���������ȴ���
			public int insertInfoToSalary(Salary s) {
				int flag=0;
  		  Connection conn=null;
  		  PreparedStatement prep=null;
  		  PreparedStatement prep1 = null;
  		  PreparedStatement prep2 = null;
  	      ResultSet  rs=null;
  		  ResultSet  rs1=null;
  		try {
  			//�����û����ڷ���2
			conn=Dbutil.getConnection();
			 prep1= conn.prepareStatement
	  ("select * from salary where seId=(select eId from employee where eTitle="
	  		+ "(select eTitle from employee where eId=?)"
	  		+ " order by eId DESC limit 1,1);");
			 prep1.setString(1, s.getSeId());
			 rs1=prep1.executeQuery();
			 while(rs1.next()){
			 //���û������ڵ�����¶�ִ�в���Ĳ���
			 prep2 = conn.prepareStatement("insert into salary values(?,?,?,?)");
			 prep2.setString(1, s.getSeId());
			 prep2.setDouble(2, rs1.getDouble("baseSalary"));
			 prep2.setDouble(3, rs1.getDouble("insurance"));
			 prep2.setDouble(4,s.getReward());
		     if(prep2.executeUpdate()!=0)
		  	 flag = 1;	    
			 }
		} 	catch (SQLException e) {
			flag = 2;//����д��󷵻�2
			e.printStackTrace();
		}  
  		finally
  		{
	 		try
	 		{
	 			if(rs1!=null)
	 				rs1.close();
				if(rs!=null)
					rs.close();
	 			if(prep2!=null)
					prep2.close();
				if(prep1!=null)
					prep1.close();
				if(prep!=null)
					prep.close();				 
				if(conn!=null)
					conn.close();	 				
	 		}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}	
		} 
  		return flag;  					 
        }
			
			//2.����Ա��������Ϣ,���޸Ļ�������ʱ��ͬһְλ��Ա����Ҫͬ�����£����ղ����޸�
			public int updateSalary(Salary s) {
			int flag=0;       	
	  		  Connection conn=null;
	  		  PreparedStatement prep=null; 
	  		try {		  			
				conn=Dbutil.getConnection();
				prep = conn.prepareStatement("update salary set seId=? , baseSalary = ?  ,insurance = ? , reward = ? where seId = ?");
				 prep.setString(1,s.getSeId());
				 prep.setDouble(2,s.getBaseSalary());
				 prep.setDouble(3,s.getInsurance());
				 prep.setDouble(4,s.getReward());
				 prep.setString(5,s.getSeId());
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

			//2.ɾ��Ա��������Ϣ
			public boolean deleteSalary(String _seId){
				boolean flag=false;
				 Connection conn=null;
			     PreparedStatement  prep=null;
	             ResultSet rs=null;
			     try{
			    	 conn = Dbutil.getConnection();

		         //---------ɾ��salary---------
			     prep =conn.prepareStatement
			    		 ("delete from salary where seId = ?");
			     prep.setString(1,_seId);
		        int n=prep.executeUpdate();
		        if(n!=0)
				flag = true;					 			
				} catch (SQLException e) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}finally{
		      Dbutil.closeConnection(rs, prep, conn);
			}		
				return flag;		
			    	 
			     }


			}
