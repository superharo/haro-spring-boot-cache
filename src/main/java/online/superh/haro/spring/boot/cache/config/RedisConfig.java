package online.superh.haro.spring.boot.cache.config;

import org.springframework.context.annotation.Configuration;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-18 14:54
 */
@Configuration
public class RedisConfig {

    // @Bean
    // public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
    //     // 创建 RedisTemplate 对象
    //     RedisTemplate<String, Object> template = new RedisTemplate<>();
    //     // 设置 RedisConnection 工厂。它就是实现多种 Java Redis 客户端接入的秘密工厂。
    //     template.setConnectionFactory(factory);
    //     // 使用 String 序列化方式，序列化 KEY 。
    //     template.setKeySerializer(RedisSerializer.string());
    //     template.setValueSerializer(RedisSerializer.string());
    //     return template;
    // }

}