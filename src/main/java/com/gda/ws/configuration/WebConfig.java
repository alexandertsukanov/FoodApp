package com.gda.ws.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        CustomSiteMeshFilter siteMeshFilter = new CustomSiteMeshFilter();
        filter.setFilter(siteMeshFilter);
        return filter;
    }
}
