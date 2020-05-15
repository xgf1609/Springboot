package com.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")  //选择那些路径和api会生成document
				.select()
				.apis(RequestHandlerSelectors.any()) //对所有api进行监控
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.paths(PathSelectors.regex("/.*"))  //正则通配符
				.build();
				
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("我的接口文档")
				.contact(new Contact("xgf", "", "514763229@qq.com"))
				.description("这是swaggerui生成的接口文档")
				.version("1.0.0")
				.build();
	}

}
