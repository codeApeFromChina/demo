package cn.tj.fnzi.springdata.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RedisTest {

    @Autowired
    protected RedisTemplate<Serializable, Serializable> redisTemplate;

    @Test
    public void test001() {
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("id","1");
        map.put("username", "fnzi");
        map.put("password", "123");
        
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("id","2");
        map1.put("username", "fnzi2");
        map1.put("password", "123");
        
        final List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(map);
        list.add(map1);
        
        
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize("123"),
                               redisTemplate.getStringSerializer().serialize(""));
                return null;
            }
        });
    }
}
