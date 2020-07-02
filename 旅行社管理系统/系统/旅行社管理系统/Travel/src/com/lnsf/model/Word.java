package com.lnsf.model;

public class Word 
{
	private String wpName;
	private int wNumber;
	public String getWpName() {
		return wpName;
	}
	public void setWpName(String wpName) {
		this.wpName = wpName;
	}
	public int getwNumber() {
		return wNumber;
	}
	public void setwNumber(int wNumber) {
		this.wNumber = wNumber;
	}
	public Word(String wpName, int wNumber) {
		super();
		this.wpName = wpName;
		this.wNumber = wNumber;
	}
	@Override
	public String toString() {
		return "目的地:" + wpName + "  次数:" + wNumber;
	}
}
