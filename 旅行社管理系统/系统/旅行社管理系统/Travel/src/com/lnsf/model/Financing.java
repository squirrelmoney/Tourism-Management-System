package com.lnsf.model;

public class Financing 
{
	private String fpId;
	private double basepay;
	private double roompay;	
	private double poundage;
	private double profit;
	public String getFpId() {
		return fpId;
	}
	public void setFpId(String fpId) {
		this.fpId = fpId;
	}
	public double getBasepay() {
		return basepay;
	}
	public void setBasepay(double basepay) {
		this.basepay = basepay;
	}
	public double getRoompay() {
		return roompay;
	}
	public void setRoompay(double roompay) {
		this.roompay = roompay;
	}
	public double getPoundage() {
		return poundage;
	}
	public void setPoundage(double poundage) {
		this.poundage = poundage;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public Financing(String fpId, double basepay, double roompay,
			double poundage, double profit) {
		super();
		this.fpId = fpId;
		this.basepay = basepay;
		this.roompay = roompay;
		this.poundage = poundage;
		this.profit = profit;
	}
	@Override
	public String toString() {
		return "项目号:" + fpId + "  个人成本:" + basepay+ "  住房费用:" + 
				roompay + "  手续费:" + poundage+ "  利润:" + profit;
	}
}
