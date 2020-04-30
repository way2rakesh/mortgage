package com.hcl.mortage.controllers;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.mortage.models.PropertySqft;
import com.hcl.mortage.exceptions.UserDefiendException;
import com.hcl.mortage.models.LoanDetails;
import com.hcl.mortage.models.PropertyDetails;
import com.hcl.mortage.models.UserDetail;
import com.hcl.mortage.services.LoanModuleService;

@Controller
public class LoanModuleController {
	@Autowired
	LoanModuleService loanModuleService;
	@RequestMapping("/viewuserdetails")
	String   viewUserDetails(Model m,HttpSession session)
	{
		List<UserDetail> viewUserDetails = loanModuleService.viewUserDetails(session);
		m.addAttribute("userdetails", viewUserDetails);
		return "welcome";
		
	}
	
	
	
	@RequestMapping(value="/detailsofloan",method = RequestMethod.POST)
String detailsForLoan(HttpServletRequest request,Model model)
{
		try {
		PropertyDetails propertyDetails=new PropertyDetails();
		propertyDetails.setName(request.getParameter("name"));
		propertyDetails.setGender(request.getParameter("gender"));
		propertyDetails.setPanCard(request.getParameter("pancard"));
		propertyDetails.setAddress(request.getParameter("address"));
		propertyDetails.setArea( Integer.parseInt(request.getParameter("area")));
		propertyDetails.setPincode(Integer.parseInt(request.getParameter("pincode")));
		propertyDetails.setSalary(Integer.parseInt(request.getParameter("salary")));
		propertyDetails.setSecondSourceIncome(Integer.parseInt(request.getParameter("secondsourceincome")));
		propertyDetails.setAddress(request.getParameter("loanname"));
		
 List<LoanDetails> fetchLoanDetail = loanModuleService.fetchLoanDetail(propertyDetails);


 model.addAttribute("fetchLoanDetail", fetchLoanDetail);
return "applyloan";

}
	catch(UserDefiendException ue)
	{
		
		model.addAttribute("error",ue);
		return "error";
	
	}
		catch(Exception e)
		{
			model.addAttribute("error",e);
			return "error";
		}
	
}
	@RequestMapping("/loansuccess")
	String loanSuccess(@RequestParam("id") String id,Model m) {
		System.out.println(id);
	int loanid = Integer.parseInt(id);
		List<LoanDetails> successfullyLoanDetail = loanModuleService.successfullyLoanDetail(loanid);
		m.addAttribute("loanid", successfullyLoanDetail);
		return "successfull" ;
		
	}
}
