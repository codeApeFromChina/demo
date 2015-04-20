package cn.tj.fnzi.camel;

import org.apache.camel.builder.RouteBuilder;

public class FileProcessWithCamelSpring extends RouteBuilder {
	public void configure() throws Exception {
//		FileConvertProcessor processor = new FileConvertProcessor();
//		from("file:d:/a?delay=30000").process(processor).to(
//				"file:d:/b");
	}
}