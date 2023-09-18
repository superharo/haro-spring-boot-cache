package online.superh.haro.spring.boot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching //开启缓存
@SpringBootApplication
public class HaroSpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaroSpringBootCacheApplication.class, args);
    }

}
