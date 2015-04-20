package cn.tj.its.fnzi.mq;

import java.io.IOException;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-jms.xml" })
public class JmsTest {

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

	@Test
	public void send() throws InterruptedException {
		// ActiveMQTopic dest = new ActiveMQTopic(this.destination);
		ActiveMQQueue dest = new ActiveMQQueue(this.destination);
		jmsSender.sendSingle(message, dest);
	}

	private int no = 10 * 10;

	@Test
	public void send001() throws InterruptedException {
		ActiveMQTopic dest = new ActiveMQTopic(this.destination);
		for (int i = 0; i < no; i++) {
			jmsSender.sendSingle(message, dest);
		}
		Thread.sleep(1000000000);
	}

	/**
	 * 队列生产，消费测试
	 */
	@Test
	public void send002() throws InterruptedException {
		ActiveMQQueue dest = new ActiveMQQueue(this.destination);
		for (int i = 0; i < no; i++) {
			jmsSender.sendSingle(message, dest);
		}
		Thread.sleep(1000000000);
	}
}