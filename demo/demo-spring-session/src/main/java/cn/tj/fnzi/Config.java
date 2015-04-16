package cn.tj.fnzi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Rob Winch
 */
//@Import(EmbeddedRedisConfiguration.class)
@Configuration
@EnableRedisHttpSession
public class Config {

    @Bean
    public JedisConnectionFactory connectionFactory() {
    	JedisConnectionFactory connection = new JedisConnectionFactory(); 
        connection.setHostName("localhost");
        return connection;
    }
}