package cn.liuliang.quickdinesysstore.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Package： cn.liuliang.quickdinesysstore.handler
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 14:59
 * @Description：
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入数据时，填充字段
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //可以查看官网 自动填充那一快
        //第一种：this.setFieldValByName("createTime", new Date(), metaObject);
        //第二种： Date.class 要与实体类中字段的类型一样，否者就是不填充  strict：严格的
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        //this.setFieldValByName("updateTime", new Date(), metaObject);
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
    }

    /**
     * 修改数据时，填充字段
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setFieldValByName("updateTime", new Date(), metaObject);
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
    }
}
