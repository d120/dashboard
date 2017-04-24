package de.d120.dashboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web configuration.
 *
 * @author Fabian Damken
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    /**
     * {@inheritDoc}
     *
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/public/", "classpath:/static/");
        registry.addResourceHandler("/*").addResourceLocations("classpath:/favicon/");
    }
}
