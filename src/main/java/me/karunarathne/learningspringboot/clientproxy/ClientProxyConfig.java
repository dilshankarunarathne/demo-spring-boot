package me.karunarathne.learningspringboot.clientproxy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientProxyConfig {
    public UserResourceV1 getUserResourceV1 () {
        final String userEndPointUrl = "http://localhost:8080/api/v1/users" ;
        ResteasyClient client = new ResteasyClientBuilder().build() ;
        ResteasyWebTarget target = client.target(userEndPointUrl) ;
        return target.proxy(UserResourceV1.class) ;
    }
}
