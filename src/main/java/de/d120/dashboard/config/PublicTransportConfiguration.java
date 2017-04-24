package de.d120.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.schildbach.pte.BahnProvider;
import de.schildbach.pte.NetworkProvider;

/**
 * Configures the public transport.
 *
 * @author Fabian Damken
 */
@Configuration
public class PublicTransportConfiguration {
    /**
     * Creates the network provider.
     *
     * @return The newly created network provider.
     */
    @Bean
    public NetworkProvider networkProvider() {
        return new BahnProvider();
    }
}
