package com.hcl.mortage.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.mortage.dao.LoanModuleDao;
import com.hcl.mortage.dao.LoanModuleDaoImpl;
import com.hcl.mortage.exceptions.UserDefiendException;
import com.hcl.mortage.models.PropertySqft;
import com.hcl.mortage.models.LoanDetails;
import com.hcl.mortage.models.PropertyDetails;
import com.hcl.mortage.models.UserDetail;

public class LoanModuleServiceImpl implements LoanModuleService {
	@Autowired
	LoanModuleDao loanModuleDao;

	public List<UserDetail> viewUserDetails(HttpSession session) {
		return loanModuleDao.viewUserDetails(session);
	}
	/*
	 * fetching details of user for the loan from the controller through welcome page
	 * 
	 */
	public List<LoanDetails> fetchLoanDetail(PropertyDetails propertydetails) {

		int pincode = propertydetails.getPincode();
		int salary = propertydetails.getSalary();
		int area = propertydetails.getArea();
		int secondSourceIncome = propertydetails.getSecondSourceIncome();
		

		int basicIncome = Math.round(salary * 0.4f + secondSourceIncome * 0.4f);
		/*
		 * checking basic income and it should meet our criteria i.e 40% of 
		 * his salary and second income
		 * 
		 */
		System.out.println(" basic income" + basicIncome);

		int persqftcost = loanModuleDao.viewPropertySqftDetails(pincode);
		/*
		 * fetching the details of persqft cost  by making use of pincode
		 * 
		 */
		if (persqftcost != 0) {
			System.out.println(persqftcost);
			/*
			 * checking persqftcost is meeting our criteria i.e 70% of 
			 * his total sqft cost should be above 10L
			 * 
			 */
			int totalAreaCost = Math.round(persqftcost * area * 0.7f);

			System.out.println("total area " + totalAreaCost);

			if (basicIncome > 15000) {

				if (totalAreaCost > 1000000) {

					return loanModuleDao.fetchLoanDetail(totalAreaCost);
				} else {
					throw new UserDefiendException(
							"the property value should be greater than 10L but the property "
							+ "value of yours is="+ totalAreaCost);
				}
			} else {

				throw new UserDefiendException(
						"your not matching for our criteria of your basic income=" + basicIncome);
			}
		} else {
			throw new UserDefiendException("we are avaliable in these area , 560001,560002, 560100, 560073,560003, 560056, ");

					
					
		}

	}

	public List<LoanDetails> successfullyLoanDetail(int loanid) {
		// TODO Auto-generated method stub

		return loanModuleDao.successfullyLoanDetail(loanid);
	}

}
