package com.lnsf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lnsf.dao.IprojectDao;
import com.lnsf.dbutils.Dbutil;
import com.lnsf.model.Project;

public class ProjectDaoImpl implements IprojectDao
{
	//查找所有的项目信息，返回一个list
	public List<Project> findAllProject()
	{
		List<Project> l=new ArrayList<Project>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		try
		{
			conn=Dbutil.getConnection();
			stat=conn.createStatement();
			String sql="select * from project";
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				Project p=new Project(rs.getString("pId"), 
						rs.getString("pName"), rs.getString("destination"),
						rs.getInt("last"), rs.getString("beginning"), 
						rs.getString("ending"), rs.getString("describing"),
						rs.getInt("min"), rs.getInt("max"), rs.getInt("pflag"), 
						rs.getString("chargeId"), rs.getString("leadId"),
						rs.getString("pcId"));
				l.add(p);
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
	
	//根据导游ID号查找项目，返回所有相关的项目信息
	public List<Project> findProjectByleadId(String _leadId)
	{
		List<Project> l=new ArrayList<Project>();
		Connection conn=null;
		PreparedStatement prep=null;
		ResultSet rs=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("select * from project where leadId=?");
			prep.setString(1, _leadId);
			rs=prep.executeQuery();
			while(rs.next())
			{
				Project p=new Project(rs.getString("pId"), 
						rs.getString("pName"), rs.getString("destination"),
						rs.getInt("last"), rs.getString("beginning"), 
						rs.getString("ending"), rs.getString("describing"),
						rs.getInt("min"), rs.getInt("max"), rs.getInt("pflag"), 
						rs.getString("chargeId"), rs.getString("leadId"),
						rs.getString("pcId"));
				l.add(p);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			Dbutil.closeConnection(rs, prep, conn);
		}			
		return l;		
	}
	
	//插入新项目信息
	public boolean insertInfoToProject(Project p)
	{
		boolean flag=false;
		String _pId=p.getpId();
		String _pName=p.getpName();
		String _destination=p.getDestination();
		int _last=p.getLast();
		String _beginning=p.getBeginning();
		String _ending=p.getEnding();
		String _describing=p.getDescribing();
		int _min=p.getMin();
		int _max=p.getMax();
		int _pflag=p.getPflag();
		String _chargeId=p.getChargeId();
		String _leadId=p.getLeadId();
		String _pcId=p.getPcId();
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("insert into project values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prep.setString(1, _pId);
			prep.setString(2, _pName);
			prep.setString(3, _destination);
			prep.setInt(4, _last);						
			prep.setString(5, _beginning);
			prep.setString(6, _ending);
			prep.setString(7, _describing);
			prep.setInt(8, _min);	
			prep.setInt(9, _max);
			prep.setInt(10, _pflag);
			prep.setString(11, _chargeId);
			prep.setString(12, _leadId);			
			prep.setString(13, _pcId);
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
	
	//更新项目的负责人
	public boolean updateProjectchargeIdBypId(String _pId,String _chargeId)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update project set chargeId=? where pId=?");
			prep.setString(1, _chargeId);
			prep.setString(2, _pId);
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
	
	//更新项目的导游
	public boolean updateProjectleadIdBypId(String _pId,String _leadId)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update project set leadId=? where pId=?");
			prep.setString(1, _leadId);
			prep.setString(2, _pId);
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

	//更新项目信息
	public boolean updateProject(Project p)
	{
		boolean flag=false;
		String _pId=p.getpId();
		String _pName=p.getpName();
		String _destination=p.getDestination();
		int _last=p.getLast();
		String _beginning=p.getBeginning();
		String _ending=p.getEnding();
		String _describing=p.getDescribing();
		int _min=p.getMin();
		int _max=p.getMax();
		int _pflag=p.getPflag();
		String _chargeId=p.getChargeId();
		String _leadId=p.getLeadId();
		String _pcId=p.getPcId();	
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement
			("update project set pName=?,destination=?,last=?,beginning=?,ending=?,describing=?"+
			",min=?,max=?,pflag=?,chargeId=?,leadId=?,pcId=? where pId=?");			
			prep.setString(1, _pName);
			prep.setString(2, _destination);
			prep.setInt(3, _last);						
			prep.setString(4, _beginning);
			prep.setString(5, _ending);
			prep.setString(6, _describing);
			prep.setInt(7, _min);	
			prep.setInt(8, _max);
			prep.setInt(9, _pflag);
			prep.setString(10, _chargeId);
			prep.setString(11, _leadId);			
			prep.setString(12, _pcId);	
			prep.setString(13, _pId);
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
	
	//项目的截止时间之后，分两种情况：
	//自由行的话负责人修改项目的状态
	public boolean updateProject(String _pId,int _pflag)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement("update project set pflag=? where pId=?");
			prep.setInt(1, _pflag);
			prep.setString(2, _pId);
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
	
	//跟团的话负责人分配导游和修改项目的状态
	public boolean updateProject(String _pId,String _leadId,int _pflag)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;			
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement
					("update project set leadId=?,pflag=? where pId=?");
			prep.setString(1, _leadId);
			prep.setInt(2, _pflag);
			prep.setString(3, _pId);
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
	
	//再次推出项目时，修改项目的状态，报名时间和截止时间
	public boolean updateProjectBypId(String _pId,String _beginning,String _ending,int _pflag)
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		try
		{
			conn=Dbutil.getConnection();
			prep=conn.prepareStatement
					("update project set beginning=?,ending=?,pflag=? where pId=?");
			prep.setString(1, _beginning);
			prep.setString(2, _ending);
			prep.setInt(3, _pflag);
			prep.setString(4, _pId);
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
	
	//当历史记录表统计某个项目的次数超过三次，删除历史记录表相关项目的信息同时设置状态为3-搁置
	public boolean deleteProject()
	{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		PreparedStatement prep2=null;
		ResultSet rs1=null;
		try
		{
			conn=Dbutil.getConnection();
			prep1=conn.prepareStatement("select * from projectHistory where phNumber>=3");
			rs1=prep1.executeQuery();
			while(rs1.next())
			{
				conn.setAutoCommit(false);
				prep2=conn.prepareStatement("delete from projectHistory where hpId=?");
				prep2.setString(1, rs1.getString("hpId"));
				prep2.executeUpdate();
				prep=conn.prepareStatement("update project set pflag=3 where pId=?");
				prep.setString(1, rs1.getString("hpId"));
				prep.executeUpdate();
				conn.commit();
				conn.setAutoCommit(true);
				flag=true;
			}

		}
		catch (SQLException e) 
		{
			try 
			{
				conn.rollback();
			} 
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		finally
		{
			try 
			{
				if(rs1!=null)
					rs1.close();	
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
}
