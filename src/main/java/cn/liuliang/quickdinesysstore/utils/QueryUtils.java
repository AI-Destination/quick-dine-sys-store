package cn.liuliang.quickdinesysstore.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package： cn.liuliang.quickdinesysstore.utils
 * @Author： liuliang
 * @CreateTime： 2020/10/31 - 15:30
 * @Description： 系统相关属性工具类
 */
@Data
@Component
@ConfigurationProperties(prefix = "quick")
public class QueryUtils {
    /**
     * 当前系统的店家名称
     */
    private String storeName;
}
