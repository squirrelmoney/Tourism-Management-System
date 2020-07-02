package com.lnsf.model;

public class Category 
{
	private String cId;
	private String cName;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Category(String cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "类别号:" + cId + "  类别名称:" + cName;
	}	
	
}
