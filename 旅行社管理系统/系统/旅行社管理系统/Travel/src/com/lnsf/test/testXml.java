package com.lnsf.test;

import java.util.HashMap;

import com.lnsf.dbutils.XmlParser;
import com.lnsf.dbutils.XmlValidator;



public class testXml 
{
	public static void main(String[] args)
	{
		String xmlPath="database.conf.xml";
		String xsdPath="database.conf.xsd";
		if(XmlValidator.validate(xmlPath, xsdPath))
		{
			HashMap<String,String> hm=XmlParser.parser(xmlPath);
			System.out.println(hm.get("driver"));
			System.out.println(hm.get("password"));
		}
	}
}
