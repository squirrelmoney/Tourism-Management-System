package com.lnsf.model;

public class Book
{
	private String bTel;
	private String bpId;
	private String bName;
	private String bNum;
	private int broom;
	private int bflag;
	public String getbTel() {
		return bTel;
	}
	public void setbTel(String bTel) {
		this.bTel = bTel;
	}
	public String getBpId() {
		return bpId;
	}
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public int getBroom() {
		return broom;
	}
	public void setBroom(int broom) {
		this.broom = broom;
	}
	public int getBflag() {
		return bflag;
	}
	public void setBflag(int bflag) {
		this.bflag = bflag;
	}
	public Book(String bTel, String bpId, String bName, String bNum, int broom,
			int bflag) {
		super();
		this.bTel = bTel;
		this.bpId = bpId;
		this.bName = bName;
		this.bNum = bNum;
		this.broom = broom;
		this.bflag = bflag;
	}
	@Override
	public String toString() {
		return "�ֻ���:" + bTel + "  ��Ŀ��:" + bpId + "  ����:" + bName
				+ "  ���֤����:" + bNum + "  ������:" + broom + "  ״̬:" + bflag;
	}	
}
