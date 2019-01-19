package io.openshift.booster;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@PropertySource("classpath:swagger.properties")
public class SwaggerConfiguration {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .paths(PathSelectors.regex("/api/.*"))
            .build()
            .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Sample Spring Boot REST API")
            .description("Operations that can be invoked in the sample boot microservices")
            .contact(new Contact("Serhat Dirik", "http://developers.redhat.com", "serhat@redhat.com"))
            .license("Apache License Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }

}