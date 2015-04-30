package cn.tj.fnzi.its.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.tj.fnzi.its.model.User;

@WebService
public interface IUserService {

	@WebMethod
	void insert(User record);

	@WebMethod
	List<User> selectByExample(User record);

	
	@WebMethod
	String getStr(String str);
}
