package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan(basePackages = "io.swagger.api")
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
@PropertySource("classpath:swagger.properties")
@Import(SwaggerUiConfiguration.class)
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-04T22:16:14.748+01:00")
public class SwaggerConfig {
    @Bean
    ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        "Cloud.Finance.Rest",
        "",
        "v1",
        "",
        "",
        "",
        "" );
        return apiInfo;
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

}