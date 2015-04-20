package cn.tj.fnzi.camel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-camel.xml" })
public class CamelSpring {

	@Test
	public void test001() throws InterruptedException {
		while (true) {
			Thread.sleep(2000);
		}
	}

}
