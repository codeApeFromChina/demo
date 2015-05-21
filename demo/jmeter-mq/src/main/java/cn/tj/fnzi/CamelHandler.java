package cn.tj.fnzi;

import org.apache.camel.Exchange;

public class CamelHandler {

	private int i = 0;
	
	public void handler(Exchange exchange) {
		System.out.println(++i);
		System.out.println(exchange.getIn().getBody().toString());
	}
}
