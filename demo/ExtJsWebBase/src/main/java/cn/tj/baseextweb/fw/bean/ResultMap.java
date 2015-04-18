package cn.tj.baseextweb.fw.bean;

import java.util.LinkedHashMap;

import org.springframework.util.Assert;

public class ResultMap extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = -435056503382451200L;

	public ResultMap() {
	}

	public ResultMap addObject(String key, Object object) {
		Assert.notNull(key, "key must not be null");
		put(key, object);
		return this;
	}

}
