package cn.tj.fnzi;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

public class TempCamelHandler {

	@Autowired
	ProducerTemplate camelTemplate;

	public void handler(Exchange exchange) {

		SAXReader saxReader = new SAXReader();
		Document document = null;

	}
}
