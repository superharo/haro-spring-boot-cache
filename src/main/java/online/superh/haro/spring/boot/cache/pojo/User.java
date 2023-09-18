package online.superh.haro.spring.boot.cache.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-18 14:14
 */
@TableName(value = "user")
@Data
// 需要让实现 Serializable 接口。因为，我们需要将 UserDO 序列化后，才能存储到 Redis 中
public class User implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    @TableLogic
    private Integer deleted;

}
