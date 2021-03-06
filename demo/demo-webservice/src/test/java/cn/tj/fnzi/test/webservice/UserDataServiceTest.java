package cn.tj.fnzi.test.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tj.fnzi.its.webservice.IUserService;
	
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserDataServiceTest {

	@Autowired
	IUserService service;

	@Test
	public void test001() {
		cn.tj.fnzi.its.model.User record = new cn.tj.fnzi.its.model.User();
		record.setUsername("fnzi");
		record.setPassword("123");
		service.insert(record);
	}

}
