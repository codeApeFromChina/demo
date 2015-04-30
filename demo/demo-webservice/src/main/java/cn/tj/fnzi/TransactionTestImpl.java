package cn.tj.fnzi;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tj.fnzi.its.webservice.IUserService;

public class TransactionTestImpl implements TransactionTest {

	@Autowired
	IUserService service;

	public void throwException() {

		cn.tj.fnzi.its.model.User record = new cn.tj.fnzi.its.model.User();
		record.setUsername("fnzi");
		record.setPassword("123");
		service.insert(record);

		System.out.println("exec --1");

		System.out.println("exec --2");
		if (record.getUsername().equals("fnzi")) {
			throw new RuntimeException();
		}
		System.out.println("exec --3");
	}

}
