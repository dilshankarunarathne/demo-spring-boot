package me.karunarathne.learningspringboot.clientproxy;

import org.jboss.resteasy.client.jaxrs.ClientHttpEngine;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientBuilder;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
public class ClientProxyConfig {

    @Bean
    public UserResourceV1 getUserResourceV1 () {
        final String userEndPointUrl = "http://localhost:8080/api/v1/users" ;
        ResteasyClient client = new ResteasyClientBuilder() {
            @Override
            public javax.ws.rs.core.Configuration getConfiguration() {
                return null;
            }

            @Override
            public ClientBuilder property(String s, Object o) {
                return null;
            }

            @Override
            public ClientBuilder register(Class<?> aClass) {
                return null;
            }

            @Override
            public ClientBuilder register(Class<?> aClass, int i) {
                return null;
            }

            @Override
            public ClientBuilder register(Class<?> aClass, Class<?>... classes) {
                return null;
            }

            @Override
            public ClientBuilder register(Class<?> aClass, Map<Class<?>, Integer> map) {
                return null;
            }

            @Override
            public ClientBuilder register(Object o) {
                return null;
            }

            @Override
            public ClientBuilder register(Object o, int i) {
                return null;
            }

            @Override
            public ClientBuilder register(Object o, Class<?>... classes) {
                return null;
            }

            @Override
            public ClientBuilder register(Object o, Map<Class<?>, Integer> map) {
                return null;
            }

            @Override
            public ResteasyClientBuilder providerFactory(ResteasyProviderFactory resteasyProviderFactory) {
                return null;
            }

            @Override
            public ResteasyProviderFactory getProviderFactory() {
                return null;
            }

            @Override
            public ResteasyClientBuilder connectionTTL(long l, TimeUnit timeUnit) {
                return null;
            }

            @Override
            public long getConnectionTTL(TimeUnit timeUnit) {
                return 0;
            }

            @Override
            public ResteasyClientBuilder maxPooledPerRoute(int i) {
                return null;
            }

            @Override
            public int getMaxPooledPerRoute() {
                return 0;
            }

            @Override
            public ResteasyClientBuilder connectionCheckoutTimeout(long l, TimeUnit timeUnit) {
                return null;
            }

            @Override
            public long getConnectionCheckoutTimeout(TimeUnit timeUnit) {
                return 0;
            }

            @Override
            public ResteasyClientBuilder connectionPoolSize(int i) {
                return null;
            }

            @Override
            public int getConnectionPoolSize() {
                return 0;
            }

            @Override
            public ResteasyClientBuilder responseBufferSize(int i) {
                return null;
            }

            @Override
            public int getResponseBufferSize() {
                return 0;
            }

            @Override
            public ResteasyClientBuilder disableTrustManager() {
                return null;
            }

            @Override
            public boolean isTrustManagerDisabled() {
                return false;
            }

            @Override
            public void setIsTrustSelfSignedCertificates(boolean b) {

            }

            @Override
            public boolean isTrustSelfSignedCertificates() {
                return false;
            }

            @Override
            public ResteasyClientBuilder hostnameVerification(HostnameVerificationPolicy hostnameVerificationPolicy) {
                return null;
            }

            @Override
            public HostnameVerificationPolicy getHostnameVerification() {
                return null;
            }

            @Override
            public ResteasyClientBuilder httpEngine(ClientHttpEngine clientHttpEngine) {
                return null;
            }

            @Override
            public ClientHttpEngine getHttpEngine() {
                return null;
            }

            @Override
            public ResteasyClientBuilder useAsyncHttpEngine() {
                return null;
            }

            @Override
            public boolean isUseAsyncHttpEngine() {
                return false;
            }

            @Override
            public ResteasyClientBuilder sniHostNames(String... strings) {
                return null;
            }

            @Override
            public List<String> getSniHostNames() {
                return null;
            }

            @Override
            public ResteasyClientBuilder defaultProxy(String s) {
                return null;
            }

            @Override
            public String getDefaultProxyHostname() {
                return null;
            }

            @Override
            public int getDefaultProxyPort() {
                return 0;
            }

            @Override
            public String getDefaultProxyScheme() {
                return null;
            }

            @Override
            public ResteasyClientBuilder defaultProxy(String s, int i) {
                return null;
            }

            @Override
            public ResteasyClientBuilder defaultProxy(String s, int i, String s1) {
                return null;
            }

            @Override
            public ResteasyClientBuilder enableCookieManagement() {
                return null;
            }

            @Override
            public boolean isCookieManagementEnabled() {
                return false;
            }

            @Override
            public SSLContext getSSLContext() {
                return null;
            }

            @Override
            public KeyStore getKeyStore() {
                return null;
            }

            @Override
            public String getKeyStorePassword() {
                return null;
            }

            @Override
            public KeyStore getTrustStore() {
                return null;
            }

            @Override
            public HostnameVerifier getHostnameVerifier() {
                return null;
            }

            @Override
            public long getReadTimeout(TimeUnit timeUnit) {
                return 0;
            }

            @Override
            public long getConnectionTimeout(TimeUnit timeUnit) {
                return 0;
            }

            @Override
            public ResteasyClientBuilder disableAutomaticRetries() {
                return null;
            }

            @Override
            public boolean isDisableAutomaticRetries() {
                return false;
            }

            @Override
            public ResteasyClientBuilder executorService(ExecutorService executorService, boolean b) {
                return null;
            }

            @Override
            public ResteasyClient build() {
                return null;
            }

            @Override
            public ResteasyClientBuilder withConfig(javax.ws.rs.core.Configuration configuration) {
                return null;
            }

            @Override
            public ResteasyClientBuilder sslContext(SSLContext sslContext) {
                return null;
            }

            @Override
            public ResteasyClientBuilder keyStore(KeyStore keyStore, char[] chars) {
                return null;
            }

            @Override
            public ResteasyClientBuilder keyStore(KeyStore keyStore, String s) {
                return null;
            }

            @Override
            public ResteasyClientBuilder trustStore(KeyStore keyStore) {
                return null;
            }

            @Override
            public ResteasyClientBuilder hostnameVerifier(HostnameVerifier hostnameVerifier) {
                return null;
            }

            @Override
            public ResteasyClientBuilder executorService(ExecutorService executorService) {
                return null;
            }

            @Override
            public ResteasyClientBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                return null;
            }

            @Override
            public ResteasyClientBuilder connectTimeout(long l, TimeUnit timeUnit) {
                return null;
            }

            @Override
            public ResteasyClientBuilder readTimeout(long l, TimeUnit timeUnit) {
                return null;
            }

            @Override
            public ResteasyClientBuilder setFollowRedirects(boolean b) {
                return null;
            }

            @Override
            public boolean isFollowRedirects() {
                return false;
            }
        }.build() ;
        ResteasyWebTarget target = client.target(userEndPointUrl) ;
        UserResourceV1 proxy = target.proxy(UserResourceV1.class) ;
        return proxy ;
    }
}
