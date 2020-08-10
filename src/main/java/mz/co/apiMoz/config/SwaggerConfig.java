/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.co.apiMoz.config;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Elton Julio
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    
    @Bean
    public Docket pegiaoApi(){
    return new Docket(DocumentationType.SWAGGER_2 )
    .select()
    .apis(RequestHandlerSelectors.basePackage("mz.co.apiMoz"))
    .paths(PathSelectors.any())
    .build()
    .apiInfo(metaInfo()); 
    }
    


    private ApiInfo metaInfo() {
   
    ApiInfo apiInfo = new ApiInfo(
            "Moz API REST",
            "API REST de distribuição territórial de Moçambique",
            "1.0",
            "Terms of Service",
            new Contact("ZN Systems.Lda","http://www.dem.assa-sistemas.com","elton.cuambe@uem.ac.mz") ,
            "Apache License Version 2.0",
            "https://www.apache.org/licensen.html", new ArrayList<VendorExtension>()
             
    );
      
    return apiInfo;
    
    }
       
}
