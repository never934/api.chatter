package com.tastyeem.apichatter

import com.google.common.base.Predicates
import io.swagger.annotations.Api
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@SpringBootApplication
class Application {
	@Bean
	fun apiInfo(): ApiInfo {
		val builder = ApiInfoBuilder()
		builder
				.title("Chatter")
				.version("1.0")
				.license("(C) Andrey Eremenko")
				.description("API of Chatter");
		return builder.build();
	}

	@Bean
	fun api(): Docket {
		return Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(this.javaClass.packageName))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(apiInfo()).useDefaultResponseMessages(false)
	}
}
	fun main(args: Array<String>) {
		runApplication<Application>(*args)
	}


