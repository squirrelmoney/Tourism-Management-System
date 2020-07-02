package com.lnsf.model;

public class Employee
{
	private String eId;
	private String eName;
	private String eTel;
	private String eTitle;
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteTel() {
		return eTel;
	}
	public void seteTel(String eTel) {
		this.eTel = eTel;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public Employee(String eId, String eName, String eTel, String eTitle) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eTel = eTel;
		this.eTitle = eTitle;
	}
	@Override
	public String toString() {
		return "员工号:" + eId + "  姓名:" + eName + "  手机号:" + eTel
				+ "  职称:" + eTitle;
	}
}
