package cn.tj.fnzi.its.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.webservice.IUserService;

public class UserService implements IUserService {

	public int insert(User record) {
		return 0;
	}

	public List<User> selectByExample(User record) {
		return new ArrayList<User>();
	}

	public String getStr(String str) {
		return "this is a string: " + str;
	}
}
