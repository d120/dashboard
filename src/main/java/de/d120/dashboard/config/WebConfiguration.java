package de.d120.dashboard.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import lombok.val;

/**
 * Web configuration.
 *
 * @author Fabian Damken
 */
@Configuration
@SuppressWarnings("javadoc")
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Value("${frontend.departures.interval}")
    private int frontendDeparturesInterval;
    @Value("${frontend.departures.station-name}")
    private String frontendDeparturesStationName;
    @Value("${frontend.departures.time.critical}")
    private int frontendDeparturesStationTravelTimeCritical;
    @Value("${frontend.departures.time.warning}")
    private int frontendDeparturesStationTravelTimeWarning;
    @Value("${frontend.pizza.interval}")
    private int frontendPizzaInterval;
    @Value("${frontend.cafeteria.interval}")
    private int frontendCafeteriaInterval;
    @Value("${frontend.news.switch-interval}")
    private int frontendNewsSwitchInterval;

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

    /**
     * Creates freemarker configuration.
     *
     * @return The configuration.
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        val configurer = new FreeMarkerConfigurer();
        final Map<String, Object> properties = new HashMap<>();
        properties.put("departuresInterval", this.frontendDeparturesInterval);
        properties.put("departuresStationName", this.frontendDeparturesStationName);
        properties.put("departuresStationTravelTimeCritical", this.frontendDeparturesStationTravelTimeCritical);
        properties.put("departuresStationTravelTimeWarning", this.frontendDeparturesStationTravelTimeWarning);
        properties.put("pizzaInterval", this.frontendPizzaInterval);
        properties.put("cafeteriaInterval", this.frontendCafeteriaInterval);
        properties.put("newsSwitchInterval", this.frontendNewsSwitchInterval);
        configurer.setFreemarkerVariables(properties);
        configurer.setTemplateLoaderPaths("classpath:/templates");
        return configurer;
    }
}
