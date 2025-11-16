package co.nz.csoft.emt;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.nz.csoft.emt.dto.Availability;
import co.nz.csoft.emt.dto.OTARatesAndAvailabilityDto;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "co.nz.csoft.emt")

public class EmtApplication {
	 
	public static void main(String[] args) {
		SpringApplication.run(EmtApplication.class, args);
		Availability ava=new Availability();
		//System.out.println(ava.toString());
		OTARatesAndAvailabilityDto otaav=new OTARatesAndAvailabilityDto();
		//System.out.println(otaav);
	}
	@Configuration
	@EnableSwagger2
	public class SwaggerConfig {
		private ApiInfo apiInfo() {
			return new ApiInfo("BookOne EaseMyTrip API", "BookOne EaseMyTrip API ",
					"v1", "CredenceSoft's Fair Usage Policy",
					new Contact("CredenceSoft Limited", "https://www.credencesoft.co.nz",
							"samaya.muduli@credencesoft.co.nz"),
					"License of API", "API license URL", Collections.emptyList());
		}

		@Bean
		public Docket mmtApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("co.nz.csoft.emt.controller"))
					.paths(PathSelectors.ant("/api/**")).build().groupName("Emt").apiInfo(apiInfo());
		}
		
		@Bean
		public Docket ariApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("co.nz.csoft.emt.controller"))
					.paths(PathSelectors.ant("/api/suphotel/save/**")).build().groupName("ARI").apiInfo(apiInfo());
		}

	}

	@Configuration
	@EnableWebMvc
	public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
	}
	
}
