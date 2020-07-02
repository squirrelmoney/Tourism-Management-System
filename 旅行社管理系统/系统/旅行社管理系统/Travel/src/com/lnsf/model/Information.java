package com.lnsf.model;

public class Information
{
	private String iTel;
	private String ipId;
	private String iName;
	private String iNum;	
	private int iroom;
	private int itimes;
	private int iflag;
	public String getiTel() {
		return iTel;
	}

	public void setiTel(String iTel) {
		this.iTel = iTel;
	}

	public String getIpId() {
		return ipId;
	}

	public void setIpId(String ipId) {
		this.ipId = ipId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiNum() {
		return iNum;
	}

	public void setiNum(String iNum) {
		this.iNum = iNum;
	}

	public int getIroom() {
		return iroom;
	}

	public void setIroom(int iroom) {
		this.iroom = iroom;
	}

	public int getItimes() {
		return itimes;
	}

	public void setItimes(int itimes) {
		this.itimes = itimes;
	}

	public int getIflag() {
		return iflag;
	}

	public void setIflag(int iflag) {
		this.iflag = iflag;
	}
	public Information(String iTel, String ipId, String iName, String iNum,
			int iroom, int itimes, int iflag) {
		super();
		this.iTel = iTel;
		this.ipId = ipId;
		this.iName = iName;
		this.iNum = iNum;
		this.iroom = iroom;
		this.itimes = itimes;
		this.iflag = iflag;
	}

	@Override
	public String toString() {
		return "手机号:" + iTel + "  项目号:" + ipId + "  姓名:"+ iName + 
				"  身份证号码:" + iNum + "  房间数:" + iroom + "  次数:"+ itimes 
				+ "  状态:" + iflag;
	}
}
