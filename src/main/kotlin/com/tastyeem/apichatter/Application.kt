package com.tastyeem.apichatter

import com.tastyeem.apichatter.filters.JWTAuthorizationFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
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

	@EnableWebSecurity
	@Configuration
	internal class WebSecurityConfig : WebSecurityConfigurerAdapter() {
		@Throws(Exception::class)
		override fun configure(http: HttpSecurity) {
			http.csrf().disable()
				.addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
				.authorizeRequests()
				.antMatchers("/v1/nologin/*",
					"/v2/api-docs",
					"/configuration/ui",
					"/swagger-resources/**",
					"/configuration/security",
					"/swagger-ui.html",
					"/webjars/**")
				.permitAll()
				.anyRequest().authenticated()
		}
	}

}

fun main(args: Array<String>) {
		runApplication<Application>(*args)
}




