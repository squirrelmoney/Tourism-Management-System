package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IprojectHistoryDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.ProjectHistory;

public class ProjectHistoryDaoImpl implements IprojectHistoryDao
{
	//�������е���ʷ��¼��Ϣ������һ��list
	public List<ProjectHistory> findAllProjectHistory()
	{
		List<ProjectHistory> l=new ArrayList<ProjectHistory>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try
		{
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from projectHistory";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				ProjectHistory ph=new ProjectHistory(rs.getString("hpId"), rs.getInt("phNumber"));
				l.add(ph);			
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
		
	//��������ʷ��¼��Ϣ��Ҫ����Ŀ���ȴ���
	public boolean insertInfoToProjectHistory(ProjectHistory ph)
	{
		boolean flag=false;
		String _hpId=ph.getHpId();
		int _phNumber=ph.getPhNumber();
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("insert into projectHistory values(?,?)");
			prep.setString(1, _hpId);
			prep.setInt(2, _phNumber);
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
	
	//������ʷ��¼��Ϣ�Ĵ�����Ҫ����Ŀ���ȴ���
	public  boolean updateProjectHistory(ProjectHistory ph)
	{
		boolean flag=false;
		String _hpId=ph.getHpId();
		int _phNumber=ph.getPhNumber();
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update projectHistory set phNumber=? where hpId=?");
			prep.setInt(1, _phNumber);
			prep.setString(2, _hpId);
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
