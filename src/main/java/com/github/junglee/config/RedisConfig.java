package com.github.junglee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
//		new RedisAutoConfiguration("server", 6379);
		return new LettuceConnectionFactory("127.0.0.1", 6379);
	}
}
