package online.superh.haro.spring.boot.cache;

import online.superh.haro.spring.boot.cache.mapper.UserMapper;
import online.superh.haro.spring.boot.cache.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.Date;
import java.util.UUID;

@SpringBootTest(classes = HaroSpringBootCacheApplication.class)
class HaroSpringBootCacheApplicationTests {

    private static final String CACHE_NAME_USER = "user";

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserMapper userMapper;

    /*
        ehcache
     */
    @Test
    public void testDeleteById() {
        System.out.println(cacheManager);
        // <1> 插入记录，为了让缓存里有记录
        User user = new User();
        user.setUsername(UUID.randomUUID().toString()); // 随机账号，因为唯一索引
        user.setPassword("hahaha");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        // <2> 判断缓存中，是不是存在
        System.out.println(cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), User.class));
        // <3.1> 删除记录，为了让缓存被删除
        userMapper.deleteById(user.getId());
        // <3.2> 判断缓存中，是不是存在
        System.out.println(cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), User.class));
    }

    /*
        redis:
             使用 Redis 作为缓存方案时，默认情况下是永不过期的。
               - 可以通 spring.cache.redis.time-to-live 配置项，设置过期时间。但是，它是全局的统一的。这样在实际使用时，是无法满足我们希望不同的缓存，使用不同的过期时间
               - 自定义一个 CacheManager Bean 对象。当然，更加系统的解决方式，是按照这个文章的思路，实现一个新的支持使用配置文件自定义每个缓存配置的 RedisCacheConfiguration 自动化配置类
               - 还有一个解决方案，就是使用 Redisson 提供的缓存管理器
     */
    @Test
    public void testDeleteById2() {
        System.out.println(cacheManager);
        // <1> 插入记录，为了让缓存里有记录
        User user = new User();
        user.setUsername(UUID.randomUUID().toString()); // 随机账号，因为唯一索引
        user.setPassword("hahaha");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        // <2> 判断缓存中，是不是存在
        System.out.println(cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), User.class));
        // // <3.1> 删除记录，为了让缓存被删除
        // userMapper.deleteById(user.getId());
        // // <3.2> 判断缓存中，是不是存在
        // System.out.println(cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), User.class));
    }

}
