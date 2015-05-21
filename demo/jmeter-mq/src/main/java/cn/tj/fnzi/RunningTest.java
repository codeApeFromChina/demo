package cn.tj.fnzi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-camel.xml" })
public class RunningTest {

	@Test
	public void test001() {
		try {
			Thread.sleep(1000 * 60 * 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}