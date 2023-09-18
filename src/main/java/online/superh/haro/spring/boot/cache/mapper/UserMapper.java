package online.superh.haro.spring.boot.cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.superh.haro.spring.boot.cache.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-18 14:18
 */
@Repository
@CacheConfig(cacheNames = "user")
// 使用缓存user
public interface UserMapper extends BaseMapper<User> {

    @Cacheable(key = "#id")
    //添加了 @Cacheable(key = "#id") 注解，优先读缓存。
    User selectById(Integer id);

    @CachePut(key = "#user.id")
    // 添加了 @CachePut(key = "#user.id") 注解，主动写缓存
    default User insert0(User user) {
        // 插入记录
        this.insert(user);
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    // 删除缓存
    int deleteById(Integer id);

}
