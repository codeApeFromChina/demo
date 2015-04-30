package cn.tj.fnzi.its.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tj.baseextweb.fw.dao.GenericDao;
import cn.tj.fnzi.its.model.User;
import cn.tj.fnzi.its.webservice.IUserService;

public class UserService implements IUserService {

	@Autowired
	GenericDao genericDao;
	
	public void insert(User record) {
		
		cn.tj.baseextweb.fw.entity.User entity = new cn.tj.baseextweb.fw.entity.User();
		entity.setUsername(record.getUsername());
		entity.setPassword(record.getPassword());
		
		genericDao.save(entity);
	}

	public List<User> selectByExample(User record) {

		return new ArrayList<User>();
	}

	public String getStr(String str) {
		return "this is a string: " + str;
	}
}
