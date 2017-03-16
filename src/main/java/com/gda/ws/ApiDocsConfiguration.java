package com.gda.ws;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The ApiDocsConfiguration class provides configuration beans for the Swagger API documentation generator.
 */
@Configuration
@EnableSwagger2
public class ApiDocsConfiguration {

    /**
     * The project version.
     */
    public static final String PROJECT_VERSION = "1.7.2";
    /**
     * The project contact name.
     */
    public static final String PROJECT_CONTACT_NAME = "Your Name.com";
    /**
     * The project contact URL.
     */
    public static final String PROJECT_CONTACT_URL = "http://www.example.com";

    /**
     * Create a Contact class to be used by Springfox's Swagger API Documentation framework.
     * 
     * @return A Contact instance.
     */
    private Contact contact() {
        return new Contact(PROJECT_CONTACT_NAME, PROJECT_CONTACT_URL, null);
    }

    /**
     * Create an ApiInfo class to be used by Springfox's Swagger API Documentation framework.
     * 
     * @return An ApiInfo instance.
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = 
            new ApiInfoBuilder()
                .title("Generic Data Access Project")
                .description("Generic Data Access Project")
                .contact(contact())
                .version(PROJECT_VERSION)
                .build();
        return apiInfo;
    }

    /**
     * Create a Docket class to be used by Springfox's Swagger API Documentation framework. See
     * http://springfox.github.io/springfox/ for more information.
     * 
     * @return A Docket instance.
     */
    @Bean
    public Docket docket() {
        final Predicate<String> paths = PathSelectors.ant("/api/**");
        final Docket docket = 
            new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                    .paths(paths)
                .build();
        return docket;
    }
}
