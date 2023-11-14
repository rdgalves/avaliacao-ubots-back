//package com.code.avaliacao.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.Collections;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.code.avaliacao"))
//                .paths(PathSelectors.ant("/api/*"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "Ubots Avaliação",
//                "projeto de avaliação técnica para Ubots.",
//                "Versão da API",
//                "Termos do serviço",
//                new Contact("Rodrigo Silva", "https://github.com/rdgalves", "rdg.alvess@gmail.com"),
//                "Licença da API",
//                "URL da licença",
//                Collections.emptyList());
//    }
//
//}
