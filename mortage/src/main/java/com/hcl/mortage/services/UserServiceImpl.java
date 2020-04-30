package com.hcl.mortage.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.mortage.dao.UserDao;
import com.hcl.mortage.exceptions.LoginException;
import com.hcl.mortage.exceptions.RegisterExceptions;
import com.hcl.mortage.models.UserDetail;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public int saveUser(UserDetail userdetail) {

		int saveUser = userDao.saveUser(userdetail);
		if (saveUser > 0)
			return saveUser;
		else {
			throw new RegisterExceptions("pls try with new  user name ");
		}
	}

	public int checkUser(UserDetail userDetail) {

		// TODO Auto-generated method stub
		int checkUser = userDao.checkUser(userDetail);
		if (checkUser > 0)
			return checkUser;
		else {
			throw new LoginException("invalid login pls  user doesnot exist");
		}
	}

}
