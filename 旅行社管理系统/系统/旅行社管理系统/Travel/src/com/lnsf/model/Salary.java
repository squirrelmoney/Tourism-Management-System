package com.lnsf.model;

public class Salary 
{
	private String seId;
	private double baseSalary;
	private double insurance;
	private double reward;
	public String getSeId() {
		return seId;
	}
	public void setSeId(String seId) {
		this.seId = seId;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	public Salary(String seId, double baseSalary, double insurance,
			double reward) {
		super();
		this.seId = seId;
		this.baseSalary = baseSalary;
		this.insurance = insurance;
		this.reward = reward;
	}
	@Override
	public String toString() {
		return "员工号:" + seId + "  基本工资:" + baseSalary
				+ "  五险一金:" + insurance + "  提成:" + reward;
	}		
}
