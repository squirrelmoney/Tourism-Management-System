package com.lnsf.model;

public class User
{
	private String uTel;
	private String uPassWord;
	private int uSuper;
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public String getuPassWord() {
		return uPassWord;
	}
	public void setuPassWord(String uPassWord) {
		this.uPassWord = uPassWord;
	}
	public int getuSuper() {
		return uSuper;
	}
	public void setuSuper(int uSuper) {
		this.uSuper = uSuper;
	}
	public User(String uTel, String uPassWord, int uSuper) {
		super();
		this.uTel = uTel;
		this.uPassWord = uPassWord;
		this.uSuper = uSuper;
	}
	@Override
	public String toString() {
		return "手机号:" + uTel + "  密码:" + uPassWord + "  权限:"+ uSuper;
	}
}
