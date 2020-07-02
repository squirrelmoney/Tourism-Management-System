package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IcategoryDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Category;

public class CategoryDaoImpl implements IcategoryDao
{
	//查找所有的类别信息，返回一个list
	public List<Category> findAllCategory()
	{
		List<Category> l=new ArrayList<Category>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try
		{
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from category";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				Category c=new Category(rs.getString("cId"), rs.getString("cName"));
				l.add(c);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		finally
		{
			Dbutil.closeConnection(rs, stat, conn);
		}
		return l;
	}

	//插入新类别信息
	public boolean insertInfoToCategory(Category c)
	{
		boolean flag=false;
		String _cId=c.getcId();
		String _cName=c.getcName();
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("insert into category values(?,?)");
			prep.setString(1, _cId);
			prep.setString(2, _cName);
			prep.executeUpdate();
			flag=true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		finally
		{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;		
	}
	
	//更新类别信息
	public boolean updateCategory(Category c)
	{
		boolean flag=false;
		String _cId=c.getcId();
		String _cName=c.getcName();
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update category set cName=? where cId=?");
			prep.setString(1, _cName);
			prep.setString(2, _cId);
			prep.executeUpdate();
			flag=true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			Dbutil.closeConnection(prep, conn);
		}
		return flag;
	}
}
