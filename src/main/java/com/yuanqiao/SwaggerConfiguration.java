package com.yuanqiao;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;


/**
 * swagger的视频学习地址：
 * https://www.bilibili.com/video/av50333325
 * swagger视频对应的地址：
 * https://blog.csdn.net/qq122516902/article/details/89417964
 */
@Component
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * http://localhost:8080/swagger-ui.html
     */
    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是处于该环境，通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .ignoredParameterTypes(HttpServletRequest.class,Integer.class)  //配置要忽略的参数类型
                .enable(b) // 配置是否启用Swagger，如果是false，在浏览器将无法访问
                // 通过.select()方法，去配置扫描接口
                .select()
                // RequestHandlerSelectors配置如何扫描接口
                /**
                 *
                 * RequestHandlerSelectors.any() // 扫描所有，项目中的所有接口都会被扫描到
                 RequestHandlerSelectors.none() // 不扫描接口
                 RequestHandlerSelectors.withMethodAnnotation(final Class<? extends Annotation> annotation)// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                 RequestHandlerSelectors.withClassAnnotation(final Class<? extends Annotation> annotation) // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                 RequestHandlerSelectors.basePackage(final String basePackage) // 根据包路径扫描接口
                 */
                .apis(RequestHandlerSelectors.basePackage("com.yuanqiao.controller"))
                .paths(PathSelectors.ant("/user/**"))
                .build();
    }


    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    private ApiInfo apiInfo() {

        String title = "这是我的swagger学习文档";
        String description = "文档中包含所有controller层api的文档";
        String version = "1.0";
        String termsOfServiceUrl = "https://user.qzone.qq.com/34367803";
        Contact contact = new Contact("yuanqiao", "https://user.qzone.qq.com/34367803", "34367803@qq.com");
        String license = "apache license";
        String licenseUrl = "apache license url";
        Collection<VendorExtension> vendorExtensions = new HashSet<>();
        vendorExtensions.add(new VendorExtension() {
            @Override
            public String getName() {
                return "key1";
            }

            @Override
            public Object getValue() {
                return "value1";
            }
        });
        return new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions);
    }
}
