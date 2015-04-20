package cn.tj.fnzi.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {

	Jedis jedis = new Jedis("127.0.0.1");

	@Test
	public void test001() {

		String keys = "name";

		// 删数据
		jedis.del(keys);
		// 存数据
		jedis.set(keys, "snowolf");
		// 取数据
		String value = jedis.get(keys);
		System.out.println(value);

		String pong = jedis.ping();
		System.out.println(pong);

	}

	@Test
	public void test002() {

		System.out.println(jedis.echo("------test------"));
		
		System.out.println(jedis.info());
		
	}

	@Test
	public void test003() {
		System.out.println(jedis.randomKey());
		System.out.println(jedis.set("name", "fnzi_123"));
		System.out.println(jedis.get("name"));
	}
}
