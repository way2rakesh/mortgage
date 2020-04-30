package com.hcl.mortage.services;

import com.hcl.mortage.models.UserDetail;

public interface UserService {
	
	int saveUser(UserDetail userdetail);
	int checkUser(UserDetail userDetail);

}
