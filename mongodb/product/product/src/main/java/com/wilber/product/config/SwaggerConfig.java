package com.wilber.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wilber.product"))
                //.paths(PathSelectors.any())
                .paths(PathSelectors.regex("/produto.*"))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Produtos API Rest",
                "API REST cadastro de produtos",
                "v1",
                "Termos de serviço API",
                new Contact("Wilian", "https://product-wilber-mongodb.azurewebsites.net",
                        "email.com.br"),
                "Licenca API",
                "Licenca URL",
                new ArrayList<VendorExtension>());
    }
}
