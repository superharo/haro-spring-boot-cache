package online.superh.haro.spring.boot.cache.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-18 14:12
 */
@Configuration
@MapperScan(basePackages = "online.superh.haro.spring.boot.cache.mapper")
public class MyBatisPlusConfig {



}
