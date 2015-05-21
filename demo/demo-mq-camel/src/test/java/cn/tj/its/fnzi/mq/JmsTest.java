package cn.tj.its.fnzi.mq;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-jms.xml" })
public class JmsTest {

	@Autowired
	private JmsSender jmsSender;

	@Autowired
	private JmsTemplate jmsTemplate;
	
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
	
	@Test
	public void test001() {
		this.destination = "ASS.RCV";
		ActiveMQQueue dest = new ActiveMQQueue(this.destination);
		jmsTemplate.send(dest, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				BytesMessage message = session.createBytesMessage();
				try {
					message.writeBytes("<R><HD><MT>RELI</MT><MS>0412345你好</MS><SSN>HCLF043</SSN><SDR>GWC001,RcvQ01</SDR></HD><BD><ENB>13101007</ENB><PWD>11111111</PWD><FLG>Y</FLG></BD></R>".getBytes("GBK"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return message;
			}
		});
	}
}