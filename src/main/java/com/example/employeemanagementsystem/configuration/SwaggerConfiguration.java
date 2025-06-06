package com.example.employeemanagementsystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class SwaggerConfiguration implements WebMvcConfigurer {
    
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.employeemanagementsystem.controller"))
			.paths(PathSelectors.regex("/.*"))
			.build();
	}
	
	private ApiInfo apiInformation() {
		return new ApiInfoBuilder().title("My Rest API's")
				.description("Rest API's for CRUD Operation")
				.contact(new Contact("Mysql", "mysql://localhost:3306/springhiber", "tauheed1patel@gmail.com"))
				.license("Apache 2.0")
				.version("1.0.0")
				.build();
	}
}
