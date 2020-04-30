package com.hcl.mortage.dao;

import com.hcl.mortage.models.UserDetail;

public interface UserDao {
	int saveUser(UserDetail userDetail);
	int checkUser(UserDetail userDetail);

}
