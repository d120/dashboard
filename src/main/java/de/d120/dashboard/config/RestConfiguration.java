package de.d120.dashboard.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * REST configuration.
 *
 * @author Fabian Damken
 */
@Configuration
public class RestConfiguration {
    /**
     * Creates a REST template.
     *
     * @param builder
     *            The {@link RestTemplateBuilder REST template builder}.
     * @return The newly created {@link RestTemplate}.
     */
    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {
        return builder.build();
    }
}
