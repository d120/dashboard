package de.d120.dashboard.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * A {@link RestTemplateCustomizer} to disable HTTPS certificate verification.
 *
 * @author Fabian Damken
 */
@Component
public class NoHttpsVerificationRestTemplateCustomizer implements RestTemplateCustomizer {
    /**
     * {@inheritDoc}
     *
     * @see org.springframework.boot.web.client.RestTemplateCustomizer#customize(org.springframework.web.client.RestTemplate)
     */
    @Override
    public void customize(final RestTemplate restTemplate) {
        try {
            this.internalCustomize(restTemplate);
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException cause) {
            throw new BeanInitializationException(
                    "Failed to disable HTTPS verification for REST template <" + restTemplate + ">!", cause);
        }
    }

    /**
     * Internal implementation of {@link #customize(RestTemplate)} to wrap
     * exceptions.
     *
     * @param restTemplate
     *            The REST template passed by {@link #customize(RestTemplate)}.
     * @throws KeyManagementException
     *             If any key management error occurs.
     * @throws NoSuchAlgorithmException
     *             If the algorithm was not found.
     * @throws KeyStoreException
     *             If any error occurs in the key store.
     */
    private void internalCustomize(final RestTemplate restTemplate)
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        final TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(final X509Certificate[] certs, final String authType) throws CertificateException {
                return true;
            }
        };
        final SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        final SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();
        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        restTemplate.setRequestFactory(requestFactory);
    }
}
