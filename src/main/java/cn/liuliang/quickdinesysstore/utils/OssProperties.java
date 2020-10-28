package cn.liuliang.quickdinesysstore.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package： cn.liuliang.quickdinesysstore.utils
 * @Author： liuliang
 * @CreateTime： 2020/10/26 - 9:09
 * @Description：
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;
}
