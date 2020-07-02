package com.lnsf.dbutils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser
{
	public static HashMap<String,String>parser(String xmlPath)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		String base=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		xmlPath=base+xmlPath;			
		try 
		{
			//1.ʵ����һ��SAXParserFactory����
			SAXParserFactory spf=SAXParserFactory.newInstance();
			//2.ͨ��factory���һ��SAXParser���󣬼�SAX������			
			SAXParser sp=spf.newSAXParser();
			//3.saxParser�������parse��������XML�ļ�		
			File f=new File(xmlPath);
			XmlHandler xh=new XmlHandler();
			sp.parse(f, xh);
			hm=xh.getHashMap();
		} 
		catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		} 
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return hm;
	}
}
