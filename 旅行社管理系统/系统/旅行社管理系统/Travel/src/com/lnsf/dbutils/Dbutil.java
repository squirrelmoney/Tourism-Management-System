package com.lnsf.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Dbutil
{
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String xmlPath="database.conf.xml";
	private static String xsdPath="database.conf.xsd";	
	
	public static Connection getConnection()
	{
		Connection conn=null;
		if(XmlValidator.validate(xmlPath, xsdPath))
		{
			HashMap<String,String> hm=XmlParser.parser(xmlPath);
			driver=hm.get("driver");
			url=hm.get("url");
			user=hm.get("user");
			password=hm.get("password");
		}
		try 
		{
			Class.forName(driver);
			conn=DriverManager.getConnection
			(url,user, password);
			
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("数据库连接获取失败，连接用的jar包找不到...");
		}
		catch (SQLException e) 
		{				
			System.out.println("数据库连接获取失败，请检查数据库连接参数的设置...");
		}
		return conn;		
	}
	
	public static void closeConnection(ResultSet rs,Statement stat,Connection conn)
	{
		try 
		{
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		}
		catch (SQLException e)
		{
	
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(ResultSet rs,PreparedStatement prep,Connection conn)
	{
		try 
		{
			if(rs!=null)
				rs.close();
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
	
	public static void closeConnection(Statement stat,Connection conn)
	{
		try 
		{
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		}
		catch (SQLException e)
		{
	
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(PreparedStatement prep,Connection conn)
	{
		try 
		{
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
}
