package com.graduation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
    @EnableSwagger2
    public class Swagger {

        /**
         * 扫描包路径
         * @return
         */
        @Bean
        public Docket createRestApi() {
            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.graduation"))
                    .paths(PathSelectors.any()).build();
            return docket;
        }


        /**
         * 创建改API的基本信息（这些基本信息会展示在文档页面中）
         * 访问地址： http://项目实际地址/swagger-ui.html
         * @return
         */
        private ApiInfo apiInfo() {
            ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
            apiInfoBuilder.title("酷酷美发系统");
//            apiInfoBuilder.license("查看华宇接口服务许可");
//            apiInfoBuilder.licenseUrl("http://www.thunisoft.com/");
            apiInfoBuilder.description("酷酷美发系统各功能接口");
            apiInfoBuilder.version("V1.0.0");
            return apiInfoBuilder.build();
        }
    }


