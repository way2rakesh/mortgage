package com.hcl.mortage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.hcl.mortage.models.UserDetail;

public class UserDaoImpl implements UserDao{
@Autowired
private	JdbcTemplate jdbctemplate;

	public int saveUser(UserDetail userDetail) {
		try {
		String sql="INSERT INTO userdetails (name,user_name,password,email,phone_number) VALUES ( '"+userDetail.getName()+"', '"+userDetail.getName()+"', '"+userDetail.getUserName()+"', '"+userDetail.getEmail()+"', '"+userDetail.getMobileNumber()+"');";
		return jdbctemplate.update(sql);
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	public int checkUser(final UserDetail userDetail) {
	
		try {
				
		String sql="select * from userdetails where user_name=?and password=? ";
		return jdbctemplate.execute(sql, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, userDetail.getUserName());
				ps.setString(2, userDetail.getPassword());
				ResultSet resultSet = ps.executeQuery();
				int userid=0;
				while(resultSet.next())
				{
					 userid	 = resultSet.getInt("user_id");
				}
			
				return userid;
			}
		});
		}
		catch(Exception e)
		{
			return 0;
		}
	}

}
