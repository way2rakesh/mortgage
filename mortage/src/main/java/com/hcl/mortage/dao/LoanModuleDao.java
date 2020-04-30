package com.hcl.mortage.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hcl.mortage.models.LoanDetails;
import com.hcl.mortage.models.UserDetail;

public interface LoanModuleDao {
	List<UserDetail> viewUserDetails(HttpSession session);
	List<LoanDetails> fetchLoanDetail(int totalAreaCost);
	int viewPropertySqftDetails(int pincode);
	List<LoanDetails> successfullyLoanDetail(int loanid);
}
