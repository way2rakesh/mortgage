package com.hcl.mortage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.hcl.mortage.models.LoanDetails;
import com.hcl.mortage.models.PropertySqft;
import com.hcl.mortage.models.UserDetail;

public class LoanModuleDaoImpl implements LoanModuleDao {
	@Autowired
	private	JdbcTemplate jdbctemplate;
	
	public List<UserDetail> viewUserDetails(HttpSession session) {
		// TODO Auto-generated method stub
		String sql="select * from userdetails where user_id='"+ session.getAttribute("userId")+"' ";
		return jdbctemplate.query(sql, new RowMapper<UserDetail>() {

			public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDetail userDetail= new UserDetail();
				userDetail.setName(rs.getString("name"));
				userDetail.setEmail(rs.getString("email"));
				userDetail.setMobileNumber(Long.parseLong(rs.getString("phone_number")));
				return userDetail;
				
			}
		});
	}
	public int viewPropertySqftDetails(final int pincode)
	{
		
		String sql="select sqft from propertysqft where  pincode=?";
		return jdbctemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, pincode);
			 ResultSet rs = ps.executeQuery();
			 int sqft =0;
			 while(rs.next())
			 {
				  sqft = rs.getInt("sqft");
			 }
				return sqft;
			}
		});
	}
	public List<LoanDetails> fetchLoanDetail(int totalAreaCost)
	{
		String sql="select * from loandetails where amount<='"+totalAreaCost+"'";
		System.out.println("in");
		return jdbctemplate.query(sql,new RowMapper<LoanDetails>() {

			public LoanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				LoanDetails loanDetails= new LoanDetails();
				loanDetails.setLoan_id(rs.getInt("loan_id"));

				loanDetails.setAmount(rs.getFloat("amount"));
				loanDetails.setIntrest_rate(rs.getFloat("intrest_rate"));
				loanDetails.setYear(rs.getInt("year"));
				loanDetails.setEmi(rs.getFloat("emi"));
	               
				System.out.println("out in dao");
				return loanDetails;
			}
		
	});
	}
	public List<LoanDetails> successfullyLoanDetail(int loanid)
	{
		String sql="select * from loandetails where loan_id='"+loanid+"'";
		System.out.println("in");
		return jdbctemplate.query(sql,new RowMapper<LoanDetails>() {

			public LoanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				LoanDetails loanDetails= new LoanDetails();
				loanDetails.setLoan_id(rs.getInt("loan_id"));

				loanDetails.setAmount(rs.getFloat("amount"));
				loanDetails.setIntrest_rate(rs.getFloat("intrest_rate"));
				loanDetails.setYear(rs.getInt("year"));
				loanDetails.setEmi(rs.getFloat("emi"));
	               
				System.out.println("success out");
				return loanDetails;
			}
		
	});

}
}
