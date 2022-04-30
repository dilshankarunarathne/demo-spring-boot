package me.karunarathne.learningspringboot.clientproxy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientProxyConfig {
    public UserResourceV1 getUserResourceV1 () {
        ResteasyClient client = new ResteasyClientBuilder()
    }
}
