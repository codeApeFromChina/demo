package cn.tj.fnzi.camel;

import java.io.UnsupportedEncodingException;

import org.apache.camel.Exchange;

public class CamelHandler {

	private int i = 0;

	public void handler(Exchange exchange) throws UnsupportedEncodingException {
		System.out.println(++i);
		System.out.println(exchange.getIn().getBody().toString());

//		if (exchange.in.body instanceof byte[]) {
//			new String(exchange.in.body, "GBK");
//		}

	}
}
