package com.gda.ws.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/WEB-INF/templates/default.jsp")
                .addDecoratorPath("/login", "/WEB-INF/templates/login.jsp")
                .addExcludedPath("/javadoc/*")
                .addExcludedPath("/brochures/*");
    }
}
