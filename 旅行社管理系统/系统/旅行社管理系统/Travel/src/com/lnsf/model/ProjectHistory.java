package com.lnsf.model;

public class ProjectHistory
{
	private String hpId;
	private int phNumber;
	public String getHpId() {
		return hpId;
	}
	public void setHpId(String hpId) {
		this.hpId = hpId;
	}
	public int getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(int phNumber) {
		this.phNumber = phNumber;
	}
	public ProjectHistory(String hpId, int phNumber) {
		super();
		this.hpId = hpId;
		this.phNumber = phNumber;
	}
	@Override
	public String toString() {
		return "项目号:" + hpId + "  次数:" + phNumber;
	}
	
}
