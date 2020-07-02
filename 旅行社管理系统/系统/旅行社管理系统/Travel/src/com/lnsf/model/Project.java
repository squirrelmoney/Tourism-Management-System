package com.lnsf.model;

public class Project
{
	private String pId;
	private String pName;
	private String destination;
	private int last;
	private String beginning;
	private String ending;
	private String describing;
	private int min;
	private int max;
	private int pflag;
	private String chargeId;
	private String leadId;
	private String pcId;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public String getBeginning() {
		return beginning;
	}
	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}
	public String getEnding() {
		return ending;
	}
	public void setEnding(String ending) {
		this.ending = ending;
	}
	public String getDescribing() {
		return describing;
	}
	public void setDescribing(String describing) {
		this.describing = describing;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
	}
	public String toString() {
		return "��Ŀ��:" + pId + "  ��Ŀ��:" + pName + "  Ŀ�ĵ�:"
				+ destination + "  ���γ���ʱ��:" + last + "  ����ʱ��:" + beginning
				+ "  ��ֹʱ��:" + ending + "  ��ϸ��Ϣ:" + describing
				+ "  ������������:" + min + "  �����������:" + max + "  ״̬:" + pflag
				+ "  ������ID��:" + chargeId + "  ����ID��:" + leadId + "  ��Ŀ����:"
				+ pcId + "]";
	}
	public Project(String pId, String pName, String destination, int last,
			String beginning, String ending, String describing, int min,
			int max, int pflag, String chargeId, String leadId, String pcId) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.destination = destination;
		this.last = last;
		this.beginning = beginning;
		this.ending = ending;
		this.describing = describing;
		this.min = min;
		this.max = max;
		this.pflag = pflag;
		this.chargeId = chargeId;
		this.leadId = leadId;
		this.pcId = pcId;
	}
	
}
