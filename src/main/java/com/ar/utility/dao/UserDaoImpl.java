package com.ar.utility.dao;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import com.ar.utility.model.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User findUserByUserName(String userName) {
		//should be a dynamo DB query. for now keeping the hardcoded values.
		return new User(Arrays.asList("ROLE_ADMIN"), "pass", userName, true);
	}

}
