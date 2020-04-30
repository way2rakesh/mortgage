package com.hcl.mortage.models;

public class PropertySqft {
private int  loan_id;
private int areaSqft;

private int pincode;

public PropertySqft() {
	super();
	// TODO Auto-generated constructor stub
}
public int getLoan_id() {
	return loan_id;
}
public void setLoan_id(int loan_id) {
	this.loan_id = loan_id;
}
public int getAreaSqft() {
	return areaSqft;
}
public void setAreaSqft(int areaSqft) {
	this.areaSqft = areaSqft;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}


}
