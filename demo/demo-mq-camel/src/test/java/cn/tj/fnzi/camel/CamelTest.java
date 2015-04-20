package cn.tj.fnzi.camel;

import java.io.IOException;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tj.its.fnzi.mq.JmsSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-camel.xml" })
public class CamelTest {

	@Autowired
	private JmsSender jmsSender;

	private String destination;
	private String message = "qwert";

	@Before
	public void init() throws IOException {

		this.destination = "DEV";
		// 开启异步发送
		this.jmsSender.setSendAsync(true);
	}

	private int no = 10 * 10;

	@Test
	public void send002() throws InterruptedException {
		ActiveMQQueue dest = new ActiveMQQueue(this.destination);
		for (int i = 0; i < no; i++) {
			jmsSender.sendSingle(message, dest);
		}
		Thread.sleep(1000000000);
	}
}
