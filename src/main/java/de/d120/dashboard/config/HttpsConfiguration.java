package de.d120.dashboard.config;

import javax.annotation.PostConstruct;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/**
 * HTTPS configuration.
 *
 * @author Fabian Damken
 */
// @Configuration
public class HttpsConfiguration {
    /**
     * Invoked after the bean was created.
     *
     */
    @PostConstruct
    public void onPostConstruct() {
        // Turn of HTTPS host name verification.
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(final String hostname, final SSLSession session) {
                return true;
            }
        });
    }
}
