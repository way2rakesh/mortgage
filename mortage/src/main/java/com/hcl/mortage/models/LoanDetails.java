package com.hcl.mortage.models;

public class LoanDetails {
	
	private int loan_id;
	private float amount;
	private float intrest_rate;
	private int year;
	private float emi;
	public int getLoan_id() {
	    return loan_id;
	}
	public void setLoan_id(int loan_id) {
	    this.loan_id = loan_id;
	}
	public float getAmount() {
	    return amount;
	}
	public void setAmount(float amount) {
	    this.amount = amount;
	}
	public float getIntrest_rate() {
	    return intrest_rate;
	}
	public void setIntrest_rate(float intrest_rate) {
	    this.intrest_rate = intrest_rate;
	}
	public int getYear() {
	    return year;
	}
	public void setYear(int year) {
	    this.year = year;
	}
	public float getEmi() {
	    return emi;
	}
	public void setEmi(float emi) {
	    this.emi = emi;
	}
	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
