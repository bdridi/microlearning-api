package com.workcale.microlearning.infrastructure.db.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate


@Configuration
class RedisConfig(val redisProperties: RedisProperties) {


    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        var jedisConnectionFactory = JedisConnectionFactory()
        jedisConnectionFactory.hostName = redisProperties.host
        jedisConnectionFactory.port = redisProperties.port.toInt()
        return jedisConnectionFactory
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any>? {
        val template = RedisTemplate<String, Any>()
        template.setConnectionFactory(this.jedisConnectionFactory())
        return template
    }
}