package cn.tj.its.fnzi.mq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class JmsReceiver implements MessageHandler {
	private Collection<String> collection;
	private int i = 0;

	public void receive(TextMessage message) {
		try {
			if (collection == null) {
				this.collection = new ArrayList<String>();
			}
			collection.add(message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void handleMessage(String message) {
		i = i + 1;
		System.out.println(i + "___" + message);
	}

	public void handleMessage(Map<String, Object> message) {
		Set<String> keySet = message.keySet();
		Iterator<String> keys = keySet.iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(message.get(key));
		}

	}

	public void handleMessage(byte[] message) {
		System.out.println(message);
	}

	public void handleMessage(Serializable message) {
		System.out.println(message);
	}

	public Collection<String> getCollection() {
		return collection;
	}

	public void setCollection(Collection<String> collection) {
		this.collection = collection;
	}

}