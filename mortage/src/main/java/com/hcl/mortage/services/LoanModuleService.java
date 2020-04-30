package com.hcl.mortage.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hcl.mortage.models.PropertySqft;
import com.hcl.mortage.models.LoanDetails;
import com.hcl.mortage.models.PropertyDetails;
import com.hcl.mortage.models.UserDetail;

public interface LoanModuleService {
	List<UserDetail> viewUserDetails(HttpSession session);
	List<LoanDetails> fetchLoanDetail(PropertyDetails propertydetails);
	List<LoanDetails>  successfullyLoanDetail(int loanid);
}
