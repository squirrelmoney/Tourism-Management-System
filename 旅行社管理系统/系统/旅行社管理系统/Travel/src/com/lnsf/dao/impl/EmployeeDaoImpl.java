package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IemployeeDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Employee;

public class EmployeeDaoImpl implements IemployeeDao{
	//查找所有的员工信息，返回一个list
	public List<Employee> findAllEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		Statement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select * from employee");
		    while(rs.next()){
		    	Employee e=new Employee(rs.getString("eId"), rs.getString("eName"), 
		    			rs.getString("eTel"), rs.getString("eTitle"));
				list.add(e);

		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, stat, conn);
		}
		return list;
	}


	//插入新员工信息
	public boolean insertInfoToEmployee(Employee e) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("insert into employee values(?,?,?,?)");
			prep.setString(1,e.geteId());
			prep.setString(2,e.geteName());
			prep.setString(3,e.geteTel());
			prep.setString(4,e.geteTitle());
			int n=prep.executeUpdate();
			if(n!=0){
				flag=true;
			}
		 }catch (SQLException e1) {
				e1.printStackTrace();
			 }finally{
				Dbutil.closeConnection(prep, conn);
			}
		return flag;
	}

	//当员工升职了，修改用户登录表的权限,修改员工的基本工资
	public boolean updateEmployeeTitleByeId(String _eId,String _eTitle) {
		boolean flag=false;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		PreparedStatement prep2=null;
		PreparedStatement prep3=null;
		PreparedStatement prep4=null;
		PreparedStatement prep5=null;
		 ResultSet rs=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        ResultSet rs3=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement
			("select uSuper from user where uTel="
					+ "(select eTel from employee where etitle=? limit 1)");
			prep.setString(1,_eTitle);
			rs=prep.executeQuery();
            while(rs.next()){
            	prep4=conn.prepareStatement("select eTel from  employee where eId=?");
    			prep4.setString(1,_eId);
    			rs3=prep4.executeQuery();
    			while(rs3.next()){
			prep1=conn.prepareStatement("update user set usuper=? where uTel=?");
			prep1.setString(1,rs.getString("uSuper"));
			prep1.setString(2,rs3.getString("eTel"));
			int n=prep1.executeUpdate();
			if(n==0){
				System.out.println("用户表权限修改失败，请检查");
			}
    			}
            }
            prep2=conn.prepareStatement
        			("select baseSalary from salary where seId"
        					+ "=(select eId from employee where etitle=? limit 1)");
        			prep2.setString(1,_eTitle);
        			rs2=prep2.executeQuery();
                    while(rs2.next()){
        			prep3=conn.prepareStatement("update salary set baseSalary=? where seId=?");
        			prep3.setString(1,rs2.getString("baseSalary"));
        			prep3.setString(2,_eId);
        			int n=prep3.executeUpdate();
        			if(n==0){
        				System.out.println("员工基本工资修改失败，请检查");
        			}
                    }
            prep5=conn.prepareStatement("update employee set eTitle=? where eId=?");
			prep5.setString(1,_eTitle);
			prep5.setString(2,_eId);
	 		int n=prep5.executeUpdate();
	 		if(n!=0){
	 			flag=true;
	 		}
			conn.commit();
 		 	conn.setAutoCommit(true);
			}catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				 Dbutil.closeConnection(rs, prep, conn);
				 Dbutil.closeConnection(rs1, prep1, conn);
				 Dbutil.closeConnection(rs2, prep2, conn);
				 Dbutil.closeConnection(rs3, prep4, conn);
			 }
		return flag;
	}

	//当员工修改电话号码，修改用户登录表的电话号码
	public boolean updateEmployeeTelByeId(String old_eTel,String new_eTel) {
		boolean flag=false;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement("update employee set eTel=? where eTel=?");
			prep.setString(1,new_eTel);
			prep.setString(2,old_eTel);
			int n=prep.executeUpdate();
			if(n!=0){
				flag=true;
				conn.commit();
				conn.setAutoCommit(true);
			}
			prep1=conn.prepareStatement("update user set uTel=? where uTel=?");
			prep1.setString(1,new_eTel);
			prep1.setString(2,old_eTel);
			n=prep1.executeUpdate();
			if(n==0){
				System.out.println("用户账号修改失败，请检查");
			}
			
		 }catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				Dbutil.closeConnection(prep, conn);
				Dbutil.closeConnection(prep1, conn);
			}
		return flag;
	}

	//删除员工信息，同时删除该员工的工资信息，删除用户登录表该员工的信息和修改项目表中导游或者负责人置NULL
	public boolean deleteEmployee(String _eId) {
		boolean flag=false;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			conn.setAutoCommit(false);
			prep=conn.prepareStatement
					("update user set uSuper=4 where uTel="
							+ "(select eTel from employee where eId=?)");
			prep.setString(1,_eId);
			prep.executeUpdate();
			prep1=conn.prepareStatement("delete from employee where eId=?");
			prep1.setString(1,_eId);
			int i=prep1.executeUpdate();
			if(i!=0){
			flag=true;
			conn.commit();
			conn.setAutoCommit(true);
			}
		 }catch (SQLException e) {
	 			try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 			e.printStackTrace();
	 		}finally{
				Dbutil.closeConnection(prep, conn);
				Dbutil.closeConnection(prep1, conn);
			}
		return flag;
	}


	
	public boolean updateEmployee(Employee e) {
		boolean flag=false;
		PreparedStatement prep=null;
		Connection conn=null;
		try {
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update employee set eId=?,eName=?,eTel=?,eTitle=? where eId=?");
			prep.setString(1,e.geteId());
			prep.setString(2,e.geteName());
			prep.setString(3,e.geteTel());
			prep.setString(4,e.geteTitle());
			prep.setString(5,e.geteId());
			int n=prep.executeUpdate();
			if(n!=0){
				flag=true;
			}
		 }catch (SQLException e1) {
				e1.printStackTrace();
			 }finally{
				Dbutil.closeConnection(prep, conn);
			}
		return flag;
	}


	//根据项目号查找有空的导游
	public List<String> findEmployeeByepId() {
		List<String> list=new ArrayList<String>();
		Statement stat=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
		    rs=stat.executeQuery("select eId from employee where eId not in("
		    		+ "select distinct p.leadId from information i,project p"
		    		+ " where i.ipId=p.pId and i.iflag=1)"
		    		+ " and eTitle='导游';");
		    while(rs.next()){
				list.add(rs.getString("eId"));

		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Dbutil.closeConnection(rs, stat, conn);
		}
		return list;
	}
			
}
