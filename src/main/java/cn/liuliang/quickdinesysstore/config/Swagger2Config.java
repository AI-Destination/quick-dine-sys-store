package cn.liuliang.quickdinesysstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package： cn.liuliang.quickdinesysstore.config
 * @Author： liuliang
 * @CreateTime： 2020/10/24 - 10:50
 * @Description：
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("快捷餐饮店家后台接口文档")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                //.paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();

    }



    private ApiInfo adminApiInfo(){

        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("liuliang", "https://blog.csdn.net/qq_40399646", "j3_liuliang@163.com"))
                .build();
    }
}
